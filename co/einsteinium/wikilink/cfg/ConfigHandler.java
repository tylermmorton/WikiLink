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
	
	public static String defaultSearchSystem;
	public static String secondarySearchSystem;
	
	public static boolean includeModNameInPrimary;
	public static boolean includeModNameInSecondary;
	
	public static void init(File file)
	{
				
		Configuration config = new Configuration(file);
		
		//
		config.load();
		
		defaultSearchSystem = config.get("Default Search Options", "defaultSearchSystem", "WIKI", "This is the default system WikiLink uses to search with. Options: WIKI, GOOGLE, BING").getString();
		includeModNameInPrimary = config.get("Default Search Options", "includeModNameInPrimary", true, "Should WikiLink include the name of the mod in the primary, non-wiki searches? It will make searches on search engines become more accurate.").getBoolean(true);
		
		secondarySearchSystem = config.get("Default Search Options", "secondarySearchSystem", "GOOGLE", "This is the default system WikiLink uses to search with if it can not find a valid wiki for that specific mod. Options: WIKI, GOOGLE, BING").getString();
		includeModNameInSecondary = config.get("Default Search Options", "includeModNameInSecondary", true, "Should WikiLink include the name of the mod in the secondary searches? It will make searches on search engines become more accurate.").getBoolean(true);
		
		config.save();
		//
		
	}
}
