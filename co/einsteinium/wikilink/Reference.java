package co.einsteinium.wikilink;

import java.util.ArrayList;

/** Reference
 * 
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */
public class Reference 
{
	/* Main References
	 * 
	 */
	public static final String MOD_ID = "WikiLink";
	public static final String MOD_NAME = "WikiLink";
	public static final String MOD_CHANNEL = "WikiLink";
	public static final String MOD_VERSION = "Build 015";

	public static final String PROXY_COMMON_LOC = "co.einsteinium.wikilink.net.CommonProxy";
	public static final String PROXY_CLIENT_LOC = "co.einsteinium.wikilink.net.ClientProxy";

	/* Variable References
	 * 
	 * These are the array lists of all of the
	 * information regarding plugins to WikiLink
	 */
	
	public static ArrayList modIdList;
	public static ArrayList modKeyList;
	public static ArrayList modNameList;
	public static ArrayList modDomainList;
	public static ArrayList modSoftwareList;
	public static ArrayList modLocalizationList;
	
	/* Language References
	 * 
	 */
	
	/* Software References
	 * 
	 */
	
	public static String getSearchQuery(int x)
	{
		// if MediaWiki
		if(modSoftwareList.get(x).equals("MEDIAWIKI"))
		{
			return "/index.php?search=";
		}
		// if Wikia
		else if(modSoftwareList.get(x).equals("WIKIA"))
		{
			return "/index.php?search=";
		}
		// if WikiDot
		else if(modSoftwareList.get(x).equals("WIKIDOT"))
		{
			return "/search:site/q/";
		}
		// if PhpWiki
		else if(modSoftwareList.get(x).equals("PHPWIKI"))
		{
			return "/?do=search&id=";
		}
		// if DokuWiki
		else if(modSoftwareList.get(x).equals("DOKUWIKI"))
		{
			return "/wiki.new/doku.php?do=search&id=";
		}
		// if Wikispaces
		else if(modSoftwareList.get(x).equals("WIKISPACES"))
		{
			return "/search/view/";
		}
		else
		{
			WikiLink.LogHelper.warning("Could not find software!");
			return null;
		}
	}
}
