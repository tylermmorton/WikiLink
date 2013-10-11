package co.einsteinium.wikilink.wiki;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.api.Plugin.Software;
import co.einsteinium.wikilink.gui.GuiContainerWikiLinkMenu;
import co.einsteinium.wikilink.gui.InventoryWikiLinkMenu;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

/**
 * Link is the class that handles all links that are not considererd wikis.
 * 
 * @author DrEinsteinium
 * 
 */
public class Link
{
	private static ItemStack itemstack;
	
	private static HashMap<Integer, String> itemDataMap = new HashMap<Integer, String>();
	
	/** **/
	public static HashMap<String, String> wikiDomain = new HashMap<String, String>();
	/** **/
	public static HashMap<String, String> wikiDisplay = new HashMap<String, String>();
	/** **/
	public static HashMap<String, Software> wikiSoftware = new HashMap<String, Software>();
	
	/** **/
	public static HashMap<Integer, String> videoItemStackLink = new HashMap<Integer, String>();
	/** **/
	public static HashMap<Integer, String> videoItemStackDisplay = new HashMap<Integer, String>();
	
	public static ArrayList<String> guiDisplay = new ArrayList<String>();
	public static ArrayList<String> guiHyperlink = new ArrayList<String>();
	
	public enum LinkType { WIKI , SITE , YOUTUBE } 
	
	public Link(ItemStack item, String url, String display, LinkType type)
	{
		buildGui(item, url, display, type);
	}
	
	public void addToDisplay(String s)
	{
		for(int i = 2; i <= 6; i++)
		{			
			if(guiDisplay.get(i).isEmpty())
			{
				guiDisplay.set(i, s);
				break;
			}
		}
	}
	
	public void addToHyperlink(String s)
	{
		for(int i = 2; i <= 6; i++)
		{			
			if(guiHyperlink.get(i).isEmpty())
			{
				guiHyperlink.set(i, s);
				break;
			}
		}
	}
	
	
	public void buildGui(ItemStack item, String hyperlink, String display, LinkType type)
	{
		// If the first item in the list is empty, add a wiki.
		if(guiHyperlink.get(0).isEmpty() && type == LinkType.WIKI)
		{
			//If the hyperlink is != null and is not Minecraft
			//Default Mod Wiki
			if(hyperlink != null && wikiDomain.containsKey(getItemStackModId(item))/*&& getItemStackModId(item) != "Minecraft"*/)
			{ 			
				guiDisplay.set(0, display);
				guiHyperlink.set(0, hyperlink);
			}
			else
			{	
				guiDisplay.set(0, wikiDisplay.get("Default"));
				guiHyperlink.set(0, "http://" + wikiDomain.get("Default") + LinkWiki.getWikiDomainExtension(wikiSoftware.get("Default")) + item.getDisplayName().replace(" ", "+"));
			}
		}
		
		// If the second slot is not taken and the url type is YOUTUBE
		if(guiHyperlink.get(1).isEmpty() && (guiDisplay != null || guiHyperlink != null) && type == LinkType.YOUTUBE)
		{
			guiDisplay.set(1, display);
			guiHyperlink.set(1, hyperlink);
		}
	}
	
	public String shortenDisplayString(String s)
	{
		if(s.length() > 20)
		{
			s = s.substring(0, 19) + "...";
		}
		
		return s;
	}


	public static String getGuiDisplay(int index)
	{
		return guiDisplay.get(index);
	}
	
	public static String getGuiHyperlink(int index)
	{
		return guiHyperlink.get(index);
	}
	
	/** This method builds the initial ItemData HashMap so 
	 *  WikiLink will be able to quickly get the Mod Id of
	 *  any item.
	 */
	public static void buildItemDataHashMap()
	{
		NBTTagList itemDataList = new NBTTagList();

		GameData.writeItemData(itemDataList);
		for (int i = 0; i < itemDataList.tagCount(); i++)
		{
			ItemData data = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
			
			itemDataMap.put(data.getItemId(), data.getModId());
		}
	}
	
	public static HashMap<Integer, String> getItemDataHashMap()
	{
		return itemDataMap;
	}
	
	public static ItemStack getItemStack()
	{
		return itemstack;
	}
	
	/** Sets the ItemStack in the WikiLink Menu.
	 * 	
	 * @param item : The ItemStack to be displayed
	 * @param initGui : Should the GUI actually reinitialize
	 */
	public static void setItemStack(ItemStack item, boolean initGui)
	{
		itemstack = item;
		
		if(initGui)
		{
        	InventoryWikiLinkMenu fakeSlot = new InventoryWikiLinkMenu();
        	FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerWikiLinkMenu(fakeSlot, item));
		}
	}
	
	/** This method purges through the pre-existing
	 *  itemDataMap in order to find the ModId of the
     *  ItemStack by using the item's ID as a key.
	 * 
	 * @param itemid : ItemStack.itemID
	 * @return The modId of the ItemStack if available
	 */
	public static String getItemIdModId(int itemid)
	{
		if(itemDataMap.containsKey(itemid))
			return itemDataMap.get(itemid);
		else {
			WikiLink.LogHelper.severe("Could not find matching modId for given int.");			
			return null;
		}
	}
	
	/** This method purges through the pre-existing 
	 *  itemDataMap in order to find the ModId of the
	 *  ItemStack by using the item's ID as a key.
	 * 
	 * @param item : ItemStack
	 * @return The modId of the ItemStack.
	 */
	public static String getItemStackModId(ItemStack item)
	{
		return itemDataMap.get(item.itemID);
	}
	
	/** This method resets the content of both of the
	 *  ArrayLists regarding the WikiLink Menu. 
	 *  <p>
	 *  It sets all six indexes to "", not null.
	 */
	public static void setDefaultArrayLists()
	{
		for(int i = 0; i <= 6; i++)
		{
			guiDisplay.add(i, "");
			guiHyperlink.add(i, "");
		}
	}	
}
