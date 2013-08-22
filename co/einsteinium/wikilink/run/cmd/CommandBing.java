package co.einsteinium.wikilink.run.cmd;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.BrowserHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

/** CommandBing
 * 
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */
public class CommandBing extends CommandBase
{

	@Override
	public String getCommandName() 
	{
		return "bing";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/bing <search term>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] inputArray) 
	{
		
		StringBuilder hyperlinkBuilder = new StringBuilder();
		for(int i = 0; i < inputArray.length; i++)
		{
			hyperlinkBuilder.append(inputArray[i] + "+");
		}
		
		String hyperlink = "http://" + "www.bing.com" + "/search?q=" + hyperlinkBuilder.toString();
		
		if(!hyperlinkBuilder.toString().equals(""))
		{
			BrowserHandler.browserInit(hyperlink);	
		}
		else
		WikiLink.LogHelper.warning("Can not run command. No input.");
	}

}
