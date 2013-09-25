package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginIndustrialCraftWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "004.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Industrial Craft Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "IC2";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "wiki.industrial-craft.net";
	}

	@Override
	public String getWikiSoftware() {
		// TODO Auto-generated method stub
		return "MEDIAWIKI";
	}

	@Override
	public String getWikiLocalization() {
		// TODO Auto-generated method stub
		return "ALL";
	}

}
