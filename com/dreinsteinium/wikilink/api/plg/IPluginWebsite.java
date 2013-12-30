package com.dreinsteinium.wikilink.api.plg;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.plg.Plugin;

public interface IPluginWebsite extends Plugin
{
    public ArrayList<String> getIdentification();
    
    public String getWebsiteDomain();
    
    public String getWebsiteDisplay();
}
