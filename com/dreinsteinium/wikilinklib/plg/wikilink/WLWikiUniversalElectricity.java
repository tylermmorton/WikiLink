package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiUniversalElectricity implements IPluginWikiLink
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
            list.add("MFFS");
            
            list.add("Mekanism");
            list.add("MekanismTools");
            list.add("MekanismGenerators");
            
            list.add("AtomicScience");
            
            list.add("ICBM|Sentry");
            list.add("ICBM|Contraption");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "wiki.universalelectricity.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Universal Electricity Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.DOKUWIKI;
    }



}
