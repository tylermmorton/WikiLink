package co.einsteinium.wikilink.plg.ftb;

import co.einsteinium.wikilink.api.Plugin;

public class PluginFeedTheBeastWiki implements Plugin
{

	@Override
	public boolean isAvailable() 
	{ return true; }

	@Override
	public String getModID() 
	{ return "Feed the Beast"; }

	@Override
	public String getWikiKey() 
	{ return "enftb"; }

	@Override
	public String getWikiName() 
	{ return "Feed the Beast Wiki"; }

	@Override
	public String getWikiDomain() 
	{ return "wiki.feed-the-beast.com"; }

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
