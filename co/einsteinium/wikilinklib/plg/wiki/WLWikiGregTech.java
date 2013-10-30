package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiGregTech implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("GregTech_Addon");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "gregtech-addon.wikispaces.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Greg Tech Wiki";
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
