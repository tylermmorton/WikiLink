package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiIndustrialCraft implements IPluginWikiLink
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
            list.add("IC2");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "wiki.industrial-craft.net";
    }

    @Override
    public String getDisplayName()
    {
        return "IndustrialCraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.MEDIAWIKI;
    }



}
