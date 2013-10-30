package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiIChun implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("GraviGun");
		list.add("PortalGun");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "ichun.us/w";
	}

	@Override
	public String getWikiDisplay()
	{
		return "iChun's Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.MEDIAWIKI;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
