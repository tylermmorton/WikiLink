package com.dreinsteinium.wikilink.web.link;

import java.util.Map;

import com.dreinsteinium.wikilink.web.WebHelper;

import net.minecraft.item.ItemStack;

public class LinkWebsite extends Link
{
    boolean isSearch; 
    
    public LinkWebsite(ItemStack item, boolean isSearch)
    {
        super(item, EnumLink.WEBSITE);
        
        this.isSearch = isSearch;
    }

    @Override
    public String getDisplay()
    {
        if(isSearch)
            return this.getWebsiteDisplayMap().get(getModId(this.item)) + " (Search)";
        else return this.getWebsiteDisplayMap().get(getModId(this.item));
    }

    @Override
    public String getHyperlink()
    {
        if(this.isSearch)
        return "http://www.google.com/search?q=site:" + 
         this.getWebsiteDomainMap().get(getModId(this.item)) + "%20" + WebHelper.encode(this.item.getDisplayName());
        
        else
         return this.getWebsiteDomainMap().get(getModId(this.item));
    }

}
