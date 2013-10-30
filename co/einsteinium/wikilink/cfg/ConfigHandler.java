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
      
        config.save();
        //
    }
    
    public static Software getSoftware()
	{
		return Software.fromString(defaultWikiSoftware);
	}
}

	
