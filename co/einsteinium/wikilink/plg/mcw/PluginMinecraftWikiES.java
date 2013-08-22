package co.einsteinium.wikilink.plg.mcw;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMinecraftWikiES implements Plugin
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

		return "esmcw";
	}

	@Override
	public String getWikiName() {

		return "Minecraft Wiki";
	}

	@Override
	public String getWikiDomain() {

		return "es.minecraftwiki.net";
	}

	@Override
	public String getWikiSoftware() {

		return "MEDIAWIKI";
	}
	
	@Override
	public String getCustomWikiSearchFormat() {

		return null;
	}

	@Override
	public String getWikiLocalization() 
	{
		return "es_ES";
	}
}
