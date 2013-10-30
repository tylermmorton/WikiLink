package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiUniversalElectricity implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("MFFS");
		
		list.add("Mekanism");
		list.add("MekanismTools");
		list.add("MekanismGenerators");
		
		list.add("AtomicScience");
		
		list.add("ICBM|Sentry");
		list.add("ICBM|Contraption");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "wiki.universalelectricity.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Universal Electricity Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.DOKUWIKI;
	}

	@Override
	public String getCustomSearchString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
