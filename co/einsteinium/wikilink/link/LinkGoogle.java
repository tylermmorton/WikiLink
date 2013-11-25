package co.einsteinium.wikilink.link;

import net.minecraft.item.ItemStack;

public class LinkGoogle extends Link
{
	/** @param i : The Google type
	 *  i = 0 if "Lucky" link, else it's a normal
	 *  Google Search query. **/
	public LinkGoogle(ItemStack item, int i)
	{
		super(getHyperlink(item, i), getDisplay(item, i), item);
	}
	
	public static String getDisplay(ItemStack item, int type)
	{
		if(type != 0)
			 return "I'm Feeling Lucky - " + item.getDisplayName();
		else return "Search Google for " + item.getDisplayName();
	}	
	
	public static String getHyperlink(ItemStack item, int type)
	{
		if(type != 0)
			 return encodeHyperlink("http://www.google.com/search?btnI=I'm+Feeling+Lucky&q=" + item.getDisplayName());
		else return encodeHyperlink("http://www.google.com/search?q=" + item.getDisplayName());
	}
	
	public static String encodeHyperlink(String link)
	{
		return link.replace(" ", "%20")
				   .replace("+", "%2B");
	}
}
