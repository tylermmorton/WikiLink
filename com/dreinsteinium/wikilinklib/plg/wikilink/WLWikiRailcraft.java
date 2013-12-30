package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiRailcraft implements IPluginWikiLink
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
            list.add("Railcraft");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "railcraft.info/wiki";
    }

    @Override
    public String getDisplayName()
    {
        return "Railcraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.DOKUWIKI;
    }



}
