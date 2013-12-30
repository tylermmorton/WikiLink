package com.dreinsteinium.wikilinklib.plg.wikilink;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiBibliocraft implements IPluginWikiLink
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
            list.add("BiblioCraft");
            list.add("BiblioWoodsBoP");
            list.add("BiblioWoodsEBXL");
            list.add("BiblioWoodsNatura");
            list.add("BiblioWoodsHighlands");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "bibliocraft.wikia.com";
    }

    @Override
    public String getDisplayName()
    {
        return "BiblioCraft Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.WIKIA;
    }



}
