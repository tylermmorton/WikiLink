package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiEquivalentExchange3 implements IPluginWikiLink
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
            list.add("EE3");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "equivalentexchange.wikispaces.com";
    }

    @Override
    public String getDisplayName()
    {
        return "EE3 Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKISPACES;
    }



}
