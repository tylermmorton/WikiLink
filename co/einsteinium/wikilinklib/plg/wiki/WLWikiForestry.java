package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiForestry implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Forestry");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "forestry.sengir.net";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Forestry Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.CUSTOM;
	}

	@Override
	public String getCustomSearchString()
	{
		return "/wiki.new/doku.php?do=search&id=";
	}

}
