package co.einsteinium.wikilink.api;

public enum Software
{
	WIKIA, MEDIAWIKI, DOKUWIKI, PHPWIKI, WIKIDOT, YOUTUBE, VIMEO, CUSTOM, WIKISPACES, GOOGLE;
	
	public static String toString(Software s)
	{
		if(s == WIKIA)
			return "WIKIA";
		else if(s == MEDIAWIKI)
			return "MEDIAWIKI";
		else if(s == DOKUWIKI)
			return "DOKUWIKI";
		else if(s == PHPWIKI)
			return "PHPWIKI";
		else if(s == WIKIDOT)
			return "WIKIDOT";
		else if(s == WIKISPACES)
			return "WIKISPACES";
		else if(s == CUSTOM)
			return "CUSTOM";
		return null;
	}
	
	public static Software fromString(String s)
	{
		if(s.equals("WIKIA"))
			return WIKIA;
		else if(s.equals("MEDIAWIKI"))
			return MEDIAWIKI;
		else if(s.equals("DOKUWIKI"))
			return DOKUWIKI;
		else if(s.equals("PHPWIKI"))
			return PHPWIKI;
		else if(s.equals("WIKIDOT"))
			return WIKIDOT;
		else if(s.equals("WIKISPACES"))
			return WIKISPACES;
		else if(s.equals("CUSTOM"))
			return CUSTOM;
		return null;
	}
	
	public static String getDomainExtension(Software s)
	{
			if(s == WIKIA)
				return "/wiki/Special:Search?search=";
			else if(s == PHPWIKI)
				return "/?do=search&id=";
			else if(s == WIKIDOT)
				return "/search:site/q/";
			else if(s == DOKUWIKI)
				return "/wiki.new/doku.php?do=search&id=";
			else if(s == MEDIAWIKI)
				return "/index.php?search=";
			else if(s == WIKISPACES)
				return "/search/view/";
			else
				return null;
	}
}
