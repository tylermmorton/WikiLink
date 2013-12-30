package com.dreinsteinium.wikilink.web.link;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class LinkEntity extends Link
{

    public Entity entity;
    
    public LinkEntity(ItemStack item, Entity entity)
    {
        super(item, EnumLink.ENTITY);
        
        this.entity = entity;
    }

    @Override
    public String getDisplay()
    {      
        return "Minecraft Wiki";
    }

    @Override
    public String getHyperlink()
    {       
        return "http://www.minecraftwiki.net/index.php?search=" + this.entity.getEntityName();
    }

}
