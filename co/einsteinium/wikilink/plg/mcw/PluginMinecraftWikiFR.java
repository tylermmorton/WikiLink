package co.einsteinium.wikilink.plg.mcw;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.Plugin;


public class PluginMinecraftWikiFR implements Plugin
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

		return "frmcw";
	}

	@Override
	public String getWikiName() {

		return "Minecraft Wiki";
	}

	@Override
	public String getWikiDomain() {

		return "fr.minecraftwiki.net";
	}

	@Override
	public String getWikiSoftware() {

		return "MEDIAWIKI";
	}
	
	@Override
	public String getWikiLocalization() {
		
		return "fr_FR";
	}
	
	@Override
	public String getCustomWikiSearchFormat() {

		return null;
	}



}
