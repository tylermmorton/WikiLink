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

	public LinkWiki(ItemStack item)
	{
		super(item, getUrl(item), getDisplay(item), getLinkType());
	}
		
	public static LinkType getLinkType()
	{
		return LinkType.WIKI;
	}	
	
	public static String getUrl(ItemStack item)
	{
		if(getWikiDomain(item) != null)
		{
			return "http://" + getWikiDomain(item) + getWikiDomainExtension(getWikiSoftware(item)) + item.getDisplayName().replace(" ", "+");
		}
		else return null;
	}
	
	public static String getDisplay(ItemStack item)
	{
		return wikiDisplay.get(getItemStackModId(item));
	}
	
	public static String getWikiDomain(ItemStack item)
	{
		return wikiDomain.get(getItemStackModId(item));
	}
	
	public static Software getWikiSoftware(ItemStack item)
	{
	//	WikiLink.LogHelper.info("Getting Software : " + getItemStackModId(item));
		return wikiSoftware.get(getItemStackModId(item));
	}
	
	public static String getWikiDomainExtension(Software software)
	{
		switch(software)
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

}
