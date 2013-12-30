package com.dreinsteinium.wikilinklib.plg.thread;

import com.dreinsteinium.wikilink.api.plg.IPluginThread;

public class WLThreadTConstruct implements IPluginThread
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public String getIdentification()
    {
        return "TConstruct";
    }

    @Override
    public String getThreadNumberStr()
    {
        return "1659892-";
    }

}
