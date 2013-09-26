package co.einsteinium.wikilinklib;

public class LibReference
{
    public static final String MOD_ID = "WikiLinkLib";
    public static final String MOD_NAME = "WikiLinkLib";
    public static final String MOD_CHANNEL = "WikiLinkLib";

    public static final String PROXY_COMMON_LOC = "co.einsteinium.wikilink.net.CommonProxy";
    public static final String PROXY_CLIENT_LOC = "co.einsteinium.wikilink.net.ClientProxy";

    /*
     *
     */
    public static final String VER_STATE = "Release";
    public static final String VER_MAJOR = "1";
    public static final String VER_MINOR = "1";
    public static final String VER_BUILD = "003";
    public static final String VER_MINECRAFT = "1.6.2";

    public static final String MOD_MINIVER = VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD;
    public static final String MOD_VERSION = VER_MINECRAFT + "-" + VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD + " (" + VER_STATE + ")";

    /* The location of the files to be updated when needed.
     *
     */
    public static final String LIB_FILENAME = "mods/" + VER_MINECRAFT + "-WikiLinkLib" + ".zip";
    public static final String LIB_LOCATION = "http://www.electronic-chronic.com/WikiLink/" + VER_MINECRAFT + "-WikiLinkLib" + ".zip";
}
