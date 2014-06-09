package com.dreinsteinium.wikilink.web.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.cfg.ConfigHandler;
import com.dreinsteinium.wikilink.web.WebHelper;

/** WikiParser<br>
 *  Class used to send requests to a wiki and parse
 *  the results, either returning null or the text
 *  on the page.
 *  **/
public class WikiParser extends WebHelper
{
    private final String FTB_WIKI_HYPERLINK = "http://wiki.feed-the-beast.com/api.php?action=wikilinkquery&query=" + "%s" + "&format=txt";
    
    private String pagename;
    private String response;
    
    public WikiParser(ItemStack item)
    {
        if(ConfigHandler.enableSummarize)
        if((this.response = runSpecialCases(item)) == null)
        {
            this.pagename = item.getDisplayName();
            this.response = getResponse(String.format(FTB_WIKI_HYPERLINK, encode(item.getDisplayName())));
        }
    }
    
    public String parseResponse()
    {
        if(this.response != null)
        {
            //If it directs to a search page, return null
            if(this.response.contains("[search]"))
                return null;
            // If it directs to the mc wiki, return null
            if(this.response.contains("{{Vanilla"))
                return null;
            
            //If the response is actually a page
            if(this.response.contains("[pages]"))
            {
                String str = this.response;
                    //Start by cutting out the beginning of the file
                    str = str.substring(str.indexOf("}}") +2);
                        // If we can find a stopping point
                        // The loop will check for ==, {{ or __TOC__,
                        // Which are all common patterns.
                        for(int i = 0; i < str.length(); i++)
                        {
                            if(str.indexOf("==") == i)
                                return str.substring(0,i);
                            else if(str.indexOf("{{") == i)
                                return str.substring(0,i);
                            else if(str.indexOf("__TOC__") == i)
                                return str.substring(0,i);
                        }
            }
        }
        return null;
    }
    
    private String runSpecialCases(ItemStack item)
    {
        String response = null;
        
        // Is it a block?
        if(item.getItem() instanceof ItemBlock)
        {
            /* Check to see if the ore is a part of
             * the OreDictionary */
          if(!OreDictionary.getOreName(item.itemID).equals("Unknown"))
            {String oreName = OreDictionary.getOreName(item.itemID);
                
                if(oreName.equalsIgnoreCase("oreTin"))
                {   this.pagename = "Tin_Ore";
                    return String.format(FTB_WIKI_HYPERLINK, "Tin_Ore");
                }
                if(oreName.equalsIgnoreCase("oreLead"))
                {   this.pagename = "Lead_Ore";
                    return String.format(FTB_WIKI_HYPERLINK, "Lead_Ore");
                }
                if(oreName.equalsIgnoreCase("oreCopper"))
                {   this.pagename = "Copper_Ore";
                    return String.format(FTB_WIKI_HYPERLINK, "Copper_Ore");
                }
                if(oreName.equalsIgnoreCase("oreSilver"))
                {   this.pagename = "Silver_Ore";
                    return String.format(FTB_WIKI_HYPERLINK, "Silver_Ore");
                }
            }//OreDictCheck
        }//BlockCheck
        
        return null;
    }
    
    public String getPagename()
    {
        return this.pagename;
    }
    
    public String getResponse()
    {
        return this.response;
    }
}
