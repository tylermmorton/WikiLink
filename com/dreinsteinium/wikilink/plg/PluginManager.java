package com.dreinsteinium.wikilink.plg;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.api.Software;
import com.esotericsoftware.yamlbeans.YamlReader;

public class PluginManager
{
    public static void parseWiki(File file)
    {
        if(!file.exists())
            return;

        try
        {
          YamlReader reader = new YamlReader(new FileReader(file));            
            while(true)
            {
                Map map = (Map)reader.read();
                    if(map == null) break;
                //Use this if to skip the "updater" section of the yml doc.
                if(map.get("name") != null)
                {ArrayList<String> idlist = (ArrayList<String>)map.get("mods");
                 String customsearch = null;
                 if(((String)map.get("soft")).equals("CUSTOM"))
                      customsearch = (String)map.get("custom");
                 PluginRegistrar.registerWiki(idlist, (String)map.get("link"), (String)map.get("name"), Software.fromString((String)map.get("soft")), customsearch);
                }
            }
          reader.close();
        }
        catch(Exception e)
        {}   
    }
    
    public static void parseThread(File file)
    {
        if(!file.exists())
            return;

        try
        {
          YamlReader reader = new YamlReader(new FileReader(file));            
            while(true)
            {
                Map map = (Map)reader.read();
                    if(map == null) break;
                //Use this if to skip the "updater" section of the yml doc.
                if(map.get("link") != null)
                {ArrayList<String> mods = (ArrayList<String>)map.get("mods");
                 ArrayList<String> link = (ArrayList<String>)map.get("link");
                 
                 for(String a : mods)
                   for(String b : link)
                      PluginRegistrar.registerThread(a, b.replace("-", ""));         
                }
            }
          reader.close();
        }
        catch(Exception e)
        {}   

    }
    
    public static void parseYoutube(File file)
    {
        if(!file.exists())
            return;

        try
        {
          YamlReader reader = new YamlReader(new FileReader(file));            
            while(true)
            {
                Map map = (Map)reader.read();
                    if(map == null) break;
                if(map.get("item") != null)
                {ArrayList<String> link = (ArrayList<String>)map.get("link");
                 ArrayList<String> meta = (ArrayList<String>)map.get("meta");
                 for(String i : meta)
                     for(String s : link)
                     {ItemStack item = new ItemStack(Integer.valueOf((String)map.get("item")), 0, Integer.valueOf(i));
                         PluginRegistrar.registerYoutube(item, s);
                     }
                }
            }
          reader.close();
        }
        catch(Exception e)
        {}   
    }
    
    public static void parseWebsite(File file)
    {
        if(!file.exists())
            return;

        try
        {
          YamlReader reader = new YamlReader(new FileReader(file));            
            while(true)
            {
                Map map = (Map)reader.read();
                    if(map == null) break;
                //Use this if to skip the "updater" section of the yml doc.
                if(map.get("name") != null)
                {ArrayList<String> mods = (ArrayList<String>)map.get("mods");
                 ArrayList<String> link = (ArrayList<String>)map.get("link");
                 for(String a : mods)
                  for(String b : link)
                   PluginRegistrar.registerWebsite(a, b, (String)map.get("name"));
                }
            }
          reader.close();
        }
        catch(Exception e)
        {}   

    }

}