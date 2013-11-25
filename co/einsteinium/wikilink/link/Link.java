package co.einsteinium.wikilink.link;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.bit.ShortenedLinkGenerator;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.gui.menu.GuiContainerMenu;
import co.einsteinium.wikilink.util.FormatHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;

public class Link
{		
	/** The URL of the website or wiki **/
	private static URL url;
	
	/** The modId of the ItemStack **/
	private static String itemModId;
	
	/** The ItemStack of the item being searched **/
	private static ItemStack itemstack;
	
	/** The HashMap of URLs and their displays. **/
	public static HashMap<URL, String> generatedLinkMapping = new HashMap<URL, String>();
	
	/** The ArrayList of HashMaps used by the GUI for the URL information. **/
	public static ArrayList<HashMap<URL, String>> generatedLinkListing = new ArrayList<HashMap<URL, String>>();	
	
	/** The HashMap of ItemStack.itemID and the corresponding @ModId **/
	public static HashMap<Integer, String> modIdItemIdMapping = new HashMap<Integer, String>();
	
	/** The HashMap of ItemStack.getDisplayName() and the corresponding @ModId **/
	public static HashMap<String, String> modIdItemNameMapping = new HashMap<String, String>();
	
	public Link(String domain, String display, ItemStack item)
	{
		this.itemstack = item;
		this.itemModId = getModId(item);
		
		try{this.url = new URL(domain);}
		catch(MalformedURLException e){e.printStackTrace();}
		
		HashMap<URL, String> map = new HashMap<URL, String>();
			if(!ConfigHandler.shortenUrl)
				map.put(this.url, display);
			else
				map.put(shortenUrl(), display);
		populateArrayList(map);
	}
	
	/** Returns the corresponding @ModId for
	 *  the given ItemStack itemID. **/
	public static String getModId(int i)
	{
		return modIdItemIdMapping.get(i);
	}
	
	/** TODO
	 *  Returns the corresponding @ModId for
	 *  the given ItemStack displayname. **/
	@Deprecated
	public static String getModId(String s)
	{
		return modIdItemNameMapping.get(s);
	}
	
	/** Returns the corresponding @ModId for
	 *  the given ItemStack. **/
	public static String getModId(ItemStack i)
	{
		return modIdItemNameMapping.get(i.itemID);
	}
	
	/** Returns the current ItemStack of the
	 *  item being searched. **/
	public static ItemStack getItemStack()
	{
		return itemstack;
	}
	
	/** Returns the shortened URL of the link
	 *  through the bit.ly generator. Official
	 *  links are created for the user. <br>
	 *  
	 *  <pre>www.wikilink.info/xxxxxx</pre><br>
	 *  **/
	private URL shortenUrl()
	{
		try
		{
			return new URL(new ShortenedLinkGenerator(String.valueOf(this.url)).createLink());
		}
		catch(MalformedURLException e)
		{
			WikiLink.LogHelper.severe("MalformedURLException in WikiLink in shortenURL()");
			e.printStackTrace();
			WikiLink.LogHelper.severe("Now returning original String as URL instead of it's shortened equivalent.");
			return this.url;
		}
	}
	
	/** Shortens the "display" String in order
	 *  to fit it properly inside of the GUI.
	 *  
	 *  Is now done more accurately in GuiContainerMenu
	 */
	@Deprecated
	public static String shortenDisplay(String str)
	{
		if(str.length() > 30)
			return str.substring(0, 30).trim() + "...";
		else return str.trim();
	}
	
	/** Populats the ArrayList used inside
	 *  of the WikiLink menu. This needs to
	 *  be executed every time the GUI inits. 
	 *  
	 *  @param map : HashMap of links & displays
	 *  **/
	public static void populateArrayList(HashMap<URL, String> map)
	{
		for(Entry entry: map.entrySet())
		{
			HashMap<URL, String> newmap = new HashMap<URL, String>();
				newmap.put((URL)entry.getKey(), (String)entry.getValue());
			generatedLinkListing.add(newmap);
		}
	}
	
	/** Returns the String value of the HashMap
	 *  at the given index in the ArrayList.
	 */
	public static String getDisplayIndex(int i)
	{
		String value = null;
		for(Entry<URL, String> entry : generatedLinkListing.get(i).entrySet())
		{
			value = (String)entry.getValue();
			WikiLink.LogHelper.info("Value: " + value);
			return value;
		}
		return value;
	}
	
	/** Returns the URL value of the HashMap
	 *  at the given index in the ArrayList.
	 */
	public static URL getDomainIndex(int i)
	{
		URL key = null;
		for(Entry entry : generatedLinkListing.get(i).entrySet())
		{
			key = (URL)entry.getKey();
		}
		return key;
	}
	
	/** Returns the respected EntityLiving from 
	 *  the given monster spawner or spawn egg.
	 *  
	 *  If no monster is found, it will return 
	 *  a null egg.
	 * **/
	public static EntityLiving getSpawnerEntity(ItemStack item)
	{
		EntityLiving entity = null;
		if(item.itemID == 52 || item.itemID == 383)
		{
			try
			{
				Class cz = (Class)EntityList.IDtoClassMapping.get(item.getItemDamage());
				if(cz != null)
				{
					entity = (EntityLiving)cz.getConstructor(new Class[] {World.class}).newInstance(new Object[] {Minecraft.getMinecraft().theWorld});
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return entity;
	}
	
	/** Returns a display string for a given 
	 *  monster spawner or monster egg.
	 * **/
	public static String getEntityDisplayName(ItemStack item)
	{
		return getSpawnerEntity(item).getTranslatedEntityName();
	}
	
	/** <b>- Utility Method - </b><br>
	 *  This is run on @postinit and creates
	 *  a HashMap of all of the added objects 
	 *  (blocks and items) itemID's & @ModId's
	 *  **/
	public static void buildmodIdItemIdHashMap()
	{
		NBTTagList itemDataList = new NBTTagList();

		GameData.writeItemData(itemDataList);
		for (int i = 0; i < itemDataList.tagCount(); i++)
		{
			ItemData data = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
				modIdItemIdMapping.put(data.getItemId(), data.getModId());
		}
	}	
	
	/** TODO
	 *  <b>- Utility Method - </b><br>
	 *  This is run on @postinit and creates 
	 *  a HashMap of all of the added objects 
	 *  (blocks and items) ItemNames & @ModId's
	 *  **/
	@Deprecated
	public static void buildmodIdItemNameHashMap()
	{
		NBTTagList itemDataList = new NBTTagList();
		GameData.writeItemData(itemDataList);
		for (int i = 0; i < itemDataList.tagCount(); i++)
		{
			ItemData data = new ItemData((NBTTagCompound) itemDataList.tagAt(i));
				ItemStack item = new ItemStack(new Item(data.getItemId()));
				modIdItemNameMapping.put(item.getDisplayName(), data.getModId());
		}
	}	
	
	/** This method returns an error message to the 
	 *  user after the link throws an error. 
	 *  
	 *  This also creates a new Exception and prints
	 *  the stack trace.
	 *  
	 *  @return String for EntityPlayer.addChatMessage();
	 *  **/
	public static String getErrorMessage()
	{
		Exception e = new Exception();
		WikiLink.LogHelper.info("Found an exception when searching for : " + itemstack.getDisplayName());
			e.printStackTrace();
		/* Returns a String for the user in order to be added to the chat. */
		return FormatHandler.DarkRed.format + "[Error 404] " + itemstack.getDisplayName() + " - " + getModId(itemstack.itemID);
	}
}