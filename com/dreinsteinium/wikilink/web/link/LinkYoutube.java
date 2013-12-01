package com.dreinsteinium.wikilink.web.link;

import net.minecraft.item.ItemStack;

public class LinkYoutube extends Link
{
    public LinkYoutube(ItemStack item)
    {
        super(item, EnumLink.YOUTUBE);
    }

    @Override
    public String getDisplay()
    {
        return null;
    }

    @Override
    public String getHyperlink()
    {
        return null;
    }

}
