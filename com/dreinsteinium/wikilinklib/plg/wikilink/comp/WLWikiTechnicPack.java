package com.dreinsteinium.wikilinklib.plg.wikilink.comp;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.api.plg.IPluginWikiLink;

public class WLWikiTechnicPack implements IPluginWikiLink
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
            list.add("BiblioCraft");
            list.add("BiblioWoodsBoP");
            list.add("BiblioWoodsEBXL");
            list.add("BiblioWoodsNatura");
            list.add("BiblioWoodsHighlands");
            list.add("BiomesOPlenty");
            list.add("BuildCraft|Core");
            list.add("BuildCraft|Energy");
            list.add("BuildCraft|Factory");
            list.add("BuildCraft|Silicon");
            list.add("BuildCraft|Builders");
            list.add("BuildCraft|Transport");
            list.add("ComputerCraft");
            list.add("EE3");
            list.add("IC2");
            list.add("Mystcraft");
            list.add("Thaumcraft");
            list.add("ThermalExpansion");
            list.add("TwilightForest");
            list.add("RailCraft");
        return list;
    }

    @Override
    public String getDomainName()
    {
        return "wiki.technicpack.net";
    }

    @Override
    public String getDisplayName()
    {
        return "Technic Pack Wiki";
    }

    @Override
    public Software getSoftwareType()
    {
        return Software.MEDIAWIKI;
    }

}
