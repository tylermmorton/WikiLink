package co.einsteinium.wikilink.nei;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.wiki.Link;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.IContainerTooltipHandler;

public class WikiLinkTooltipHandler implements IContainerTooltipHandler
{
	private static String tooltipString;
	
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
		//	currenttip.add("");
			
			//Link.itemDataModId.get(itemstack.itemID);
		
			}
		return currenttip;
	}
	
    /** This method looks in the configuration manager to check what the user has
     *  set as the secondary search engine and creating the tooltip string for it
     *  as apropriate.
     */
  /*  public void setTooltipString()
    {
    	if(ConfigHandler.secondarySearchSystem.equals("BING"))
    	{
    		tooltipString = "start a search on Bing";
    	}
    	else if(ConfigHandler.secondarySearchSystem.equals("VIMEO"))
    	{
    		tooltipString = "start a search on Vimeo";
    	}
    	else if(ConfigHandler.secondarySearchSystem.equals("YAHOO"))
    	{
    		tooltipString = "start a search on Yahoo";
    	}
    	else if(ConfigHandler.secondarySearchSystem.equals("GOOGLE"))
    	{
    		tooltipString = "start a search on Google";
    	}
    	else if(ConfigHandler.secondarySearchSystem.equals("YOUTUBE"))
    	{
    		tooltipString = "start a search on Youtube";
    	}
    	else
    	{
    		//Wiki.arrayIndex = 0;
    		tooltipString = "start a search on the " + Reference.wikiNameList.get(0).toString();
    	}
    }*/
    
    /** @return tooltipString */
    public String getTooltipString()
    {
    	return tooltipString;
    }

}
