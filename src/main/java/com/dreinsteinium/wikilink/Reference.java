package com.dreinsteinium.wikilink;

import java.io.File;

/** Reference<br>
 *  Class File dedicated to constants
 *  used by all classes inside of the
 *  program. 
 *  
 *  @author DrEinsteinium
 *  **/
public class Reference 
{
    public static File CFGROOT;
    
	public static final String MOD_ID = "WikiLink";
	public static final String MOD_NAME = "WikiLink";
	public static final String MOD_CHANNEL = "WikiLink";
	
    public static final String PROXY_COMMON_LOC = "com.dreinsteinium.wikilink.net.CommonProxy";
    public static final String PROXY_CLIENT_LOC = "com.dreinsteinium.wikilink.net.ClientProxy";
	
	public static final String VER_STATE = "Release";
	public static final String VER_MAJOR = "@MAJOR@";
	public static final String VER_MINOR = "@MINOR@";
	public static final String VER_BUILD = "@BUILD@";
	public static final String VER_MINECRAFT = "1.6.4";
	
	public static final String VER_MODHASH = "1a98b5bf25c7e5bc1eb1347eb963ee04";
	
    public static final String MOD_MINIVER = VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD;
    public static final String MOD_VERSION = VER_MINECRAFT + "-" + VER_MAJOR + "." + VER_MINOR + "." + VER_BUILD + " (" + VER_STATE + ")";
    	
    public static final String GOOGLE_TOKEN = "AIzaSyBXn0XhTUmjs5VLTAyX4uuj0RxrnqTDq_M";
	public static final String BITAPI_TOKEN = "72107fafc4dda52519a18db8bee00445154cf4c3";
    
	public static final String WIKILINKLIB_GIT = String.format("https://raw.github.com/DrEinsteinium/WikiLink/master/plugin/%s/", VER_MINECRAFT);

}
