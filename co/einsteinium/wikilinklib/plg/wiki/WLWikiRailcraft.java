package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiRailcraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Railcraft");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "railcraft.info/wiki";
	}

	@Override
	public String getWikiDisplay()
	{
		// TODO Auto-generated method stub
		return "Railcraft Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		// TODO Auto-generated method stub
		return Software.DOKUWIKI;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
