package co.einsteinium.wikilink.plg.mcw;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.Plugin;


public class PluginMinecraftWikiPL implements Plugin
{

	@Override
	public boolean isAvailable() {

		return true;
	}

	@Override	public String getModID() {

		return "Minecraft";
	}

	@Override
	public String getWikiKey() {

		return "plmcw";
	}

	@Override
	public String getWikiName() {

		return "Minecraft Wiki";
	}

	@Override
	public String getWikiDomain() {

		return "pl.minecraftwiki.net";
	}

	@Override
	public String getWikiSoftware() {

		return "MEDIAWIKI";
	}
	
	@Override
	public String getWikiLocalization() {
		
		return "pl_PL";
	}
	
	@Override
	public String getCustomWikiSearchFormat() {

		return null;
	}



}
