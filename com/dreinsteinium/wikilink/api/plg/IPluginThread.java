package com.dreinsteinium.wikilink.api.plg;

import com.dreinsteinium.wikilink.plg.Plugin;

public interface IPluginThread extends Plugin
{
    /** <b>getIdentification</b><br>
     *  getIdentification should return the @ModId of the specific mod
     *  that this thread is linking to. Please do not use the modId of
     *  another mod, otherwise I'll get my secret service to slay you
     *  **/
    public String getIdentification();
    
    /** <b>getThreadNumberStr</b><br>
     *  getThreadNumberStr is a poorly named method that should return
     *  the number of the thread on the Minecraft Forums. Note, please
     *  make sure to include the dash at the end, otherwise it may not
     *  work properly. Also, <b>DO NOT</b> return the whole hyperlink!
     *  @example http://www.minecraftforum.net/topic/<b>1926671-</b>
     *  **/
    public String getThreadNumberStr();
}
