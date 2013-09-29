package co.einsteinium.wikilink.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilinklib.LibReference;

public class VersionHandler
{
	private static boolean updateMod;
	private static boolean updateLib;
	
    public static String getWikiLinkVersionFromWeb() throws Exception
    {
        URL versionIn = new URL("https://raw.github.com/DrEinsteinium/WikiLink/master/version.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(versionIn.openStream()));
        String versionOut = in.readLine();
        in.close();
        return versionOut;
    }
    
    public static void checkForUpdate(String versionOut)
    {
    	// Check WikiLink
    	if(versionOut.contains(Reference.VER_MODHASH))
    	{
    		updateMod = true;
    	}
    	
    	// Check WikiLinkLib
    	if(versionOut.contains(LibReference.VER_MODHASH))
    	{
    		updateLib = true;
    	}
    }
    
    public static boolean getUpdateMod()
    {
    	return updateMod;
    }
    
    public static boolean getUpdateLib()
    {
    	return updateLib;
    }
}
