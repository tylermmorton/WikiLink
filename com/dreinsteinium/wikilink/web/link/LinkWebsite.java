package com.dreinsteinium.wikilink.web.link;

import java.util.Map;

import com.dreinsteinium.wikilink.web.WebHelper;

import net.minecraft.item.ItemStack;

public class LinkWebsite extends Link
{
    public LinkWebsite(ItemStack item)
    {
        super(item, EnumLink.WEBSITE);
    }

    @Override
    public String getDisplay()
    {
        return this.getWebsiteDisplayMap().get(getModId(this.item));
    }

    @Override
    public String getHyperlink()
    {
        return "http://www.google.com/search?q=site:" + 
         this.getWebsiteDomainMap().get(getModId(this.item)) + "%20" + WebHelper.encode(this.item.getDisplayName());
    }

}
