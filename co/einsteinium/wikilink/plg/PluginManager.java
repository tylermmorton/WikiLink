package co.einsteinium.wikilink.plg;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.api.Plugin;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/** PluginManager
 * 
 * @since 1.6.2-015
 * @author ScottKillen - Modified by DrEinsteinium
 *
 */
public enum PluginManager 
{

    INSTANCE;

    private static void addPlugin(final ClassLoader classLoader, final String pluginName,
            final String packageName)
    {
        if (pluginName.equals("PluginManager.class") || pluginName.equals("Plugin.class")) return;
        final String pluginClassName = packageName.replace(".class", "");
        try
        {
            final Class<?> pluginClass = classLoader.loadClass(pluginClassName);
            if (pluginClass != null)
            {
                Class<?> clz = pluginClass;
                boolean isPlugin = false;
                do
                {
                    for (final Class<?> i : clz.getInterfaces())
                        if (i == Plugin.class)
                        {
                            isPlugin = true;
                            break;
                        }
                    clz = clz.getSuperclass();
                }
                while (clz != null && !isPlugin);

                if (!isPlugin) return;
                final Plugin plugin = (Plugin) pluginClass.newInstance();
                if (plugin != null)
                {
                    INSTANCE.plugins.add(plugin);

                    if (plugin instanceof IFuelHandler)
                        GameRegistry.registerFuelHandler((IFuelHandler) plugin);
                }
            }
        }
        catch (final Exception ex)
        {}
    }

    /** listDefaults is a small listWriter that adds the default
     *  wikis to the list first so they are are the first indexes.
     
	public void listDefaults()
	{
		Reference.modKeyList.add(ConfigHandler.defaultWikiKey);
		Reference.modNameList.add(ConfigHandler.defaultWikiName);
		Reference.modIdList.add(ConfigHandler.defaultWikiModId);
		Reference.modDomainList.add(ConfigHandler.defaultWikiDomain);
		Reference.modSoftwareList.add(ConfigHandler.defaultWikiSoftware);

		System.out.println("[WikiLink] Loading the strings required for the Default Wiki");
	}*/
    
    public void initPlugins()
    {

    	for (Plugin plugin: plugins)
    	{
    		if(Reference.modKeyList.contains(plugin.getWikiKey()))
    		{
    			WikiLink.LogHelper.info("Can not load strings from " + plugin.getWikiName() + ". Please change getWikiKey!");
    		}
    		if(Reference.modIdList.contains(plugin.getModID()))
    		{
    			WikiLink.LogHelper.info("Can not load strings from " + plugin.getWikiName() + ". Please change getModKey!");
    		}
    		else
    		{
    			Reference.modIdList.add(plugin.getModID());    			
    			Reference.modKeyList.add(plugin.getWikiKey());
   				Reference.modNameList.add(plugin.getWikiName());
    			Reference.modDomainList.add(plugin.getWikiDomain());
    			Reference.modSoftwareList.add(plugin.getWikiSoftware());
    			
    			WikiLink.LogHelper.info("Loading the strings required from " + plugin.getWikiName());
    		}
    		
    	}
    }

    private static void loadExternalPlugins(final File modLocation)
    {
        try
        {
            final File pluginDir = new File(co.einsteinium.wikilink.WikiLink.proxy.getModRoot() + "/mods");
            final ClassLoader classLoader = WikiLink.class.getClassLoader();

            if (!pluginDir.isDirectory()) return;
            final File[] fileList = pluginDir.listFiles();
            if (fileList == null) return;
            for (final File file : fileList)
                if (file.isFile())
                    if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip"))
                        if (!file.getName().equals(modLocation.getName()))
                            loadPluginsFromFile(file, classLoader);
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
        }

    }

    private static void loadIncludedPlugins(final File modLocation)
    {
        final ClassLoader classLoader = WikiLink.class.getClassLoader();

        if (modLocation.isFile()
                && (modLocation.getName().endsWith(".jar") || modLocation.getName()
                        .endsWith(".zip"))) loadPluginsFromFile(modLocation, classLoader);
        else if (modLocation.isDirectory()) loadPluginsFromBin(modLocation, classLoader);
    }

    private static void loadPluginsFromBin(final File bin, final ClassLoader classLoader)
    {
        final File[] fileList = bin.listFiles();

        if (fileList != null)
            for (final File file : fileList)
            {
                final String pluginName = file.getName();
                if (file.isFile() && pluginName.startsWith("Plugin")
                        && pluginName.endsWith(".class")) addPlugin(classLoader, pluginName,
                        parseClassName(file.getPath()));
                else if (file.isDirectory()) loadPluginsFromBin(file, classLoader);
            }
    }

    private static void loadPluginsFromFile(final File file, final ClassLoader classLoader)
    {
        try
        {
            ZipEntry entry = null;
            final FileInputStream fileIO = new FileInputStream(file);
            final ZipInputStream zipIO = new ZipInputStream(fileIO);
            while (true)
            {
                entry = zipIO.getNextEntry();

                if (entry == null)
                {
                    fileIO.close();
                    break;
                }

                final String entryName = entry.getName();
                final File entryFile = new File(entryName);
                final String pluginName = entryFile.getName();
                if (!entry.isDirectory() && pluginName.startsWith("Plugin")
                        && pluginName.endsWith(".class"))
                    addPlugin(classLoader, pluginName,
                            entryFile.getPath().replace(File.separatorChar, '.'));
            }
        }
        catch (final Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private static String parseClassName(final String binpath)
    {
        final String[] tokens = binpath.split("\\\\");
        String packageName = "";

        for (int i = 0; i < tokens.length && tokens[i] != null; i++)
            if (tokens[i].equals("bin"))
            {
                for (int j = i + 1; j < tokens.length; j++)
                {
                    if (packageName.length() > 0) packageName = packageName + ".";
                    packageName = packageName + tokens[j];
                }
                break;
            }
        return packageName;
    }

    private final List<Plugin> plugins = Lists.newArrayList();

    public void loadPlugins(final File modLocation)
    {
        loadIncludedPlugins(modLocation);
        loadExternalPlugins(modLocation);
    }
}