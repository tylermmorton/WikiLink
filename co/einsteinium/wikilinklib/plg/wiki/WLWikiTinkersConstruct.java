package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiTinkersConstruct implements IWikiLink
{

	@Override
	public ArrayList<String> getModID() 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("TConstruct");
		
		return list;
	}

	@Override
	public String getWikiDomain() 
	{
		return "tinkers-construct.wikia.com";
	}

	@Override
	public String getWikiDisplay() 
	{
		return "Tinker's Construct Wiki";
	}

	@Override
	public Software getWikiSoftware() 
	{
		return Software.WIKIA;
	}

	@Override
	public String getCustomSearchString() 
	{
		return null;
	}

}
