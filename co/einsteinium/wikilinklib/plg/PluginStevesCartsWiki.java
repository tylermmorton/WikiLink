package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginStevesCartsWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "015.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Steve's Carts Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "StevesCarts";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "stevescarts2.wikispaces.com";
	}

	@Override
	public String getWikiSoftware() {
		// TODO Auto-generated method stub
		return "WIKISPACES";
	}

	@Override
	public String getWikiLocalization() {
		// TODO Auto-generated method stub
		return "ALL";
	}

}
