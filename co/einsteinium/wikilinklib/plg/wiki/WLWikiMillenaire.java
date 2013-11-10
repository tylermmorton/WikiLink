package co.einsteinium.wikilinklib.plg.wiki;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.IWikiLink;
import co.einsteinium.wikilink.api.Software;

public class WLWikiMillenaire implements IWikiLink
{

	@Override
	public ArrayList<String> getModID()
	{
		ArrayList<String> list = new ArrayList<String>();
			list.add("millenaire");
		return list;
	}

	@Override
	public String getWikiDomain()
	{
		return "millenaire.org";
	}

	@Override
	public String getWikiDisplay()
	{
		return "Millenaire Wiki";
	}

	@Override
	public Software getWikiSoftware()
	{
		return Software.CUSTOM;
	}

	@Override
	public String getCustomSearchString()
	{
		return "/wk/index.php?search=this+is+a+search";
	}

}
