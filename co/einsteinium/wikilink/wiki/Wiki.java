package co.einsteinium.wikilink.wiki;

import java.util.ArrayList;

import codechicken.nei.NEIClientConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.util.BrowserHandler;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

public class Wiki 
{
	public int arrayIndex;
	
	private String itemName;
	private String itemModId;
	private String searchTerm;

	private boolean wikiFound;
	
	private String primarySearchSystem;
	private String secondarySearchSystem;
	private boolean includeModNameInPrimary;
	private boolean includeModNameInSecondary;
	
	public Wiki(ItemStack item)
	{		
		setItemData(item);
		setItemName(item);
		
		setArrayIndex();
		readConfigurations();
		
		if(wikiFound == true)
			BrowserHandler.browserInit(buildPrimaryHyperlink());
		else
			BrowserHandler.browserInit(buildSecondaryHyperlink());
	}
	
	/** Looks inside of the ConfigHandler and sets the values of the configurations.
	 *  This should be loaded after the configuration when Minecraft stats up.
	 */
	public void readConfigurations()
	{
		primarySearchSystem = ConfigHandler.defaultSearchSystem;
		secondarySearchSystem = ConfigHandler.secondarySearchSystem;
		includeModNameInPrimary = ConfigHandler.includeModNameInPrimary;
		includeModNameInSecondary = ConfigHandler.includeModNameInSecondary;
	}
	
	/** This method builds and returns the search term used in the hyperlink opened.
	 *  by the BrowserHandler.
	 *  
	 *  @return String
	 */
	public String buildSearchString()
	{
		if(includeModNameInSecondary == true && wikiFound == false)
			return (getItemName() + " " + getModId()).replace(" ","+");
		else if(includeModNameInPrimary == true && !primarySearchSystem.equals("WIKI"))
			return (getItemName() + " " + getModId()).replace(" ","+");
		else
			return getItemName().replace(" ","+");
	}
	
	/** This method builds and returns the entire hyperlink that is opened by the 
	 *  BrowserHandler. 
	 * 
	 *  @return String
	 */
	public String buildPrimaryHyperlink()
	{
		if(primarySearchSystem.equals("WIKI"))
			return ("http://" + getModDomainName() + getDomainExtension() + buildSearchString());
		else if(primarySearchSystem.equals("BING"))
			return ("http://" + "www.bing.com" + "/search?q=" + buildSearchString());
		else if(primarySearchSystem.equals("GOOGLE"))
			return ("http://" + "www.google.com" + "/search?q=" + buildSearchString());
		else
			return "";
	}
	
	public String buildSecondaryHyperlink()
	{
		if(secondarySearchSystem.equals("WIKI"))
			return ("http://" + getModDomainName() + getDomainExtension() + buildSearchString());
		else if(secondarySearchSystem.equals("BING"))
			return ("http://" + "www.bing.com" + "/search?q=" + buildSearchString());
		else if(secondarySearchSystem.equals("GOOGLE"))
			return ("http://" + "www.google.com" + "/search?q=" + buildSearchString());
		else
			return "";
	}
	
	/** Compares the ModId from getModId with the ModIds on the wikiIdList. It sets
	 *  the arrayIndex variable to the current loop value. 
	 */
	public void setArrayIndex()
	{
		for(int i = 0; i < Reference.wikiIdList.size(); i++)
		{	
			if(Reference.wikiIdList.get(i).equals(getModId()))
			{
				arrayIndex = i;
				wikiFound = true;
				break;
			}
		}
	}
	
	public int getArrayIndex()
	{
		return arrayIndex;
	}
	
	/** Sets the itemName variable to the input item's display name. 
	 * 
	 * @param par1 : The ItemStack to get the display name of.
	 */
	public void setItemName(ItemStack par1)
	{
		itemName = par1.getDisplayName();
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public String getModDomainName()
	{
		return Reference.wikiDomainList.get(getArrayIndex()).toString();
	}
	
	public String getDomainExtension()
	{
		if(Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKIA")
			return "/index.php?search=";
		else if(Reference.wikiSoftwareList.get(getArrayIndex()) == "PHPWIKI")
			return "/?do=search&id=";
		else if(Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKIDOT")
			return "/search:site/q/";
		else if(Reference.wikiSoftwareList.get(getArrayIndex()) == "DOKUWIKI")
			return "/wiki.new/doku.php?do=search&id=";
		else if(Reference.wikiSoftwareList.get(getArrayIndex()) == "MEDIAWIKI")
			return "/index.php?search=";
		else if(Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKISPACES")
			return "/search/view/";
		else
			return Reference.wikiExtensionList.get(getArrayIndex()).toString();
	}
	
	public String getModDisplayName()
	{
		return Reference.wikiNameList.get(getArrayIndex()).toString();
	}
	
	/** Takes an ItemStack and returns the ModId of the mod it came from.
	 * 
	 * @param par1 : The ItemStack you want to get the ModId from.
	 */
	public void setItemData(ItemStack par1)
	{		
        NBTTagList itemDataList = new NBTTagList();
        	GameData.writeItemData(itemDataList);
        	
        for(int i = 0; i < itemDataList.tagCount(); i++)
        {
        	ItemData itemData = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
        		
        	if(itemData.getItemId() == par1.itemID)	
        	{
        		itemModId = itemData.getModId();
        	}
        }
	}
	
	public String getModId()
	{
		return itemModId;
	}
}
