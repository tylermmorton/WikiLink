package com.dreinsteinium.wikilinklib.plg.website;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.plg.IPluginWebsite;

public class WLWebsiteBibliocraft implements IPluginWebsite
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
            list.add("BiblioCraft");
            list.add("BiblioWoodsBoP");
            list.add("BiblioWoodsEBXL");
            list.add("BiblioWoodsNatura");
            list.add("BiblioWoodsHighlands");
        return list;
    }

    @Override
    public String getWebsiteDomain()
    {
        return "www.bibliocraftmod.com";
    }

    @Override
    public String getWebsiteDisplay()
    {
        return "BiblioCraft Website";
    }

}
