package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiBuildcraft implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("BuildCraft|Core");
		list.add("BuildCraft|Energy");
		list.add("BuildCraft|Factory");
		list.add("BuildCraft|Silicon");
		list.add("BuildCraft|Builders");
		list.add("BuildCraft|Transport");
		
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "minecraftbuildcraft.wikia.com";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Buildcraft Wiki";
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
