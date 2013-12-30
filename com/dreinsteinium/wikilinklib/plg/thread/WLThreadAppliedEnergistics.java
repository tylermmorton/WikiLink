package com.dreinsteinium.wikilinklib.plg.thread;

import com.dreinsteinium.wikilink.api.plg.IPluginThread;

public class WLThreadAppliedEnergistics implements IPluginThread
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public String getIdentification()
    {
        return "AppliedEnergistics";
    }

    @Override
    public String getThreadNumberStr()
    {
        return "1625015-";
    }

}
