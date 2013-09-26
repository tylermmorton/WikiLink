package co.einsteinium.wikilink.nei;

import java.util.List;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.wiki.Wiki;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.api.API;
import codechicken.nei.forge.IContainerTooltipHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class WikiLinkTooltipHandler implements IContainerTooltipHandler
{
	@Override
	public List<String> handleTooltipFirst(GuiContainer gui, int mousex, int mousey, List<String> currenttip) 
	{
		return currenttip;
	}

	@Override
	public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, List<String> currenttip) 
	{	        
		
		boolean wikiFound = false;
		
		if(ConfigHandler.includeTooltipsOnItems == true)
			{
			currenttip.add("");
			
			Wiki.setItemData(itemstack);
		
		        for(int x = 0; x < Reference.wikiIdList.size(); x++)
		        {
		        	if(Reference.wikiIdList.get(x).equals(Wiki.getModId()))
		        	{
		        		//currenttip.add("\u00A7eWiki available for \u00A7a" + Wiki.getModId());
		        		currenttip.add("\u00A7ePress " + Keyboard.getKeyName(NEIClientConfig.getKeyBinding("wiki")) + " to open the " + Reference.wikiNameList.get(x));
		        		wikiFound = true;
		        		break;
		        	}
	
		        }
		  	        if(wikiFound == false)
		        	{
		        		currenttip.add("\u00A7cWiki unavailable for \u00A7a" + Wiki.getModId());
		        		currenttip.add("\u00A7ePress " + Keyboard.getKeyName(NEIClientConfig.getKeyBinding("wiki")) + " to " + Wiki.getDefaultSearchSystem());
		        	}
			}
		return currenttip;
	}

}
