package co.einsteinium.wikilink.wiki;

import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.api.Plugin.Software;

/**
 * 
 * @author DrEinsteinium
 */
public class LinkWiki extends Link
{
	private String wikiModId;
	
	/** Constructor **/
	public LinkWiki(ItemStack item)
	{
	}
	
	public static String getWikiModId(ItemStack item)
	{
		WikiLink.LogHelper.info("Getting ModId");
		return itemDataModId.get(item.itemID);
	}
	
	public static String getWikiDomain(ItemStack item)
	{
		WikiLink.LogHelper.info("Getting Domain");
		return wikiDomain.get(getWikiModId(item));
	}
	
	public static Software getWikiSoftware(ItemStack item)
	{
		WikiLink.LogHelper.info("Getting Software");
		return wikiSoftware.get(getWikiModId(item));
	}
	
	public static String getWikiDomainExtension(ItemStack item)
	{
		switch(getWikiSoftware(item))
		{
			case WIKIA:
				return "/index.php?search=";
			case PHPWIKI:
				return "/?do=search&id=";
			case WIKIDOT:
				return "/search:site/q/";
			case DOKUWIKI:
				return "/wiki.new/doku.php?do=search&id=";
			case MEDIAWIKI:
				return "/index.php?search=";
			case WIKISPACES:
				return "/search/view/";
			default:
				return null;
		}
	}
	
	public static String getWikiSearchTerms(ItemStack item)
	{
		WikiLink.LogHelper.info("Getting Search Terms");
		return item.getDisplayName().replace(" ", "+");
	}
	
	/** **/
	public static String getHyperlink(ItemStack item)
	{
		if(getWikiDomain(item) != null)
		{	
			WikiLink.LogHelper.info("Getting Hyperlink");
			return "http://" + getWikiDomain(item) + getWikiDomainExtension(item) + getWikiSearchTerms(item);
		}
		
		WikiLink.LogHelper.info("No wiki found for " + getWikiModId(item));
		return null;
		
	}
}
