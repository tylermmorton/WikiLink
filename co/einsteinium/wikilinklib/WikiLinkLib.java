package co.einsteinium.wikilinklib;

import co.einsteinium.wikilinklib.util.UpdateHandler;
import co.einsteinium.wikilink.net.CommonProxy;
import co.einsteinium.wikilink.net.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = LibReference.MOD_ID, name = LibReference.MOD_NAME, version = LibReference.MOD_VERSION)
@NetworkMod(channels = {LibReference.MOD_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class WikiLinkLib
{
    @Instance(LibReference.MOD_ID)
    public static WikiLinkLib instace;

    @SidedProxy(clientSide = LibReference.PROXY_CLIENT_LOC, serverSide = LibReference.PROXY_COMMON_LOC)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        event.getModMetadata().parent = ("WikiLink");
        UpdateHandler.updateLibrary();
    }
}
