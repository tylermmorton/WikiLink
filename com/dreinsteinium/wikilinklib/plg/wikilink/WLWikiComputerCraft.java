package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiComputerCraft implements IPluginWikiLink
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
            list.add("ComputerCraft");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "computercraft.info/wiki";
    }

    @Override
    public String getDisplayName()
    {
        return "ComputerCraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.MEDIAWIKI;
    }



}
