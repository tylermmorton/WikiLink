package co.einsteinium.wikilink;

import java.util.ArrayList;
import java.util.HashMap;

/** Reference
 *
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */
public class Reference
{
    public static final String MOD_ID = "WikiLink";
    public static final String MOD_NAME = "WikiLink";
    public static final String MOD_CHANNEL = "WikiLink";

    public static final String PROXY_COMMON_LOC = "co.einsteinium.wikilink.net.CommonProxy";
    public static final String PROXY_CLIENT_LOC = "co.einsteinium.wikilink.net.ClientProxy";

    public static final String VER_STATE = "Release";
    public static final String VER_MAJOR = "3";
    public static final String VER_MINOR = "00";
    public static final String VER_BUILD = "04";
    public static final String VER_MINECRAFT = "1.6.4";
    
    public static final String VER_MODHASH = "966a929ccc21263754421054de8eade3";
    public static final String FLYAPI_TOKEN = "a21b89837fe31e9ca433c6ebfeecb02a";
	public static final String BITAPI_TOKEN = "72107fafc4dda52519a18db8bee00445154cf4c3";

    public static final String MOD_MINIVER = VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD;
    public static final String MOD_VERSION = VER_MINECRAFT + "-" + VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD + " (" + VER_STATE + ")";

	public static HashMap<String, String> generateURIMapping(HashMap<String, String> map)
	{
			map.put(" ", "%21");
			map.put("!", "%22");
			map.put("#", "%23");
			map.put("$", "%24");
			map.put("&", "%26");
			map.put("'", "%27");
			map.put("(", "%28");
			map.put(")", "%29");
			map.put("*", "%2A");
			map.put("+", "%2B");
			map.put(",", "%2C");
			map.put("/", "%2F");
			map.put(":", "%3A");
			map.put(";", "%3B");
			map.put("=", "%3D");
			map.put("?", "%3F");
			map.put("@", "%40");
			map.put("[", "%5B");
			map.put("]", "%5D");
			
			WikiLink.LogHelper.info(map.toString());
			return map;
	}

}
