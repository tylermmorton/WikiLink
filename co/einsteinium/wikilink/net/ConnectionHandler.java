package co.einsteinium.wikilink.net;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import co.einsteinium.wikilink.util.VersionHandler;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler
{
    @Override
    public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login)
    {
    }

    //////////////////////////////////////////////////////////////
    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager)
    {
        try
        {
        	if(VersionHandler.getWikiLinkVersionFromWeb())
        	{
        		netHandler.getPlayer().addChatMessage("\u00A76[\u00A7aWikiLink\u00A76]\u00A7c WikiLink is out of date for your Minecraft version. Please update at www.catacombs.co for the latest version.");
        	}
        }
        catch (Exception e)
        {
            e.printStackTrace();
            netHandler.getPlayer().addChatMessage("\u00A76[\u00A7aWikiLink\u00A76]\u00A74 There was a problem while checking the version of WikiLink. Please report this at \u00A79www.catacombs.co/contact-me/");
        }
        
        //if(netHandler.getPlayer().username.equals("DrEinsteinium"))
       // {
        	EntityPlayer player2 = netHandler.getPlayer();
        	
        	player2.username.equals("Amazing Person");
        //}
        
    }

    @Override
    public String connectionReceived(NetLoginHandler netHandler,
                                     INetworkManager manager)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler, String server,
                                 int port, INetworkManager manager)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler,
                                 MinecraftServer server, INetworkManager manager)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void connectionClosed(INetworkManager manager)
    {
        // TODO Auto-generated method stub
    }
}
