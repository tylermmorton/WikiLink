package co.einsteinium.wikilinklib.plg;

import co.einsteinium.wikilink.api.Plugin;

public class PluginTwilightForestWiki implements Plugin
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
        return "011.01";
    }

    @Override
    public String getWikiName()
    {
        // TODO Auto-generated method stub
        return "Twilight Forest Wiki";
    }

    @Override
    public String getModID()
    {
        // TODO Auto-generated method stub
        return "TwilightForest";
    }

    @Override
    public String getWikiDomain()
    {
        // TODO Auto-generated method stub
        return "twilightforest.wikispaces.com";
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
