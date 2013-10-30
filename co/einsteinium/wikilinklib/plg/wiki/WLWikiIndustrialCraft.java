package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiIndustrialCraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("IC2");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "wiki.industrial-craft.net";
	}

	@Override
	public String getWikiDisplay()
	{
		return "IndustrialCraft Wiki";
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
