package co.einsteinium.wikilink;

import java.io.IOException;
import java.util.logging.Logger;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import co.einsteinium.wikilink.api.Software;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.link.Link;
import co.einsteinium.wikilink.net.CommonProxy;
import co.einsteinium.wikilink.net.ConnectionHandler;
import co.einsteinium.wikilink.net.PacketHandler;
import co.einsteinium.wikilink.plg.PluginManager;
import co.einsteinium.wikilink.plg.PluginRegistry;
import co.einsteinium.wikilink.util.VersionHandler;
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
    	
       PluginRegistry.registerWikiLink("Default", ConfigHandler.defaultWikiDomain, ConfigHandler.defaultWikiDisplay, ConfigHandler.getSoftware(), ConfigHandler.defaultCustomWikiSearchString);
    	
       
       // LogHelper.info("Loading Outsourced Extensions...");
       PluginManager.INSTANCE.loadPlugins(event.getSourceFile());
       
       LogHelper.info(PluginRegistry.getWikiDisplayMap().toString());
       LogHelper.info(PluginRegistry.getCustomWikiSoftwareMap().toString());
       
       LogHelper.info(PluginRegistry.getItemSpotlightMap().toString());
    }

    @EventHandler
    public void mainInit(FMLInitializationEvent event)
    {      	
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
