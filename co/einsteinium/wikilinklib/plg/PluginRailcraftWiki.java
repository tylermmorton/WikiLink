package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginRailcraftWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "009.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Railcraft Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "Railcraft";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "railcraft.wikispaces.com";
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
