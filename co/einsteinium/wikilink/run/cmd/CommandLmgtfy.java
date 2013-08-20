package co.einsteinium.wikilink.run.cmd;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.BrowserHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

/** CommandLmgtfy
 * 
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */
public class CommandLmgtfy extends CommandBase
{

	public static String hyperlink;
	
	@Override
	public String getCommandName() 
	{
		return "lmgtfy";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/lmgtfy <search term>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] inputArray) 
	{
		StringBuilder hyperlinkBuilder = new StringBuilder();
		for(int i = 0; i < inputArray.length; i++)
		{
			hyperlinkBuilder.append(inputArray[i] + "+");
		}
		
		hyperlink = "http://" + "www.lmgtfy.com" + "/?q=" + hyperlinkBuilder.toString();
		
		if(!hyperlinkBuilder.toString().equals(""))
		{
			BrowserHandler.browserInit(hyperlink);	
			WikiLink.LogHelper.info("Opening " + hyperlink);
		}
		else
		WikiLink.LogHelper.warning("Can not run command. No input.");
	}
	
	public static void playerTick(EntityPlayer player)
	{
		// needs to be replaced with a public msg?
		player.addChatMessage(hyperlink);
	}

}
