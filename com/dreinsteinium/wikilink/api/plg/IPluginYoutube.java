package com.dreinsteinium.wikilink.api.plg;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.dreinsteinium.wikilink.plg.Plugin;

/** <b>IPluginYoutube</b><br>
 *  IPluginYoutube is the interface class that should be extended when
 *  adding new videos specific to an Item. Without using reflection, I
 *  can not add spotlights for items added by other mods, so it's upto
 *  you to add your own items.<br><br>
 *  
 *  Thanks to Google having a massive API, we can get the display text
 *  of the video by getting the video title, removing the need for the
 *  displayName method from other APIs.<br><br>
 *  
 *  In order to avoid dependences WikiLink uses a system designed only
 *  to load plugins that implement interfaces like this. Thanks to the
 *  author of the system, ScottKillen, for this.
 *  @since  11/30/2013
 *  @author DrEinsteinium
 *  **/
public interface IPluginYoutube extends Plugin
{
    /** <b>getItemStackVideos</b><br>
     *  getItemStackVideos should return a HashMap of ItemStacks and a
     *  corresponding "watch" code. You should already know howto make
     *  a new instance of an ItemStack, but if you don't, please tweet
     *  DrEinsteinium or send a message on the Minecraft Forums.
     *  @example www.youtube.com/watch?v=<b>dQw4w9WgXcQ</b>
     *  **/
    public HashMap<ItemStack, String> getItemStackVideos();
}
