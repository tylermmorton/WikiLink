package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiThermalExpansion implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("ThermalExpansion");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		// TODO Auto-generated method stub
		return "thermalexpansion.wikispaces.com";
	}

	@Override
	public String getWikiDisplay()
	{
		// TODO Auto-generated method stub
		return "ThermalExpansion Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		// TODO Auto-generated method stub
		return Software.WIKISPACES;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
