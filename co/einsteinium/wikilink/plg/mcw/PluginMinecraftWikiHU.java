package co.einsteinium.wikilink.plg.mcw;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMinecraftWikiHU implements Plugin
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

		return "humcw";
	}

	@Override
	public String getWikiName() {

		return "Minecraft Wiki";
	}

	@Override
	public String getWikiDomain() {

		return "hu.minecraftwiki.net";
	}

	@Override
	public String getWikiSoftware() {

		return "MEDIAWIKI";
	}
	
	@Override
	public String getWikiLocalization() {
		
		return "hu_HU";
	}
	
	@Override
	public String getCustomWikiSearchFormat() {

		return null;
	}



}
