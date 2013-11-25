package co.einsteinium.wikilink.ext.nei;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.cfg.ConfigHandler;
import co.einsteinium.wikilink.link.Link;
import co.einsteinium.wikilink.plg.PluginRegistry;
import codechicken.nei.KeyManager;
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
			currenttip.add("\u00a7aPress " + Keyboard.getKeyName(NEIClientConfig.getKeyBinding("wiki")) +  " to open the WikiLink Menu");

		return currenttip;
	}
	
    /** @return tooltipString */
    public String getTooltipString()
    {
    	return tooltipString;
    }

}
