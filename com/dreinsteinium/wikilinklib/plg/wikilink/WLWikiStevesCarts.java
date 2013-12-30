package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiStevesCarts implements IPluginWikiLink
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
            list.add("StevesCarts");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "stevescarts2.wikispaces.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Steve's Carts Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKISPACES;
    }



}
