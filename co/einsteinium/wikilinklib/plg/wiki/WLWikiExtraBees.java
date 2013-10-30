package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiExtraBees implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("ExtraBees");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "extrabees.wikidot.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Extra Bees Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.WIKIDOT;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
