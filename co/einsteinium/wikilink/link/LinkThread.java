package co.einsteinium.wikilink.link;

import co.einsteinium.wikilink.plg.PluginRegistry;
import net.minecraft.item.ItemStack;

public class LinkThread extends Link
{

	public LinkThread(ItemStack item)
	{
		super(getHyperlink(item), getDisplay(item), item);
	}

	public static String getDisplay(ItemStack item)
	{
		return PluginRegistry.getMcForumDisplayMap().get(getModId(item.itemID));
	}	
	
	public static String getHyperlink(ItemStack item)
	{
		return encodeHyperlink("http://www.minecraftforum.net/topic/" + 
			   PluginRegistry.getMcForumPostMap().get(getModId(item.itemID)));
	}
	
	public static String encodeHyperlink(String link)
	{
		return link.replace(" ", "%20")
				   .replace("+", "%2B");
	}
	
}
