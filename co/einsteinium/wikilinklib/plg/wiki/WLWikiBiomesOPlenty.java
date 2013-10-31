package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiBiomesOPlenty implements IWikiLink {

	@Override
	public ArrayList<String> getModID() 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("BiomesOPlenty");
		
		return list;
	}

	@Override
	public String getWikiDomain() 
	{
		return "biomesoplenty.wikia.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Biome's O' Plenty Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.WIKIA;
	}

	@Override
	public String getCustomSearchString() {
		// TODO Auto-generated method stub
		return null;
	}

}
