package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiThaumcraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("Thaumcraft");
		list.add("ThaumicTinkerer");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "thaumcraft-3.wikia.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Thaumcraft Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.WIKIA;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
