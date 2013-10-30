package co.einsteinium.wikilink.link;

import co.einsteinium.wikilink.plg.PluginRegistry;
import net.minecraft.item.ItemStack;

public class LinkGoogle extends Link
{
	public LinkGoogle(ItemStack item)
	{
		super(getGoogleHyperlink(item), getGoogleDisplay(item), item);
	}
	
	public static String getGoogleHyperlink(ItemStack item)
	{
		return "http://www.google.com/search?q=site:" + getGoogleDomain(item) + "%20" + item.getDisplayName().replace(' ', '+');
	}
	
	public static String getGoogleDisplay(ItemStack item)
	{
		return "[Site] " + PluginRegistry.getGoogleDisplayMap().get(Link.getItemIdModId(item.itemID));
	}
	
	public static String getGoogleDomain(ItemStack item)
	{
		return PluginRegistry.getGoogleDomainMap().get(Link.getItemIdModId(item.itemID));
	}
}
