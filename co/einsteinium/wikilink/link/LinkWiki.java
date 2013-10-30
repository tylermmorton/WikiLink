package co.einsteinium.wikilink.link;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.api.Software;
import co.einsteinium.wikilink.plg.PluginRegistry;

/**
 * 
 * @author DrEinsteinium
 */
public class LinkWiki extends Link
{
	private static ItemStack stack;
	private static String softwareExtension;
	
	public LinkWiki(ItemStack item)
	{
		super(getWikiHyperlink(item), getWikiDisplay(item), item);
		
		stack = item;
	}
	
	public static String getWikiHyperlink(ItemStack item)
	{
		if(PluginRegistry.getWikiDisplayMap().containsKey(Link.getItemIdModId(item.itemID)))
		{
			return "http://" + getWikiDomain(item) + getWikiSoftwareExtension(PluginRegistry.getWikiSoftwareMap().get(getItemIdModId(item.itemID)), item) + item.getDisplayName();
		}
		else return "http://" + (PluginRegistry.getWikiDomainMap().get("Default") + getWikiSoftwareExtension(PluginRegistry.getWikiSoftwareMap().get("Default"), item)) + item.getDisplayName();
	}
	
	public static String getWikiDomain(ItemStack item)
	{
		// Returns domain name of wiki.
		return PluginRegistry.getWikiDomainMap().get(getItemIdModId(item.itemID));
	}

	public static String getWikiDisplay(ItemStack item)
	{
		// Returns display name of wiki
		if(PluginRegistry.getWikiDisplayMap().containsKey(Link.getItemIdModId(item.itemID)))
		{
			return "[Wiki] " + (PluginRegistry.getWikiDisplayMap().get(Link.getItemIdModId(item.itemID)) + " - " + item.getDisplayName());
		}
		else return "[Wiki] " + (PluginRegistry.getWikiDisplayMap().get("Default") + " - " + item.getDisplayName());
	}
	
	public static String getWikiSoftwareExtension(Software s, ItemStack item)
	{
		if(s == Software.CUSTOM)
		{	
			softwareExtension = PluginRegistry.getCustomWikiSoftwareMap().get(getItemIdModId(item.itemID));
			return softwareExtension;
		}
		
		return s.getDomainExtension(s);
	}
	
	public static String getErrorMessage()
	{
		return "\u00A76[Error 404] " + stack.getDisplayName() + " - " + getItemIdModId(stack.itemID);
	}
}
