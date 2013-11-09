package co.einsteinium.wikilink.cfg;

import java.io.File;

import net.minecraftforge.common.Configuration;
import co.einsteinium.wikilink.api.Software;

/** ConfigHandler
 *
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class ConfigHandler
{
	public static boolean shortenUrl;
	public static boolean shortenAdfly;
	
    public static boolean includeTooltipsOnItems;
    
    public static String defaultWikiDomain;
    public static String defaultWikiDisplay;    
    public static String defaultWikiSoftware;
    public static String defaultCustomWikiSearchString;
    
    public static void init(File file)
    {
        Configuration config = new Configuration(file);
        //
        config.load();
                
        includeTooltipsOnItems = config.get("Tooltip Options", "includeTooltipsOnItems", true, "Should WikiLink give a message on item tooltips when an item is hovered in an inventory?").getBoolean(true);
        
        defaultWikiDomain = config.get("Default Wiki Options", "defaultWikiDomain", "wiki.feed-the-beast.com").getString();
        defaultWikiDisplay = config.get("Default Wiki Options", "defaultWikiDisplay", "Feed the Beast Wiki").getString();
        defaultWikiSoftware = config.get("Default Wiki Options", "defaultWikiSoftware", "MEDIAWIKI").getString();
        defaultCustomWikiSearchString = config.get("Deafault Wiki Custom Search String", "defaultCustomWikiSearchString", "").getString();
        config.addCustomCategoryComment("Deafault Wiki Custom Search String", "DO NOT CHANGE UNLESS YOU KNOW WHAT YOU ARE DOING. IF NOTHING, LEAVE BLANK.");
      
        config.addCustomCategoryComment("Link Shortener Options", "These are the options used to change how WikiLink shortens links that are sent out.");
        shortenUrl = config.get("Link Shortener Options", "shortenUrl", true, "Should WikiLink shorten the URLs? (Non-Adfly)").getBoolean(true);
        shortenAdfly = config.get("Link Shortener Options", "shortenWithAdfly", false, "Should WikiLink shorten the URLs with Adfly? If you would like to support the developer, you may turn this on, but it defaults to false.").getBoolean(false);
        config.save();
        //
    }
    
    public static Software getSoftware()
	{
		return Software.fromString(defaultWikiSoftware);
	}
}

	
