package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginThermalExpansionWiki implements Plugin
{
    @Override
    public boolean isAvailable()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String getWikiKey()
    {
        // TODO Auto-generated method stub
        return "003.01";
    }

    @Override
    public String getWikiName()
    {
        // TODO Auto-generated method stub
        return "Thermal Expansion Wiki";
    }

    @Override
    public String getModID()
    {
        // TODO Auto-generated method stub
        return "ThermalExpansion";
    }

    @Override
    public String getWikiDomain()
    {
        // TODO Auto-generated method stub
        return "thermalexpansion.wikispaces.com";
    }

    @Override
    public String getWikiSoftware()
    {
        // TODO Auto-generated method stub
        return "WIKISPACES";
    }

    @Override
    public String getWikiLocalization()
    {
        // TODO Auto-generated method stub
        return "ALL";
    }
}
