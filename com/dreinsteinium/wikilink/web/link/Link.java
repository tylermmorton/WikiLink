package com.dreinsteinium.wikilink.web.link;

import net.minecraft.item.ItemStack;

public abstract class Link
{
    private ItemStack item;
    
    public Link(ItemStack item, EnumLink type)
    {
        this.item = item;
    }
    
    public abstract String getDisplay();
    public abstract String getHyperlink();
}
