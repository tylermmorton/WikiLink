package com.dreinsteinium.wikilink.web.link;

import com.dreinsteinium.wikilink.web.WebHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Language;
import net.minecraft.item.ItemStack;

public class LinkGoogle extends Link
{
    public LinkGoogle(ItemStack item, EnumLink type)
    {
        super(item, type);
    }

    @Override
    public String getDisplay()
    {
        String str = null;
        
        if(this.type.equals(EnumLink.GOOGLE))
            str = I18n.getString("wikilink.gui.menu.google.search");
        else if(this.type.equals(EnumLink.LUCKY))
            str = I18n.getString("wikilink.gui.menu.google.ilucky");
        
        return str;
    }

    @Override
    public String getHyperlink()
    {
        String str = null;
        
        if(this.type.equals(EnumLink.GOOGLE))
            str = "http://www.google.com/search?q=" + WebHelper.encode(this.item.getDisplayName() + " " + getModId(item));
        else if(this.type.equals(EnumLink.LUCKY))
            str = "http://www.google.com/search?q=" + WebHelper.encode(this.item.getDisplayName() + " " + getModId(item)) + "&btnI";
       
        return str;
    }
    
    public String getDisplayString(EnumLink link)
    {
        String str = null;
        if(link.equals(EnumLink.GOOGLE))
            str = I18n.getString("wikilink.gui.menu.google.search");
        else if(link.equals(EnumLink.LUCKY))
            str = I18n.getString("wikilink.gui.menu.google.ilucky");
        return str;
    }
}
