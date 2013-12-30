package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiGalacticraft implements IPluginWikiLink
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
            list.add("GalacticraftCore");
            list.add("GalacticraftPlanets");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "wiki.micdoodle8.com/w";
    }

    @Override
    public String getDisplayName()
    {
        return "Galacticraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.MEDIAWIKI;
    }



}
