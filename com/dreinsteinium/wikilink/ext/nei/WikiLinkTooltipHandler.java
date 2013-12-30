package com.dreinsteinium.wikilink.ext.nei;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.dreinsteinium.wikilink.cfg.ConfigHandler;

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
		if(ConfigHandler.includeTooltipsOnItems == true)
		    currenttip.add(String.format("\u00a7a" + I18n.getString("wikilink.gui.tooltip.wikiavailable"), Keyboard.getKeyName(NEIClientConfig.getKeyBinding("wiki"))));

		return currenttip;
	}
	
    /** @return tooltipString */
    public String getTooltipString()
    {
    	return tooltipString;
    }
}
