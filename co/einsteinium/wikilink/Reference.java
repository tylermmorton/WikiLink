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

	public static final String PROXY_COMMON_LOC = "co.einsteinium.wikilink.net.CommonProxy";
	public static final String PROXY_CLIENT_LOC = "co.einsteinium.wikilink.net.ClientProxy";

	/* Version References
	 *
	 */
	public static final String VER_STATE = "Release";
	public static final String VER_MAJOR = "2";
	public static final String VER_MINOR = "2";
	public static final String VER_BUILD = "001";
	public static final String VER_MINECRAFT = "1.6.2";	
	
	public static final String MOD_MINIVER = VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD;
	public static final String MOD_VERSION = VER_MINECRAFT + "-" + VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD + " (" + VER_STATE + ")";
	
	/* Variable References
	 * 
	 * These are the array lists of all of the
	 * information regarding plugins to WikiLink
	 */
	
	public static ArrayList modCustomList;
	
	public static ArrayList modIdList;
	public static ArrayList modKeyList;
	public static ArrayList modNameList;
	public static ArrayList modDomainList;
	public static ArrayList modSoftwareList;
	public static ArrayList modLocalizationList;
	
	public static String defaultSearchSystem;
	public static boolean addModNameToSearch;
	
	public static ArrayList modIdInfoList;
	public static ArrayList modUrlInfoList;
	public static ArrayList modNameInfoList;
	
	/* Language References
	 * 
	 */
	
	public static String currentLanguage;
	
	/* Wiki Software References
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
		else if(modSoftwareList.get(x).equals("CUSTOM"))
		{
			return modCustomList.get(x).toString();
		}
		else
		{
			WikiLink.LogHelper.warning("Could not find software!");
			return null;
		}
	}
}
