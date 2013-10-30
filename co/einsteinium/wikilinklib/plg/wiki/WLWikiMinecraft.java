package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiMinecraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Minecraft");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "minecraftwiki.net";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Minecraft Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.MEDIAWIKI;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
