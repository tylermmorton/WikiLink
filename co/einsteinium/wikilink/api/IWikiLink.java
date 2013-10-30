package co.einsteinium.wikilink.api;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.Software;

public interface IWikiLink extends Plugin
{
	public ArrayList<String> getModID();
	
	public String getWikiDomain();
	
	public String getWikiDisplay();
	
	public Software getWikiSoftware();
	
	public String getCustomSearchString();
}
