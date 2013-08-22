package co.einsteinium.wikilink.run.cmd;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.BrowserHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

/** CommandWiki
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class CommandWiki extends CommandBase
{

	@Override
	public String getCommandName() 
	{
		return "wiki";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/wiki <search term>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] inputArray) 
	{
		if(Reference.modKeyList.contains(inputArray[0]))
		{
			int x = Reference.modKeyList.indexOf(inputArray[0]);
			
			StringBuilder hyperlinkBuilder = new StringBuilder();
			for(int i = 1; i < inputArray.length; i++)
			{
				hyperlinkBuilder.append(inputArray[i] + "+");
			}
			
			String hyperlink = "http://" + Reference.modDomainList.get(x) + Reference.getSearchQuery(x) + hyperlinkBuilder.toString();
			
			if(!hyperlinkBuilder.toString().equals(""))
			{
				BrowserHandler.browserInit(hyperlink);	
			}
			else
			WikiLink.LogHelper.warning("Can not run command. No input.");
		}
		else if(inputArray[0].equals("debug"))
		{
			WikiLink.LogHelper.info(Reference.modIdList.toString());
			WikiLink.LogHelper.info(Reference.modKeyList.toString());
			WikiLink.LogHelper.info(Reference.modNameList.toString());
			WikiLink.LogHelper.info(Reference.modDomainList.toString());
			WikiLink.LogHelper.info(Reference.modSoftwareList.toString());
			WikiLink.LogHelper.info(Reference.modLocalizationList.toString());
		}
		else
		{
			StringBuilder hyperlinkBuilder = new StringBuilder();
			for(int i = 0; i < inputArray.length; i++)
			{
				hyperlinkBuilder.append(inputArray[i] + "+");
			}
			
			String hyperlink = "http://" + Reference.modDomainList.get(0) + Reference.getSearchQuery(0) + hyperlinkBuilder.toString();
			
			BrowserHandler.browserInit(hyperlink);
		}
	}

}
