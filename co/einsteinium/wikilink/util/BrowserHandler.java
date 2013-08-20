package co.einsteinium.wikilink.util;

import java.lang.reflect.Method;

import co.einsteinium.wikilink.WikiLink;
import net.minecraft.entity.player.EntityPlayer;

/** BrowserHandler
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class BrowserHandler 
{

	static String osName = System.getProperty("os.name");

	public static void browserInit(String hyperlink)
	{
		try
		{
			if(osName.startsWith("Windows"))
			{
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + hyperlink);	
			}
			else if(osName.startsWith("Mac OS"))
			{
				 Class fileMgr = Class.forName("com.apple.eio.FileManager");
	             Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] {String.class});
	             openURL.invoke(null, new Object[] {hyperlink});
			}
			else
			{//assume Unix or Linux
	            String[] browsers = { "google-chrome", "firefox", "opera", "epiphany", "konqueror", "conkeror", "midori", "kazehakase", "mozilla", "netscape" };
	            String browser = null;
	            for (int count = 0; count < browsers.length && browser == null; count++) 
	            {
	                if (Runtime.getRuntime().exec(new String[] {"which", browsers[count]}).waitFor() == 0) 
	                {
	                    browser = browsers[count];
	                }
	            }
	            if (browser == null) {
	                throw new Exception();
	            } else {
	                Runtime.getRuntime().exec(new String[] {browser, hyperlink});
	            }
			}
		} catch (Exception e) {
            WikiLink.LogHelper.severe("Can not find wiki software!");
        }
		WikiLink.LogHelper.info("Website Opened");
    }
}
