package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiMetallurgy implements IPluginWikiLink
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
            list.add("Metallurgy3Core");
            list.add("Metallurgy3Base");
            list.add("Metallurgy3Vanilla");
            list.add("Metallurgy3Machines");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "metallurgy2.wikia.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Metallurgy Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIA;
    }



}
