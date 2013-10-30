package co.einsteinium.wikilink.link;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.gui.GuiContainerWikiLinkMenu;
import co.einsteinium.wikilink.gui.InventoryWikiLinkMenu;
import co.einsteinium.wikilink.plg.PluginRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

public class Link
{
	private static ItemStack itemstack;
	
	private static ArrayList<String> domainList = new ArrayList<String>();
	private static ArrayList<String> displayList = new ArrayList<String>();
	
	public static HashMap<Integer, String> itemDataMap = new HashMap<Integer, String>();
	
	public Link(String domain, String display, ItemStack item)
	{
		this.itemstack = item;
		
		addToGuiList(this.domainList, domain.replace(' ', '+'));
		if(display.trim().length() > 29)
		{
		  addToGuiList(this.displayList, display.substring(0, 29).trim() + "...");
		}
		else addToGuiList(this.displayList, display);
	}
	
	public static void initGui(ItemStack itemstack)
	{
		InventoryWikiLinkMenu fakeSlot = new InventoryWikiLinkMenu();
		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerWikiLinkMenu(fakeSlot, itemstack));
	}
	
	public static void addToGuiList(ArrayList list, String str)
	{
		for(int i = 0; i <= 5; i++)
		{
			if(list.get(i).equals("") || list.get(i) == null)
			{
				list.set(i, str);
				break;
			}
		}
	}
	
	public static void resetGuiList(ArrayList list)
	{
		for(int i = 0; i <= 5; i++)
		{
			list.add(i, "");
		}
	}
	
	public static String getDomainListIndex(int index)
	{
		if(domainList.get(index) != null)
		{
			return domainList.get(index);
		}
		else
		{
			WikiLink.LogHelper.severe("Could not return String for given index. (getDomainListIndex(int index))");
			return null;
		}
	}
	
	public static String getDisplayListIndex(int index)
	{
		if(displayList.get(index) != null)
		{
			return displayList.get(index);
		}
		else
		{
			WikiLink.LogHelper.severe("Could not return String for given index. (getDisplayListIndex(int index))");
			return null;
		}
	}
	
	public static ArrayList getDomainList()
	{
		return domainList;
	}
	
	public static ArrayList getDisplayList()
	{
		return displayList;
	}
	
	public static ItemStack getItemStack()
	{
		return itemstack;
	}
	
	public static String getItemIdModId(int itemId)
	{
		if(itemDataMap.containsKey(itemId))
		{
			return itemDataMap.get(itemId);
		}
		else
		{
			WikiLink.LogHelper.severe("Could not find matching ModId for given integer.");
			return null;
		}
	}
	
	public static String getItemStackModId(ItemStack item)
	{
		if(itemDataMap.containsKey(item.itemID))
		{
			return itemDataMap.get(item.itemID);
		}
		else
		{
			WikiLink.LogHelper.severe("Could not find matching ModId for given ItemStack.");
			return null;
		}
	}
	
	public static void buildItemDataHashMap()
	{
		NBTTagList itemDataList = new NBTTagList();

		GameData.writeItemData(itemDataList);
		for (int i = 0; i < itemDataList.tagCount(); i++)
		{
			ItemData data = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
			
			itemDataMap.put(data.getItemId(), data.getModId());
			
			if(data.getItemId() == 360)
			{
				data.setName("Watermelone", "Minecraft");
			}
			if(data.getItemId() == 103)
			{
				data.setName("Giant Watermelone", "Minecraft");
			}
		}
	}	
}