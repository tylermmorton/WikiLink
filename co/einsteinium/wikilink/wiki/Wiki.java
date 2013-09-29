package co.einsteinium.wikilink.wiki;

import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.util.BrowserHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

/**
 * 
 * @author DrEinsteinium
 */
public class Wiki
{
	private static String itemModId;
	private static String itemDisplayName;
	private static String itemModDomainName;
	private static String itemModDisplayName;
	private static String itemUnlocalizedName;
	
	private boolean isWikiFound;
	
	private String primarySearchSystem;
	private String secondarySearchSystem;
	private boolean includeModNameInPrimary;
	private boolean includeModNameInSecondary;
	
	public static String tooltipString;
	
	public static int arrayIndex;
	public static String searchString;
    
    /** This constructor should be called with every new search. Creating a new
     *  wiki object and supplying it with the correct parameters should always 
     *  result in a wiki opening in every situation.
     *
     * @param item : The ItemStack of the item you would like to be searching.
     */
    public Wiki(ItemStack item)
    {
    	isWikiFound = false;
    	
    	readConfigurations();
    	setArrayIndex();
    	
    	setModId(item);
    	setItemDisplayName(item);
    	setItemUnlocalizedName(item);
    	
    	setSearchString();
    	
    	setModDomainName();
    	
    	

        if (isWikiFound == true)
        {
            BrowserHandler.browserInit(buildPrimaryHyperlink());
        }
        else
        {
            BrowserHandler.browserInit(buildSecondaryHyperlink());
        }
    	
    }
    
    /** This method will read all of the important configurations from the 
     *  config every time a Wiki object is called. 
     *  <p>
     *  The important variables are the ones handling the search systems.
     */
    public void readConfigurations()
    {
        primarySearchSystem = ConfigHandler.defaultSearchSystem;
        secondarySearchSystem = ConfigHandler.secondarySearchSystem;
        includeModNameInPrimary = ConfigHandler.includeModNameInPrimary;
        includeModNameInSecondary = ConfigHandler.includeModNameInSecondary;
    }
    
    /** This method will create a new NBTTagList and sift through it. It will match the
     *  itemId of the ItemStack parameter with the itemId of the current data list tag.
     *  <p>
     *  When it has found two matching itemIds it will return 
     * @param itemstack : This is the itemstack that you would like to get the modId of. 
     */
	public static void setModId(ItemStack itemstack) 
	{
		NBTTagList itemDataList = new NBTTagList();

		GameData.writeItemData(itemDataList);

		for (int i = 0; i < itemDataList.tagCount(); i++) 
		{
			ItemData itemData = new ItemData((NBTTagCompound) itemDataList.tagAt(i));

			if (itemData.getItemId() == itemstack.itemID) 
			{
				itemModId = itemData.getModId();
			}
		}
	}
    
    public static String getModId()
    {
    	return itemModId;
    }

    /**
     * @param itemstack : The ItemStack you want to get the display name of.
     */
    public void setItemDisplayName(ItemStack itemstack)
    {
    	itemDisplayName = itemstack.getDisplayName();
    }
    
    /** @return itemDisplayName */
    public String getItemDisplayName()
    {
    	return itemDisplayName;
    }
    
    /**
     * @param itemstack : The ItemStack you want to get the unlocalized name of.
     */
    public void setItemUnlocalizedName(ItemStack itemstack)
    {
    	itemUnlocalizedName = itemstack.getItemName();
    }
    
    /** @return itemUnlocalizedName */
    public String getItemUnlocalizedName()
    {
    	return itemUnlocalizedName;
    }
    
    /** This method sets the arrayIndex variable by comparing all registered in
     *  WikiLinkLib and the return statement of getModId();
     *  <p>
     *  It also sets isWikiFound to true as well to be used in the browser handler.
     */
    public void setArrayIndex()
    {
	    WikiIdListChecker:
        for (int i = 0; i < Reference.wikiIdList.size(); i++)
        {
            if (Reference.wikiIdList.get(i).equals(getModId()))
            {
                arrayIndex = i;
                isWikiFound = true;
                break WikiIdListChecker;
            }
        }
    }
    
    /** @return arrayIndex */
    public int getArrayIndex()
    {
       return arrayIndex;
    }
    
    /** This method uses the getArrayIndex method to set itemModDisplayName to the
     *  correct name for every item.  
     */
    public void setModDisplayName()
    {
    	itemModDisplayName = Reference.wikiNameList.get(getArrayIndex()).toString();
    }
    
    /** @return itemModDisplayName */
    public String getModDisplayName()
    {
        return itemModDisplayName;
    }
    
    /** This method uses the getArrayIndex method to set itemModDomainName to the
     *  correct website source for every item.
     */
    public void setModDomainName()
    {
    	itemModDomainName = Reference.wikiDomainList.get(getArrayIndex()).toString();
    }
    
    /** @return itemModDomainName */
    public String getModDomainName()
    {
        return itemModDomainName;
    }  
  
    public void setSearchString()
    {
        if(includeModNameInSecondary == true && isWikiFound == false)
        {
            searchString = (getItemDisplayName() + " " + getModId()).replace(" ", "+");
    	}  
        else if(includeModNameInPrimary == true && !primarySearchSystem.equals("WIKI"))
        {
            searchString = (getItemDisplayName() + " " + getModId()).replace(" ", "+");
        }
        else
        {
            searchString =  getItemDisplayName().replace(" ", "+");
        }
	}

    public String getSearchString()
    {
		return searchString;
    }
    
    /** This method builds and returns the entire hyperlink that is opened by the
     *  BrowserHandler.
     *  
     *  @return String
     */
    public String buildPrimaryHyperlink()
    {
        if (primarySearchSystem.equals("WIKI"))
        {
            return ("http://" + getModDomainName() + getDomainExtension() + getSearchString());
        }
        else if (primarySearchSystem.equals("BING"))
        {
            return ("http://" + "www.bing.com" + "/search?q=" + getSearchString());
        }
        else if (primarySearchSystem.equals("GOOGLE"))
        {
            return ("http://" + "www.google.com" + "/search?q=" + getSearchString());
        }
        else
        {
            return "";
        }
    }

    public String buildSecondaryHyperlink()
    {
        if (secondarySearchSystem.equals("WIKI"))
        {
            return ("http://" + ConfigHandler.defaultWikiDomain + getDefaultDomainExtension(ConfigHandler.defaultWikiSoftware) + getSearchString());
        }
        else if (secondarySearchSystem.equals("BING"))
        {
            return ("http://" + "www.bing.com" + "/search?q=" + getSearchString());
        }
        else if (secondarySearchSystem.equals("GOOGLE"))
        {
            return ("http://" + "www.google.com" + "/search?q=" + getSearchString());
        }
        else
        {
            return "";
        }
    }
    
    public String getDomainExtension()
    {
        if (Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKIA")
        {
            return "/index.php?search=";
        }
        else if (Reference.wikiSoftwareList.get(getArrayIndex()) == "PHPWIKI")
        {
            return "/?do=search&id=";
        }
        else if (Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKIDOT")
        {
            return "/search:site/q/";
        }
        else if (Reference.wikiSoftwareList.get(getArrayIndex()) == "DOKUWIKI")
        {
            return "/wiki.new/doku.php?do=search&id=";
        }
        else if (Reference.wikiSoftwareList.get(getArrayIndex()) == "MEDIAWIKI")
        {
            return "/index.php?search=";
        }
        else if (Reference.wikiSoftwareList.get(getArrayIndex()) == "WIKISPACES")
        {
            return "/search/view/";
        }
        else
        {
            return Reference.wikiExtensionList.get(getArrayIndex()).toString();
        }
    }
    public String getDefaultDomainExtension(String par1)
    {
        if (par1.equals("WIKIA"))
        {
            return "/index.php?search=";
        }
        else if (par1.equals("PHPWIKI"))
        {
            return "/?do=search&id=";
        }
        else if (par1.equals("WIKIDOT"))
        {
            return "/search:site/q/";
        }
        else if (par1.equals("DOKUWIKI"))
        {
            return "/wiki.new/doku.php?do=search&id=";
        }
        else if (par1.equals("MEDIAWIKI"))
        {
            return "/index.php?search=";
        }
        else if (par1.equals("WIKISPACES"))
        {
            return "/search/view/";
        }
        else
        {
            return null;
        }
    }
}
