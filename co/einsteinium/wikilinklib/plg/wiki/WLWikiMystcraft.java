package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiMystcraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Mystcraft");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{

		return "binarymage.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Mystcraft Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.CUSTOM;
	}

	@Override
	public String getCustomSearchString()
	{
		//return "/wiki/doku.php?do=search&id=";
		return null;
	}

}
