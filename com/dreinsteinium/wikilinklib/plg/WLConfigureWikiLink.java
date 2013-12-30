package com.dreinsteinium.wikilinklib.plg;

import java.lang.reflect.Field;

import net.minecraft.client.entity.AbstractClientPlayer;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.api.IConfigureWikiLink;
import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.web.util.YoutubeList;

public class WLConfigureWikiLink implements IConfigureWikiLink
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public void onLoad()
    {
        YoutubeList ytl = new YoutubeList();
            ytl.importList("https://raw.github.com/DrEinsteinium/WikiLink/master/com/dreinsteinium/vanilla_list_164.txt");
    }

}
