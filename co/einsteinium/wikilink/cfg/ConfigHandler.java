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
	public static void init(File file)
	{
		
		Configuration config = new Configuration(file);
		
		//
		config.load();
		
		
		
		config.save();
		//
		
	}
}
