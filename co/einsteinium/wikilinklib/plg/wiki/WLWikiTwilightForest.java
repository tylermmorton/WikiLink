package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiTwilightForest implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("TwilightForest");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "twilightforest.wikispaces.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Twilight Forest Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.WIKISPACES;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
