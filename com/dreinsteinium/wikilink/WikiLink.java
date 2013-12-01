package com.dreinsteinium.wikilink;

import java.util.logging.Logger;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.dreinsteinium.wikilink.key.WorldInspection;
import com.dreinsteinium.wikilink.net.CommonProxy;
import com.dreinsteinium.wikilink.util.PacketHandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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
		
		event.getModMetadata().name = Reference.MOD_NAME;
		event.getModMetadata().version = Reference.MOD_MINIVER;
		event.getModMetadata().authorList.add("DrEinsteinium");
	}
	
	@EventHandler
	public void mainInit(FMLInitializationEvent event)
	{
		LogHelper.info("This is WikiLink Version " + Reference.MOD_VERSION);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
        KeyBinding[] key = {new KeyBinding("WikiLink Menu", Keyboard.KEY_I)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new WorldInspection(key, repeat));
	}
}
