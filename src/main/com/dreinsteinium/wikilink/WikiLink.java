package com.dreinsteinium.wikilink;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.dreinsteinium.wikilink.cfg.ConfigHandler;
import com.dreinsteinium.wikilink.net.CommonProxy;
import com.dreinsteinium.wikilink.net.ConnectionHandler;
import com.dreinsteinium.wikilink.plg.PluginManager;
import com.dreinsteinium.wikilink.plg.PluginRegistrar;
import com.dreinsteinium.wikilink.run.bind.WorldInspection;
import com.dreinsteinium.wikilink.util.PacketHandler;
import com.dreinsteinium.wikilink.util.UpdateHandler;
import com.dreinsteinium.wikilink.web.WebHelper;
import com.dreinsteinium.wikilink.web.link.Link;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

/** WikiLink<br>
 *  Minecraft Modification that bridges the
 *  information gap between different wikis
 *  and the corresponding mods.
 *  <br>
 *  Also adds support for various different
 *  sources such as YouTube and Google.
 *  
 *  @since  8/12/2013
 *  @author DrEinsteinium
 *  **/

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = {Reference.MOD_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class WikiLink
{
	@Instance(Reference.MOD_ID)
	public static WikiLink instance;
	
	@SidedProxy(clientSide = Reference.PROXY_CLIENT_LOC, serverSide = Reference.PROXY_COMMON_LOC)
	public static CommonProxy proxy;
	
	public static File configDir;
	public static Logger LogHelper;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	    
		LogHelper = Logger.getLogger("WikiLink");
		LogHelper.setParent(FMLLog.getLogger());
		
		Reference.CFGROOT = new File(event.getModConfigurationDirectory() + "\\WikiLink");		
        ConfigHandler.init(new File(Reference.CFGROOT + "\\WikiLink.cfg"));
        
        
        // Populate the plugin files and if they don't exist, make them.         
        String[] names = {"wiki","youtube","thread","website"};
        try
        {            
            for(String str : names)
            {if(!(new File(configDir + "\\plugin\\data_" + str + ".yml").isFile()))
                {File plugindirs;           
                    if(!(plugindirs = new File(Reference.CFGROOT + "\\plugin")).isDirectory())                   
                         plugindirs.mkdirs();
                    
                    File file = new File(Reference.CFGROOT + "\\plugin\\data_" + str + ".yml");
                        if(file.createNewFile())
                        {WikiLink.LogHelper.info("Created new file @ " + file.getAbsolutePath());
                         BufferedWriter up = new BufferedWriter(new FileWriter(file));
                             up.write("version: unk" + System.getProperty("line.separator"));
                             up.write("updater: " + Reference.WIKILINKLIB_GIT + file.getName() + System.getProperty("line.separator"));
                             up.write("---" + System.getProperty("line.separator"));
                         up.close();
                        }                           
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {   WikiLink.LogHelper.info("Checking for Updated Versions of the YAML Libraries.");               
            for(String str : names)   
            {
                File file = new File(Reference.CFGROOT + "\\plugin\\data_" + str + ".yml");
                UpdateHandler.updateLib(file);             
            }    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
 	}
	
	@EventHandler
	public void mainInit(FMLInitializationEvent event)
	{
		LogHelper.info("This is WikiLink Version " + Reference.MOD_VERSION);
        NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
        KeyBinding[] key = {new KeyBinding("WikiLink Menu", Keyboard.KEY_I)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new WorldInspection(key, repeat));
        
        {
        LogHelper.info("WikiLink is now setting up the ItemData mapping needed during runtime.");
        long timer = System.currentTimeMillis();
            Link.buildmodIdItemIdHashMap();
        LogHelper.info(String.format("WikiLink took %s milliseconds to create %s item mappings.", System.currentTimeMillis() - timer, Link.modIdItemIdMapping.size()));     
        }    

        try
        {
            LogHelper.info("WikiLink is now setting up the PluginData mappings needed during runtime.");
            long timer = System.currentTimeMillis();
            
            for(File file : new File(Reference.CFGROOT + "\\plugin").listFiles())
            {if(file.getName().startsWith("data_") && file.getName().endsWith(".yml"))
                {
                    if(file.getName().equals("data_wiki.yml"))
                       PluginManager.parseWiki(file);
                    else if(file.getName().equals("data_thread.yml"))
                       PluginManager.parseThread(file);
                    else if(file.getName().equals("data_youtube.yml"))
                       PluginManager.parseYoutube(file);
                    else if(file.getName().equals("data_website.yml"))
                       PluginManager.parseWebsite(file);
                }
            }
            
            LogHelper.info(String.format("WikiLink took %s milliseconds to load all of the plugin(s) needed during runtime.", System.currentTimeMillis() - timer));     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        
        // Check for @ModIds that may be incorrect. 
        // If we know that the mod is loaded, it might be
        // that the @ModId is misspelled or incorrect, which
        // makes data debugging easier! :)
        if(ConfigHandler.debugMode)
        {ArrayList<String> tempList = PluginRegistrar.getWikiIdMap();
            for(Map.Entry entry : Link.modIdItemIdMapping.entrySet())
              for(int i = 0; i < tempList.size(); i++)
                  if(tempList.get(i).equals(entry.getValue()))
                     tempList.remove(i);
            
            for(String id : tempList)
              WikiLink.LogHelper.warning(String.format("The @ModId %s may be incorrect or just not loaded.", id));            
        }
        
        // Check for YouTube links that might be dead
        // or in need of repair. Don't ask me why, but
        // sometimes YouTube links die out...
        if(ConfigHandler.debugMode)
        {ArrayList<String> tempList = PluginRegistrar.getYoutubeCodeList();
            for(int i = 0; i < tempList.size(); i++)
              if(WebHelper.getResponse("www.youtube.com/watch?v=" + tempList.get(i)) == null)
                tempList.remove(i);
                
            for(String str : tempList)
                WikiLink.LogHelper.warning(String.format("The YouTube link %s is a dead code. Please send a message to "
                        + "@DrEinsteinium to tell him about this.", str));
        }
        
	}
}
