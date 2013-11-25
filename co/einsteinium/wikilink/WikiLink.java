package co.einsteinium.wikilink;

import java.io.IOException;
import java.util.logging.Logger;

import net.buildlight.webd.api.WDAPI;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.gui.font.FontRegistry;
import co.einsteinium.wikilink.key.WorldInspection;
import co.einsteinium.wikilink.link.Link;
import co.einsteinium.wikilink.net.CommonProxy;
import co.einsteinium.wikilink.net.ConnectionHandler;
import co.einsteinium.wikilink.net.PacketHandler;
import co.einsteinium.wikilink.plg.PluginManager;
import co.einsteinium.wikilink.util.VersionHandler;
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
    public static boolean isWebDisplay;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException, ClassNotFoundException
    {
    	LogHelper = Logger.getLogger("WikiLink");
        LogHelper.setParent(FMLLog.getLogger( ));  
        
        ConfigHandler.init(event.getSuggestedConfigurationFile());  
        PluginManager.INSTANCE.loadPlugins(event.getSourceFile());
        
        if(isWebDisplay = WDAPI.isWebDisplaysLoaded())
        {LogHelper.info("Oh hey there WebDisplays. I have some stuff for you!");
        	if(WDAPI.init())
        	{LogHelper.info("WikiLink is now setting up WebDisplays integration. >:3");
        		
        		
        	}
        }
        else LogHelper.info("WikiLink could not find WebDisplay in the mods folder. "
        				  + "You should like, totally install it so we can do awesome stuff.");
    }

    @EventHandler
    public void mainInit(FMLInitializationEvent event) throws Exception
    {      	
    	VersionHandler.getWikiLinkVersionFromWeb();
        NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
        
        KeyBinding[] key = {new KeyBinding("WikiLink Menu", Keyboard.KEY_I)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new WorldInspection(key, repeat));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	FontRegistry.initFonts();
    	Link.buildmodIdItemIdHashMap();
   
    }
}
