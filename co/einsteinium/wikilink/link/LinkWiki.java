package co.einsteinium.wikilink.link;

import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.api.Software;
import co.einsteinium.wikilink.plg.PluginRegistry;

/**
 * 
 *  @author DrEinsteinium
 */
public class LinkWiki extends Link
{	
	public LinkWiki(ItemStack item, String modId)
	{
		super(getHyperlink(item, modId), getDisplay(item), item);
	}
	
	private static String getDisplay(ItemStack item)
	{
		if(!PluginRegistry.getWikiDisplayMap().containsKey(getModId(item)))
			 return PluginRegistry.getWikiDisplayMap().get("Default") + " - " + item.getDisplayName();
		else return PluginRegistry.getWikiDisplayMap().get(Link.getModId(item.itemID)) + " - " + item.getDisplayName();
	}
	
	private static String getHyperlink(ItemStack item, String modId)
	{
		if(PluginRegistry.getWikiDisplayMap().containsKey(modId))
			 return "http://" + getWikiDomain(item) + getSoftwareExtension(PluginRegistry.getWikiSoftwareMap().get(modId), item) + item.getDisplayName();
		else return "http://" + (PluginRegistry.getWikiDomainMap().get("Default") + getSoftwareExtension(PluginRegistry.getWikiSoftwareMap().get("Default"), item)) + item.getDisplayName();

	}
	
	private static String encodeHyperlink(String link)
	{
		return link.replace(" ", "%20")
				   .replace("+", "%2B");
	}
	
	private static String getWikiDomain(ItemStack item)
	{
		return PluginRegistry.getWikiDomainMap().get(getModId(item.itemID));
	}
	
	private static Software getWikiSoftware(ItemStack item)
	{
		return PluginRegistry.getWikiSoftwareMap().get(getModId(item.itemID));
	}
	
	private static String getSoftwareExtension(Software s, ItemStack item)
	{
		if(s.equals(Software.CUSTOM))
			 return PluginRegistry.getCustomWikiSoftwareMap().get(getModId(item.itemID));
		else return Software.getDomainExtension(s);
	}
}
