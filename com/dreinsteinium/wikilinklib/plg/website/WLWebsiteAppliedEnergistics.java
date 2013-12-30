package com.dreinsteinium.wikilinklib.plg.website;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.plg.IPluginWebsite;

public class WLWebsiteAppliedEnergistics implements IPluginWebsite
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public ArrayList<String> getIdentification()
    {
        ArrayList list = new ArrayList<String>();
            list.add("AppliedEnergistics");
        return list;
    }

    @Override
    public String getWebsiteDomain()
    {
        return "ae-mod.info";
    }

    @Override
    public String getWebsiteDisplay()
    {
        return "AppliedEnergistics Website";
    }

}
