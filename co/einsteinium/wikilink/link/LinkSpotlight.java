package co.einsteinium.wikilink.link;

import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.plg.PluginRegistry;

/** LinkSpotlight
 *  The link system used to generate hyperlinks
 *  to items if they have a YouTube video under
 *  the ItemSpotlight map.
 *  **/
//TODO add entire mod spotlights
public class LinkSpotlight extends Link
{
	public LinkSpotlight(ItemStack item)
	{
		super(getHyperlink(item), getDisplay(item), item);
	}
	
	public static String getDisplay(ItemStack item)
	{
		// TODO Get the video title through json
		return "Item Spotlight - " + item.getDisplayName();
	}	
	
	public static String getHyperlink(ItemStack item)
	{
		return encodeHyperlink("http://www.youtube.com/watch?v=" + getVideoWatchCode(item));
	}
	
	public static String encodeHyperlink(String link)
	{
		return link.replace(" ", "%20")
				   .replace("+", "%2B");
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
