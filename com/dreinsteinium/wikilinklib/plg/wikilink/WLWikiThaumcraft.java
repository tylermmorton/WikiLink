package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiThaumcraft implements IPluginWikiLink
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
            list.add("Thaumcraft");
            list.add("ThaumicTinkerer");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "thaumcraft-3.wikia.com";
    }

    @Override
    public String getDisplayName()
    {
        return "Thaumcraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIA;
    }



}
