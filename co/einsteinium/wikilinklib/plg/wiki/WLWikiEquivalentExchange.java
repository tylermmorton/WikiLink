package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiEquivalentExchange implements IWikiLink {

	@Override
	public ArrayList<String> getModID() 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("EE3");
		
		return list;
	}

	@Override
	public String getWikiDomain() 
	{
		return "equivalentexchange.wikispaces.com";
	}

	@Override
	public String getWikiDisplay() 
	{
		return "EE3 Wiki";
	}

	@Override
	public Software getWikiSoftware() 
	{
		return Software.WIKISPACES;
	}

	@Override
	public String getCustomSearchString() 
	{
		return null;
	}

}
