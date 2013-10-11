package co.einsteinium.wikilink.wiki;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.wiki.Link.LinkType;
import net.minecraft.item.ItemStack;

public class LinkYoutube extends Link
{

	public LinkYoutube(ItemStack item)
	{
		super(item, getUrl(item), getDisplay(item), getLinkType());
		// TODO Auto-generated constructor stub
	}

	public static LinkType getLinkType()
	{
		return LinkType.YOUTUBE;
	}	
	
	public static String getUrl(ItemStack item)
	{
		return "http://www.youtube.com/watch?v=" + getWatchCode(item);
	}
	
	public static String getWatchCode(ItemStack item)
	{
		if(videoItemStackLink.get(item.itemID) != null)
			return videoItemStackLink.get(item.itemID);
		else return "";
	}
	
	public static String getDisplay(ItemStack item)
	{
		return "Item Spotlight [YouTube]";
	}
}
