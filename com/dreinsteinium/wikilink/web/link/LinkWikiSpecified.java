package com.dreinsteinium.wikilink.web.link;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class LinkWikiSpecified extends Link
{

    public String str;
    
    public LinkWikiSpecified(ItemStack item, String string)
    {
        super(item, EnumLink.ENTITY);
        
        this.str = string;
    }

    @Override
    public String getDisplay()
    {      
        return "Minecraft Wiki";
    }

    @Override
    public String getHyperlink()
    {       
        return "http://www.minecraft.gamepedia.com/index.php?search=" + this.str;
    }

}
