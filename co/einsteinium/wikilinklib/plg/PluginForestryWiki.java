package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginForestryWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "008.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Forestry Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "Forestry";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "forestry.sengir.net";
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
