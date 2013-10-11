package co.einsteinium.wikilink.cfg;

import java.io.File;

import co.einsteinium.wikilink.api.Plugin.Software;
import net.minecraftforge.common.Configuration;

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
    
    public static void init(File file)
    {
        Configuration config = new Configuration(file);
        //
        config.load();
                
        includeTooltipsOnItems = config.get("Tooltip Options", "includeTooltipsOnItems", true, "Should WikiLink give a message on item tooltips when an item is hovered in an inventory?").getBoolean(true);

        defaultWikiDomain = config.get("Default Wiki Options", "defaultWikiDomain", "wiki.feed-the-beast.com").getString();
        defaultWikiDisplay = config.get("Default Wiki Options", "defaultWikiDisplay", "Feed the Beast Wiki").getString();
        defaultWikiSoftware = config.get("Default Wiki Options", "defaultWikiSoftware", "MEDIAWIKI").getString();
      
        config.save();
        //
    }
    
    public static Software getSoftware()
    {
    	if(defaultWikiSoftware.equals("MEDIAWIKI"))
    		return Software.MEDIAWIKI;
    	else if(defaultWikiSoftware.equals("WIKIA"))
    		return Software.WIKIA;
    	
    	else return null;
    }
}
