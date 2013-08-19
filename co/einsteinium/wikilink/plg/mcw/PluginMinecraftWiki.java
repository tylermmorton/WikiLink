package co.einsteinium.wikilink.plg.mcw;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMinecraftWiki implements Plugin
{

	@Override
	public boolean isAvailable() 
	{ return true; }

	@Override
	public String getModID() 
	{ return "Minecraft"; }

	@Override
	public String getWikiKey() 
	{ return "enmcw"; }

	@Override
	public String getWikiName() 
	{ return "Minecraft Wiki"; }

	@Override
	public String getWikiDomain() 
	{ return "minecraftwiki.net"; }

	@Override
	public String getWikiSoftware() 
	{ return "MEDIAWIKI"; }

	@Override
	public String getWikiLocalization() 
	{ return "en_US"; }

	@Override
	public String getCustomWikiSearchFormat() 
	{ return null; }

}
