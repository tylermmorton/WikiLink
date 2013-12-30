package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiExtraBees implements IPluginWikiLink
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public ArrayList<String> getIdentification()
    {
        ArrayList<String> list = new ArrayList<String>();
            list.add("ExtraBees");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "extrabees.wikidot.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Extra Bees Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIDOT;
    }



}
