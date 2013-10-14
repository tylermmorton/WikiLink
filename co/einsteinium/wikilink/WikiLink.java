package co.einsteinium.wikilink;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.net.CommonProxy;
import co.einsteinium.wikilink.net.ConnectionHandler;
import co.einsteinium.wikilink.net.PacketHandler;
import co.einsteinium.wikilink.plg.PluginManager;
import co.einsteinium.wikilink.util.LibraryHandler;
import co.einsteinium.wikilink.util.UpdateHandler;
import co.einsteinium.wikilink.util.VersionHandler;
import co.einsteinium.wikilink.wiki.Link;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

/** WikiLink
 *
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = {Reference.MOD_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class WikiLink
{
    @Instance(Reference.MOD_ID)
    public static WikiLink instace;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT_LOC, serverSide = Reference.PROXY_COMMON_LOC)
    public static CommonProxy proxy;

    public static Logger LogHelper;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException, ClassNotFoundException
    {
    	LogHelper = Logger.getLogger(Reference.MOD_ID);
        LogHelper.setParent(FMLLog.getLogger());  
        
    	ConfigHandler.init(event.getSuggestedConfigurationFile());  
    	
    	File dir = new File(proxy.getModRoot() + "/mods/WikiLink");
    		if(!dir.exists())
    		{
    			dir.mkdir();
    			LogHelper.info("Creating dir: " + dir.getAbsolutePath());
    			
    			UpdateHandler.download(dir);
    		}
    		else
    		{
    			UpdateHandler.update(dir);
    		}
    		
    	LibraryHandler.loadLibClasses(dir);
        
        LogHelper.info("Loading Outsourced Extensions...");
        PluginManager.INSTANCE.loadPlugins(event.getSourceFile());
    }

    @EventHandler
    public void mainInit(FMLInitializationEvent event)
    {
        WikiLink.LogHelper.info("Recieving Outsourced Data...");
        PluginManager.INSTANCE.initConfigs();
        PluginManager.INSTANCE.initPlugins();
        NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
        
        try{VersionHandler.getWikiLinkVersionFromWeb();} 
        catch(Exception e){e.printStackTrace();}
			
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	// Build the hash map of item data needed for every item in game.
    	Link.buildItemDataHashMap();
    }
    
    @EventHandler
    public void serverInit(FMLServerStartingEvent event)
    {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager serverCommand = ((ServerCommandManager) command);
    }

}
