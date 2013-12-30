package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiBiomesOPlenty implements IPluginWikiLink
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
            list.add("BiomesOPlenty");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "biomesoplenty.wikia.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Biome's O' Plenty Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIA;
    }



}
