package co.einsteinium.wikilink.link;

import co.einsteinium.wikilink.plg.PluginRegistry;
import net.minecraft.item.ItemStack;

public class LinkWebsite extends Link
{
	public LinkWebsite(ItemStack item)
	{
		super(getHyperlink(item), getDisplay(item), item);
	}
	
	public static String getDisplay(ItemStack item)
	{
		return PluginRegistry.getGoogleDisplayMap().get(getModId(item.itemID));
	}	
	
	public static String getHyperlink(ItemStack item)
	{
		return encodeHyperlink("http://www.google.com/search?q=site:" + 
			   getWebsiteDomain(item) + " " + item.getDisplayName());
	}
	
	public static String encodeHyperlink(String link)
	{
		return link.replace(" ", "%20")
				   .replace("+", "%2B");
	}

	public static String getWebsiteDomain(ItemStack item)
	{
		return PluginRegistry.getGoogleDomainMap().get(getModId(item.itemID));
	}	

}
