package co.einsteinium.wikilink.cfg;

import java.io.File;

import net.minecraftforge.common.Configuration;

/** ConfigHandler
 *
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class ConfigHandler
{
    public static String defaultSearchSystem;
    public static String secondarySearchSystem;

    public static boolean includeModNameInPrimary;
    public static boolean includeModNameInSecondary;

    public static boolean includeTooltipsOnItems;
    
    public static String defaultWikiName;
    public static String defaultWikiDomain;
    public static String defaultWikiSoftware;

    public static void init(File file)
    {
        Configuration config = new Configuration(file);
        //
        config.load();
        defaultSearchSystem = config.get("Default Search Options", "defaultSearchSystem", "WIKI", "This is the default system WikiLink uses to search with. Options: WIKI, GOOGLE, BING").getString();
        includeModNameInPrimary = config.get("Default Search Options", "includeModNameInPrimary", true, "Should WikiLink include the name of the mod in the primary, non-wiki searches? It will make searches on search engines become more accurate.").getBoolean(true);
        secondarySearchSystem = config.get("Default Search Options", "secondarySearchSystem", "GOOGLE", "This is the default system WikiLink uses to search with if it can not find a valid wiki for that specific mod. Options: WIKI, GOOGLE, BING").getString();
        includeModNameInSecondary = config.get("Default Search Options", "includeModNameInSecondary", true, "Should WikiLink include the name of the mod in the secondary searches? It will make searches on search engines become more accurate.").getBoolean(true);
        
        includeTooltipsOnItems = config.get("Tooltip Options", "includeTooltipsOnItems", true, "Should WikiLink give a message on item tooltips when an item is hovered in an inventory?").getBoolean(true);

        defaultWikiName = config.get("Default Wiki Settings", "defaultWikiName", "Feed the Beast Wiki", "This is the display name for the default wiki.").getString();
        defaultWikiDomain = config.get("Default Wiki Settings", "defaultWikiDomain", "www.ftbwiki.org", "This is the domain name for the default wiki. DO NOT add any slashes or http:// to the string.").getString();
        defaultWikiSoftware = config.get("Default Wiki Settings", "defaultWikiSoftware", "MEDIAWIKI", "This is the software type of the default wiki. Choices: WIKIA, MEDIAWIKI, WIKISPACES, WIKIDOT, PHPWIKI, DOKUWIKI").getString();
        config.save();
        //
    }
}
