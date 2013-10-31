package co.einsteinium.wikilink.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;

public class VersionHandler
{	
    public static boolean getWikiLinkVersionFromWeb() throws Exception
    {
        URL versionIn = new URL("https://raw.github.com/DrEinsteinium/WikiLink/master/version.txt");

        BufferedReader in = new BufferedReader(new InputStreamReader(versionIn.openStream()));
     
        String line;
        String wholeString = "";
        
        while((line = in.readLine()) != null)
        {
        	wholeString = wholeString + " " + line;
        }
        
        if(!wholeString.contains(Reference.VER_MODHASH))
        {
        	return true;
        }
        
        in.close();
        return false;

    }
}
