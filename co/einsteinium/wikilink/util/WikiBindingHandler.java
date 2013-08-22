package co.einsteinium.wikilink.util;

import java.util.ArrayList;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;


/** WikiBindingHandler
 * 
 * @since 1.6.2-001
 * @author DrEinsteinium
 *
 */
public class WikiBindingHandler 
{
	public static boolean found;
	public static int matchedId;
	public static String matchedName;
	public static String matchedModId;
	
	public static int getItemID(EntityPlayer player)
	{
		matchedId = player.getHeldItem().itemID;
		return (player.getHeldItem().itemID);
	}
	
	public static String getItemName(EntityPlayer player)
	{
		matchedName = player.getHeldItem().getDisplayName();
		return (player.getHeldItem().getDisplayName());
	}
	
	private static ItemData itemList(NBTBase base)
	{
		return null;
	}
	
	public static void getInfo(EntityPlayer player)
	{
		NBTTagList itemList = new NBTTagList();
		
		GameData.writeItemData(itemList);
		
		ArrayList<ItemData> data = new ArrayList();
		
		NBTBase base;
	
		LoopTagFinder:
		for(int i = 0; i < itemList.tagCount(); i++)
		{
			int x = 0;
			found = false;
			//WikiLink.LogHelper.info("Starting LoopTagFinder");
			base = itemList.tagAt(i);
			if(base instanceof NBTTagCompound)
			{	
					data.add(itemList(base));
	
					do
					{
					//LoopTagChecker://for(int x = 0; x < Reference.modIdList.size(); x++)
						
						//WikiLink.LogHelper.info("Searching on " + x);
						//WikiLink.LogHelper.info(base.toString());
						Reference.currentLanguage = Minecraft.getMinecraft().gameSettings.language;
							
							if(Reference.currentLanguage.equals("en_CA")||Reference.currentLanguage.equals("en_GB"))
								Reference.currentLanguage = "en_US";
								
								
							if((base).toString().contains("ModId:" + ((Reference.modIdList).get(x))) && (base).toString().contains("ItemId:" + matchedId))
							{
								if(Reference.modLocalizationList.get(x).toString().equals(Reference.currentLanguage))
								{
									WikiLink.LogHelper.info("Found wiki containing " + matchedName + " for " + Reference.currentLanguage);
									
									String hyperlink = "http://" + Reference.modDomainList.get(x) + Reference.getSearchQuery(x) + matchedName.replace(" ", "+");
									
									BrowserHandler.browserInit(hyperlink);
									
									found = true;
									break LoopTagFinder;
								}	
								else if(Reference.modLocalizationList.get(x).toString().equals("ALL"))
								{
									WikiLink.LogHelper.info("Found wiki containing " + matchedName);
									
									String hyperlink = "http://" + Reference.modDomainList.get(x) + Reference.getSearchQuery(x) + matchedName.replace(" ", "+");
									
									BrowserHandler.browserInit(hyperlink);
									
									found = true;
									break LoopTagFinder;
								}
						}	
					x++;	
					}
					while(x < Reference.modIdList.size());		
			}	
		}
		if(found == false)
		{	
			if(Reference.defaultSearchSystem.equals("WIKI"))
			{
			WikiLink.LogHelper.warning("Can not find a wiki containing " + matchedName + " for " + Reference.currentLanguage);
			
			String hyperlink = "http://" + Reference.modDomainList.get(0) + Reference.getSearchQuery(0) + matchedName.replace(" ", "+");
			
			BrowserHandler.browserInit(hyperlink);
			}
			else if(Reference.defaultSearchSystem.equals("BING"))
			{
				WikiLink.LogHelper.warning("Can not find a wiki containing " + matchedName + " for " + Reference.currentLanguage);
				
				String hyperlink = "http://" + "www.bing.com" + "/search?q=" + matchedName.replace(" ", "+");

				BrowserHandler.browserInit(hyperlink);
			}
			else if(Reference.defaultSearchSystem.equals("GOOGLE"))
			{
				WikiLink.LogHelper.warning("Can not find a wiki containing " + matchedName + " for " + Reference.currentLanguage);
				
				String hyperlink = "http://" + "www.google.com" + "/search?q=" + matchedName.replace(" ", "+");

				BrowserHandler.browserInit(hyperlink);
			}
			else
			{
				WikiLink.LogHelper.severe("Can not find default wiki search system!");
			}

		}


	}
	
}
