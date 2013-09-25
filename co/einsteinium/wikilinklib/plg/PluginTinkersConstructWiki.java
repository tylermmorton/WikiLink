package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginTinkersConstructWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "010.01";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Tinkers Construct Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "TConstruct";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "tinkers-construct.wikia.com";
	}

	@Override
	public String getWikiSoftware() {
		// TODO Auto-generated method stub
		return "WIKIA";
	}

	@Override
	public String getWikiLocalization() {
		// TODO Auto-generated method stub
		return "ALL";
	}

}
