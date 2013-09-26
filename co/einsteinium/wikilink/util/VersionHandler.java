package co.einsteinium.wikilink.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class VersionHandler
{
    public static String getWikiLinkVersionFromWeb() throws Exception
    {
        URL versionIn = new URL("http://www.catacombs.co/WikiLink/version.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(versionIn.openStream()));
        String inputLine = in.readLine();
        in.close();
        return inputLine;
    }
}
