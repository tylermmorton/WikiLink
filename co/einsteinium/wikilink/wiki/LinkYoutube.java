package co.einsteinium.wikilink.wiki;

import net.minecraft.item.ItemStack;

public class LinkYoutube extends Link
{
	public LinkYoutube()
	{
		
	}
	
	public static String getHyperlink(ItemStack item)
	{
		return "http://www.youtube.com/watch?v=" + getItemStackLink(item);
	}
	
	public static String getItemStackLink(ItemStack item)
	{
		return videoItemStackLink.get(item.itemID);
	}
	
	public static String getItemStackDisplay(ItemStack item)
	{
		return videoItemStackDisplay.get(item.itemID);
	}
	
}
