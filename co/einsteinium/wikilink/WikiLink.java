package co.einsteinium.wikilink;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.net.CommonProxy;
import co.einsteinium.wikilink.net.ConnectionHandler;
import co.einsteinium.wikilink.net.PacketHandler;
import co.einsteinium.wikilink.plg.PluginManager;
import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.util.VersionHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
	public void preInit(FMLPreInitializationEvent event)
	{	
		LogHelper = Logger.getLogger(Reference.MOD_ID);
		LogHelper.setParent(FMLLog.getLogger());
	
		LogHelper.info("Loading Configurations...");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
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
	
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager serverCommand = ((ServerCommandManager) command);
	}
	
}
