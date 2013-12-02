package com.dreinsteinium.wikilinklib.plg.youtube;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.dreinsteinium.wikilink.api.plg.IPluginYoutube;

public class WLYoutubeMinecraft implements IPluginYoutube
{

    @Override
    public boolean isAvailable()
    {
        return true;
    }

    @Override
    public HashMap<ItemStack, String> getItemStackVideos()
    {
        HashMap<ItemStack, String> map = new HashMap<ItemStack, String>();
            map.put(new ItemStack(Block.stone), "58gIIDWHccQ");
        return map;
    }

}
