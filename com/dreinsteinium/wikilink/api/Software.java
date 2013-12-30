package com.dreinsteinium.wikilink.api;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.dreinsteinium.wikilink.WikiLink;

public enum Software 
{
    CUSTOM, WIKIA, MEDIAWIKI, DOKUWIKI, PHPWIKI, WIKIDOT, WIKISPACES;
    
    // Software Type, ModId
    private static HashMap software = new HashMap<Software, String>();     
    // ModId, SoftwareQuery
    private static HashMap softwareQuery = new HashMap<String, String>();
   
    private static HashMap builtInQueryMap = new HashMap<Software, String>();
    
    /** Registers a new enum to be used as a possible Software type in
     *  WikiLink. Use this only if you know what you are doing. If you
     *  do not know how Software types work, please tweet @DrEinsteinium
     *  **/
    public static void registerNewSoftware(String str, String modId)
    {
        if(software.containsValue(modId))
        {
            WikiLink.LogHelper.info("Could not register software type for the"
                  + "given modId. Please make sure your plugin is not already"
                  + "registered!");
            WikiLink.LogHelper.info("ModId : " + modId + " was skipped for an"
                  + "exception. Duplicate ModId has been found!");
                return;
        }
        
        software.put(CUSTOM, modId);
        softwareQuery.put(modId, str);
    }
    
    public static HashMap<Software, String> getSoftwareMap()
    {
        return software;
    }
    
    public static HashMap<String, String> getSoftwareQueryMap()
    {
        return softwareQuery;
    }

}
