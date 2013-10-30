package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiGalactiCraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("GalacticraftCore");
		list.add("GalacticraftPlanets");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "wiki.micdoodle8.com/w";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Galacticraft Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.MEDIAWIKI;
	}

	@Override
	public String getCustomSearchString()
	{
		return null;
	}

}
