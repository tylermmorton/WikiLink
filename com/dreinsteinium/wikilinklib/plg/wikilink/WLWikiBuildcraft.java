package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiBuildcraft implements IPluginWikiLink
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
            list.add("BuildCraft|Core");
            list.add("BuildCraft|Energy");
            list.add("BuildCraft|Factory");
            list.add("BuildCraft|Silicon");
            list.add("BuildCraft|Builders");
            list.add("BuildCraft|Transport");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "minecraftbuildcraft.wikia.com";
    }

    @Override
    public String getDisplayName()
    {
        return "BuildCraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIA;
    }



}
