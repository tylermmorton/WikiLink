package com.dreinsteinium.wikilink.plg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.api.Software;

public class PluginRegistrar 
{   
    //private static HashMap wikiDomainMap = new HashMap<String, String>();
    
    private static ArrayList<String> wikiIdList = new ArrayList<String>();
    private static ArrayList<String> wikiDomainList = new ArrayList<String>();
    private static ArrayList<String> wikiDisplayList = new ArrayList<String>();
    private static ArrayList<Software> wikiSoftwareList = new ArrayList<Software>();
    
    private static HashMap threadMap = new HashMap<String, String>();
    
    private static HashMap websiteDomainMap = new HashMap<String, String>();
    private static HashMap websiteDisplayMap = new HashMap<String, String>();
    
    private static ArrayList<String> youtubeCodeList = new ArrayList<String>();
    private static ArrayList<ItemStack> youtubeItemList = new ArrayList<ItemStack>();
    
    /** <b>registerWiki</b><br>
     *  Registers a Wiki to the Wiki mapping and sets the @ModId value
     *  as the key.
     *  **/
    public static void registerWiki(ArrayList<String> idList, String domain, String display, Software software)
    {
        for(int i = 0; i < idList.size(); i++)
        {
            wikiIdList.add(idList.get(i));
            wikiDomainList.add(domain);
            wikiDisplayList.add(display);
            wikiSoftwareList.add(software);      
        }
    }
  
    public static ArrayList<String> getWikiIdMap()
    {
        return wikiIdList;
    }
    
    public static ArrayList<String> getWikiDomainMap()
    {
        return wikiDomainList;
    }
    
    public static ArrayList<String> getWikiDisplayMap()
    {
        return wikiDisplayList;
    }
    
    public static ArrayList<Software> getWikiSoftwareMap()
    {
        return wikiSoftwareList;
    }
    
    //************************************************************\\
    public static void registerThread(String modId, String threadNum)
    {
        threadMap.put(modId, threadNum);
    }
    
    public static HashMap<String, String> getThreadMap()
    {
        return threadMap;
    }
    
    //************************************************************\\ 
    public static void registerYoutube(ItemStack item, String code)
    {
        youtubeItemList.add(item);
        youtubeCodeList.add(code);
    }

    public static ArrayList<String> getYoutubeCodeList()
    {
        return youtubeCodeList;
    }
    
    public static ArrayList<ItemStack> getYoutubeItemList()
    {
        return youtubeItemList;
    }
    
    //************************************************************\\
    public static void registerWebsite(ArrayList<String> idList, String domain, String display)
    {
        for(int i = 0; i < idList.size(); i++)
        {
            websiteDomainMap.put(idList.get(i), domain);
            websiteDisplayMap.put(idList.get(i), display);
        }
    }
    
    public static HashMap<String, String> getWebsiteDomainMap()
    {
        return websiteDomainMap;
    }
    
    public static HashMap<String, String> getWebsiteDisplayMap()
    {
        return websiteDisplayMap;
    }
}
