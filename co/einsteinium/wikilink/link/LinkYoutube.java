package co.einsteinium.wikilink.link;

import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.plg.PluginRegistry;

public class LinkYoutube extends Link
{
	public LinkYoutube(ItemStack item)
	{
		super(getVideoHyperlink(item), getVideoDisplay(item), item);
	}
	
	public static String getVideoDisplay(ItemStack item)
	{
		return "[Video] Item Spotlight - " + item.getDisplayName();
	}
	
	public static String getVideoHyperlink(ItemStack item)
	{
		return "http://www.youtube.com/watch?v=" + getVideoWatchCode(item);
	}
	
	public static String getVideoWatchCode(ItemStack item)
	{
		if(PluginRegistry.getItemSpotlightMap().get(item.itemID) != null)
		{
			return PluginRegistry.getItemSpotlightMap().get(item.itemID);
		}
		else return "";
	}
}
