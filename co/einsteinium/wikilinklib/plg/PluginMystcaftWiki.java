package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMystcaftWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "014.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Mystcraft Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "Mystcraft";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "binarymage.com";
	}

	@Override
	public String getWikiSoftware() {
		// TODO Auto-generated method stub
		return "DOKUWIKI";
	}

	@Override
	public String getWikiLocalization() {
		// TODO Auto-generated method stub
		return "ALL";
	}

}
