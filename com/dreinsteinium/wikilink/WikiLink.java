package com.dreinsteinium.wikilink;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.dreinsteinium.wikilink.cfg.ConfigHandler;
import com.dreinsteinium.wikilink.net.CommonProxy;
import com.dreinsteinium.wikilink.net.ConnectionHandler;
import com.dreinsteinium.wikilink.plg.PluginManager;
import com.dreinsteinium.wikilink.run.bind.WorldInspection;
import com.dreinsteinium.wikilink.run.cmd.ReloadCommand;
import com.dreinsteinium.wikilink.util.PacketHandler;
import com.dreinsteinium.wikilink.web.link.Link;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	
	public static Logger LogHelper;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	    
		LogHelper = Logger.getLogger("WikiLink");
		LogHelper.setParent(FMLLog.getLogger());
		
        ConfigHandler.init(event.getSuggestedConfigurationFile());
				
        WikiLink.LogHelper.info("WikiLink is now setting up the Plugin data needed during runtime.");
        long start1 = System.currentTimeMillis();
            PluginManager.INSTANCE.loadPlugins(event.getSourceFile());          
        LogHelper.info(String.format("WikiLink took %s milliseconds to load %s plugin(s).", System.currentTimeMillis() - start1, PluginManager.INSTANCE.plugins.size()));
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
        
        LogHelper.info("WikiLink is now setting up the ItemData mapping needed during runtime.");
        long start2 = System.currentTimeMillis();
            Link.buildmodIdItemIdHashMap();
        LogHelper.info(String.format("WikiLink took %s milliseconds to create %s item mappings.", System.currentTimeMillis() - start2, Link.modIdItemIdMapping.size()));
        
        WikiLink.LogHelper.info("WikiLink is now setting up the Youtube data needed during runtime.");
        long start1 = System.currentTimeMillis();
            PluginManager.INSTANCE.loadPostInitPlgs();      
        LogHelper.info(String.format("WikiLink took %s milliseconds to load %s video list(s).", System.currentTimeMillis() - start1, PluginManager.INSTANCE.postInitPlgs.size()));
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
	    event.registerServerCommand(new ReloadCommand());
	}
	
}
