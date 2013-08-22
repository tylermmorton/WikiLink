package co.einsteinium.wikilink.cfg;

import java.io.File;

import co.einsteinium.wikilink.Reference;
import net.minecraftforge.common.Configuration;

/** ConfigHandler
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class ConfigHandler 
{
	
	public static String defaultWikiKey;
	public static String defaultWikiName;
	public static String defaultWikiModId;
	public static String defaultWikiDomain;
	public static String defaultWikiSoftware;
	public static String defaultWikiLocalization;
	
	public static void init(File file)
	{
				
		Configuration config = new Configuration(file);
		
		//
		config.load();
		
		//##Default Wiki Options
		config.addCustomCategoryComment("Default Wiki Options", "Please only change these if you know what you are doing!");
		defaultWikiKey = config.get("Default Wiki Options", "DefaultWikiKey", "mcw").getString();
		defaultWikiName = config.get("Default Wiki Options", "DefaultWikiName", "Minecraft Wiki").getString();
		defaultWikiModId = config.get("Default Wiki Options", "DefaultWikiModId", "Minecraft").getString();
		defaultWikiDomain = config.get("Default Wiki Options", "DefaultWikiDomain", "www.minecraftwiki.net").getString();
		defaultWikiSoftware = config.get("Default Wiki Options", "DefaultWikiSoftware", "MEDIAWIKI").getString();
		defaultWikiLocalization = config.get("Default Wiki Options", "DefaultWikiLocalization", "en_US").getString();

		//##Default Search Options
		config.addCustomCategoryComment("Default Search Options", "Options: WIKI, BING, GOOGLE");
		Reference.defaultSearchSystem = config.get("Default Search Options", "DefaultSearchSystem", "GOOGLE").getString();
		
		
		config.save();
		//
		
	}
}
