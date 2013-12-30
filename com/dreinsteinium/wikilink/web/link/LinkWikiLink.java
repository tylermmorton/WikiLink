package com.dreinsteinium.wikilink.web.link;

import java.util.Map;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.api.Software;

import net.minecraft.item.ItemStack;

public class LinkWikiLink extends Link
{
    
    public String modid;
    public Integer index;
    
    public LinkWikiLink(ItemStack item, int index)
    {
        super(item, EnumLink.WIKI);
        this.index = index;
        this.modid = this.getModId(item);
    }

    @Override
    public String getDisplay()
    {
        return this.getWikiDisplayMap().get(index);
    }

    @Override
    public String getHyperlink()
    {
        return "http://" + this.getWikiDomainMap().get(index) + this.getSoftwareSearchQuery() + this.item.getDisplayName();
    }
    
    public Software getSoftware()
    {
        return this.getWikiSoftwareMap().get(index);
    }
    
    public String getSoftwareSearchQuery()
    {
        switch(this.getSoftware())
        {
            case WIKIA:           
                return "/index.php?search=";
            case PHPWIKI:
                return "/?do=search&id=";
            case WIKIDOT:
                return "/search:site/q/";
            case DOKUWIKI:
                return "/wiki.new/doku.php?do=search&id=";
            case MEDIAWIKI:            
                return "/index.php?search=";  
            case WIKISPACES:
               return "/search/view/";
            case CUSTOM:
               return "";
            default:
            {
                WikiLink.LogHelper.severe("WikiLink could not find a Software enumtype for the ItemStack.");
                WikiLink.LogHelper.severe("What follows is a mini stacktrace of the problem. Please send "
                        + "this to DrEinsteinium as soon as possible.");
                WikiLink.LogHelper.severe("ItemStack Num     : " + this.item.itemID);
                WikiLink.LogHelper.severe("ItemStack Dmg     : " + this.item.getItemDamage());
                WikiLink.LogHelper.severe("ItemStack Name    : " + this.item.getDisplayName());
                WikiLink.LogHelper.severe("ItemStack ModId   : " + this.modid);
            }
        }
        
        return null;
    }

}
