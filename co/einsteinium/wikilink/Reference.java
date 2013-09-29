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
    public static final String MOD_ID = "WikiLink";
    public static final String MOD_NAME = "WikiLink";
    public static final String MOD_CHANNEL = "WikiLink";

    public static final String PROXY_COMMON_LOC = "co.einsteinium.wikilink.net.CommonProxy";
    public static final String PROXY_CLIENT_LOC = "co.einsteinium.wikilink.net.ClientProxy";

    public static final String VER_STATE = "Release";
    public static final String VER_MAJOR = "2";
    public static final String VER_MINOR = "54";
    public static final String VER_BUILD = "05";
    public static final String VER_MINECRAFT = "1.6.2";
    
    public static final String VER_MODHASH = "1f5303f194f8362caa02a723f90c4c76";

    public static final String MOD_MINIVER = VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD;
    public static final String MOD_VERSION = VER_MINECRAFT + "-" + VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD + " (" + VER_STATE + ")";

    public static ArrayList wikiIdList = new ArrayList();
    public static ArrayList wikiNameList = new ArrayList();
    public static ArrayList wikiDomainList = new ArrayList();
    public static ArrayList wikiSoftwareList = new ArrayList();
    public static ArrayList wikiExtensionList = new ArrayList();
}
