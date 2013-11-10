package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiMetallurgy implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
			list.add("Metallurgy3Core");
			list.add("Metallurgy3Base");
			list.add("Metallurgy3Vanilla");
			list.add("Metallurgy3Machines");
	
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "metallurgy2.wikia.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Metallurgy Wiki";
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
