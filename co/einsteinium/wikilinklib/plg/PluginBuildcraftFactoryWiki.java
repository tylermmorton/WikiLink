package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginBuildcraftFactoryWiki implements Plugin
{

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getWikiKey() {
		// TODO Auto-generated method stub
		return "005.06";
	}

	@Override
	public String getWikiName() {
		// TODO Auto-generated method stub
		return "Buildcraft Wiki";
	}

	@Override
	public String getModID() {
		// TODO Auto-generated method stub
		return "Buildcraft|Factory";
	}

	@Override
	public String getWikiDomain() {
		// TODO Auto-generated method stub
		return "minecraftbuildcraft.wikia.com";
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
