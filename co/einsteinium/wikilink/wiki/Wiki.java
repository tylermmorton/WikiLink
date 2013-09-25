package co.einsteinium.wikilink.wiki;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.BrowserHandler;
import co.einsteinium.wikilink.util.WikiBindingHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

public class Wiki 
{
	public int currentIndex;
	
	private int itemId;
	
	private String wikiName;
	private String wikiDomain;
	
	private String wikiId;	
	private String itemModId;
	private String wikiModId;
	
	private String searchTerm;
	
	private String wikiLink;
	
	//private String wikiExtension;
	private String wikiExtension;
	
	//private String wikiLink;
	
	Wiki wiki = new Wiki();
	
	public Wiki()
	{		
		wikiLink = "http://" + wikiDomain + wikiExtension + searchTerm;
		
		
		initBrowser(wikiLink);
	}
	
	public enum Software
	{
		MEDIAWIKI, DOKUWIKI, WIKIA, WIKISPACES, PHPWIKI, WIKIDOT, CUSTOM
	}

	public static void setCurrentIndex(NBTTagCompound par1)
	{	
		ItemData itemData = new ItemData(par1);
		
		WikiLink.LogHelper.info(itemData.getModId());
		WikiLink.LogHelper.info("" + itemData.getItemId());
	}
	
	
	public void setSearchTerm(String s)
	{
		searchTerm = "";
	}
	
	/* These are the methods that manage
	 * the Wiki's unique ID.
	 */	
	public String getWikiId()
	{
		return null;
	}
	
	/**
	 * 
	 * @param s, the wiki Id
	 * @param i, the index of the Id
	 */
	public void setWikiId(String s, int i)
	{
		
	}
	
	/* These are the methods that manage
	 * the mod's/wiki's @ModId annotation
	 */	
	public String getWikiModId()
	{
		return null;
	}
	
	public void setWikiModId(String s, int i)
	{
		
	}	
	
	public int getItemId()
	{
		return itemId;
	}
	
	public void setItemId(ItemStack item)
	{
		itemId = item.itemID;
	}	
	
	public String getItemModId()
	{
		return null;
	}
	
	public void setItemModId(String s, int i)
	{
		
	}	
	
	/* These are the methods that manage
	 * the item's/wiki's display name.
	 */
	public String getWikiName()
	{
		return null;
	}
	
	public void setWikiName(String s, int i)
	{
		
	}
	
	public String getItemName()
	{
		return null;
	}
	
	public void setItemName(String s)
	{
		
	}
	
	/* These are the methods that manage
	 * the wiki's domain name.
	 */
	public String getWikiDomain()
	{
		return Reference.modDomainList.get(currentIndex).toString();
	}
	
	public void setWikiDomain(String s)
	{
		wikiDomain = s;
	}
	
	/* These are the methods that manage
	 * the wiki's software type.
	 */
	public String getWikiSoftware()
	{
		return null;
	}
	
	/** This method returns the custom extension
	 *  for a wiki's domain address.
	 * 
	 */
	public void setWikiExtension(Software s)
	{
		switch(s)
		{
			case WIKIA: case MEDIAWIKI:
				wikiExtension = "/index.php?search=";		 
			case WIKIDOT:
				wikiExtension = "/search:site/q/";
			case PHPWIKI:
				wikiExtension = "/?do=search&id=";
			case DOKUWIKI:
				wikiExtension = "/wiki.new/doku.php?do=search&id=";
			case WIKISPACES:
				wikiExtension = "/search/view/";
			case CUSTOM:
				wikiExtension =  wiki.getCustomSearchString();
		}
	}
	
	/** This method returns a custom extension
	 *  for a wiki's domain address.
	 * 
	 *  @return 
	 */
	public String getCustomSearchString()
	{
		return null;
	}	
	
	/** This method creates a custom extension
	 *  for a wiki's domain address.
	 * 
	 *  @param
	 */
	public void setCustomSearchString(String s, int i)
	{
		
	}


	/* These are the methods that manage
	 * browser handling. <BrowserHandler>
	 */
	public void initBrowser(String s)
	{		
		BrowserHandler.browserInit(s);
	}
		
}
