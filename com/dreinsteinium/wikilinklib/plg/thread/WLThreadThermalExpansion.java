package com.dreinsteinium.wikilinklib.plg.thread;

import com.dreinsteinium.wikilink.api.plg.IPluginThread;

public class WLThreadThermalExpansion implements IPluginThread
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public String getIdentification()
    {
        return "ThermalExpansion";
    }

    @Override
    public String getThreadNumberStr()
    {
        return "1773528-";
    }

}
