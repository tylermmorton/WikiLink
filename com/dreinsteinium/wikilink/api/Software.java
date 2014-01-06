package com.dreinsteinium.wikilink.api;

public enum Software
{
    CUSTOM, WIKIA, MEDIAWIKI, DOKUWIKI, PHPWIKI, WIKIDOT, WIKISPACES;
    
    public static Software fromString(String str)
    {
        for(Software s : Software.values())
            if(s.toString().equals(str))
                return s;
        return null;
    }
}
