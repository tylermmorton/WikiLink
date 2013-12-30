package com.dreinsteinium.wikilinklib.plg.thread;

import com.dreinsteinium.wikilink.api.plg.IPluginThread;

public class WLThreadDartCraft implements IPluginThread
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public String getIdentification()
    {
        return "DartCraft";
    }

    @Override
    public String getThreadNumberStr()
    {
        return "1686840-";
    }

}
