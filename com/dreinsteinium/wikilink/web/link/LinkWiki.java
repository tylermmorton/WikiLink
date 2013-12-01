package com.dreinsteinium.wikilink.web.link;

import com.dreinsteinium.wikilink.api.Software;

import net.minecraft.item.ItemStack;

public class LinkWiki extends Link
{

    public LinkWiki(ItemStack item)
    {
        super(item, EnumLink.WIKI);
    }

    @Override
    public String getDisplay()
    {
        return this.getWikiDisplayMap().get(this.getModId(this.item));
    }

    @Override
    public String getHyperlink()
    {
        return null;
    }
    
   /* public String getSoftwareSearchQuery()
    {
        
    }*/

}
