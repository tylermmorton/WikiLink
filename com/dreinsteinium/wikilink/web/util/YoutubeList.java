package com.dreinsteinium.wikilink.web.util;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.plg.PluginRegistrar;
import com.dreinsteinium.wikilink.web.WebHelper;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

public class YoutubeList extends WebHelper
{
    private static HashMap videoMapping = new HashMap<String, String>();
   
    private static ArrayList<ItemStack> itemstackList = new ArrayList<ItemStack>();
    
    public void importList(String url)
    {   String response = this.getResponse(url);
    if(response != null)
    {
        String[] l = response.split(",");
                   
        for(int i = 0; i < l.length; i++)
        {
         String[] itmid = l[i].split("=");
         String[] metad = itmid[0].split(":");
         
         boolean all = false;      
         ItemStack item = new ItemStack(Integer.valueOf(metad[0].replace("null", "")), 1, 0);
      
         if(metad.length > 1 && metad[1] != null)
         {if(metad[1].contains("*"))            
                 all = true;
          else
             item.setItemDamage(Integer.valueOf(metad[1]));
         }

         if(all)
             for(int x = 0; x <= Integer.valueOf(metad[1].replace("*", "")); x++)
             {
                 item.setItemDamage(x);
                 PluginRegistrar.registerYoutube(item, itmid[1]);
             }
         else
             {
                 PluginRegistrar.registerYoutube(item, itmid[1]);
             }
        
        }       
    }
    }
}
