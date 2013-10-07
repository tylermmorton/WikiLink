package co.einsteinium.wikilink.wiki;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.api.Plugin.Software;
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
	/** The HashMap of all ItemId's and their ModId's. **/
	public static HashMap<Integer, String> itemDataModId = new HashMap<Integer, String>();
	
	/** The HashMap of all ModId's and corresponding Wiki domains. **/
	public static HashMap<String, String> wikiDomain = new HashMap<String, String>();
	
	/** The HashMap of all ModId's and corresponding Wiki display names. **/
	public static HashMap<String, String> wikiDisplay = new HashMap<String, String>();
	
	/** The HashMap of all ModId's and corresponding Wiki Software enum types **/
	public static HashMap<String, Software> wikiSoftware = new HashMap<String, Software>();
	
	public static HashMap<Integer, String> videoItemStackLink = new HashMap<Integer, String>();
	public static HashMap<Integer, String> videoItemStackDisplay = new HashMap<Integer, String>();
	
	public static ArrayList<String> menuGuiDisplay = new ArrayList<String>();
	public static ArrayList<String> menuGuiHyperlink = new ArrayList<String>();
	
	private static ItemStack stackover;

	public static HashMap<String, String> getWikiDomain()
	{
		return wikiDomain;
	}

	public static HashMap<String, String> getWikiDisplay()
	{
		return wikiDisplay;
	}

	public static HashMap<String, Software> getWikiSoftware()
	{
		return wikiSoftware;
	}
	
	/** This method returns the current ItemStack being 
	 *  searched.
	 *  
	 * @return ItemStack
	 */
	public static ItemStack getStackover()
	{
		return stackover;
	}	
	
	public static void setStackover(ItemStack item)
	{
		stackover = item;
	}

	/** This method uses the prebuilt HashMap itemDataModId
	 *  and returns the value of the ItemStack's ModId. 
	 *  <p>
	 *  <pre>HashMap(ItemStack.itemID, ItemData.getModId())</pre>
	 *  
	 * @param par1 : The ItemStack of the item
	 * @return The @ModId of the ItemStack's creator
	 */
	public static String getItemStackModId(ItemStack par1)
	{
		return itemDataModId.get(par1.itemID);
	}

	/** This method builds the initial ItemData HashMap so 
	 *  WikiLink will be able to quickly get the Mod Id of
	 *  any item easily.
	 */
	public static void buildItemDataHashMap()
	{
		NBTTagList itemDataList = new NBTTagList();

		GameData.writeItemData(itemDataList);
		for (int i = 0; i < itemDataList.tagCount(); i++)
		{
			ItemData data = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
			
			itemDataModId.put(data.getItemId(), data.getModId());
		}
	}
	
	public static String getGuiDisplay(int index)
	{
		return menuGuiDisplay.get(index);
	}
	
	public static String getGuiHyperlink(int index)
	{
		return menuGuiHyperlink.get(index);
	}
	
	public static void buildGui()
	{
		// If the first slot is empty, check for mod wiki
		if(menuGuiHyperlink.get(0).isEmpty())
		{
			// If mod wiki is unavailable and mod is not Minecraft, add the default mod wiki
			if(LinkWiki.getHyperlink(getStackover()) != null && LinkWiki.getHyperlink(getStackover()) != "Minecraft")
			{
				menuGuiDisplay.set(0, wikiDisplay.get(getItemStackModId(getStackover())));
				menuGuiHyperlink.set(0, LinkWiki.getHyperlink(getStackover()));
				//return;
			}
			// If the mod wiki is not Minecraft and is unavailable, add the minecraft wiki.
			else if(LinkWiki.getHyperlink(getStackover()) != null)
			{
				menuGuiDisplay.set(0, "Default mod wiki");
				menuGuiHyperlink.set(0, "Wiki 1");
				//return;
			}
		}
		
		// If the second slot is empty and there is an existing video, add the registered item spotlights
		if(menuGuiHyperlink.get(1).isEmpty() && LinkYoutube.getItemStackDisplay(getStackover()) != null)
		{
			menuGuiDisplay.set(1, Link.videoItemStackDisplay.get(getStackover().itemID));
			menuGuiHyperlink.set(1, LinkYoutube.getHyperlink(getStackover()));
			//return;
		}
	}
	
	public static void addToGuiDisplayArray(String par1)
	{
		for(int i = 2; i <= 6; i++)
		{
			if(menuGuiDisplay.get(i).isEmpty())
			{
				menuGuiDisplay.set(i, par1);
				break;
			}
		}
	}
	
	public static void addToGuiHyperlinkArray(String par1)
	{			
		for(int i = 2; i <= 6; i++)
		{			
			if(menuGuiHyperlink.get(i).isEmpty())
			{
				menuGuiHyperlink.set(i, par1);
				break;
			}
		}
	}
	
	public static void setDefaultArrayLists()
	{
		for(int i = 0; i <= 6; i++)
		{
			menuGuiDisplay.add(i, "");
			menuGuiHyperlink.add(i, "");
		}
	}
	

}
