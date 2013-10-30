package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiComputerCraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("ComputerCraft");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "computercraft.info/wiki";
	}

	@Override
	public String getWikiDisplay()
	{
		return "ComputerCraft Wiki";
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
