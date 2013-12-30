package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiGregTech implements IPluginWikiLink
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
            list.add("GregTech_Addon");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "gregtech-addon.wikispaces.com";
    }

    @Override
    public String getDisplayName()
    {
        return "GregTech Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKISPACES;
    }



}
