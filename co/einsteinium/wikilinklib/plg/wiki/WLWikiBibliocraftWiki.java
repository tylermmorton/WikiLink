package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiBibliocraftWiki implements IWikiLink {

	@Override
	public ArrayList<String> getModID() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("BiblioCraft");
		list.add("BiblioWoodsBoP");
		list.add("BiblioWoodsEBXL");
		list.add("BiblioWoodsNatura");
		list.add("BiblioWoodsForestry");
		list.add("BiblioWoodsHighlands");
		
		return list;
	}

	@Override
	public String getWikiDomain() 
	{
		return "bibliocraft.wikia.com";
	}

	@Override
	public String getWikiDisplay() 
	{
		return "Bibliocraft Wiki";
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
