package com.dreinsteinium.wikilinklib.plg.wikilink.comp;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiFeedTheBeast implements IPluginWikiLink
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public ArrayList<String> getIdentification()
    {
        ArrayList list = new ArrayList<String>();
            list.add("AppliedEnergistics");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "wiki.feed-the-beast.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Feed the Beast Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.MEDIAWIKI;
    }

}
