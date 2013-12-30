package com.dreinsteinium.wikilink.ext.nei;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerInputHandler;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.gui.GuiContainerMenu;
import com.dreinsteinium.wikilink.gui.GuiContainerSummarize;

import cpw.mods.fml.client.FMLClientHandler;

public class WikiLinkInputHandler implements IContainerInputHandler
{
	
	private static ItemStack stackover;
    
    public boolean keyTyped(GuiContainer gui, char keyChar, int keyCode)
    {	
        if (keyCode == NEIClientConfig.getKeyBinding("wiki"))
        {
        	GuiContainerManager manager = GuiContainerManager.getManager(gui);
        	
        	if(manager.getStackMouseOver() != null)
        	{
        	    WikiLink.LogHelper.fine("WikiLink is connecting to online sources.");
        	        long start = System.currentTimeMillis();
        		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerMenu(manager.getStackMouseOver()));
        		
        		WikiLink.LogHelper.fine(String.format("WikiLink has connected to the Feed the Beast wiki, taking a total of %s milliseconds! :)", System.currentTimeMillis() - start));
        		WikiLink.LogHelper.fine("Note, if you are concerned with this connection speed, please do not contact the author of the mod. This problem can be fixed with a faster internet connection.");
        	}
        }

        return false;
    }

   
    public void onKeyTyped(GuiContainer gui, char keyChar, int keyID)
    {
    }

    
    public boolean lastKeyTyped(GuiContainer gui, char keyChar, int keyCode)
    {
        return false;
    }

    
    public boolean mouseClicked(GuiContainer gui, int mousex, int mousey, int button)
    {
        return false;
    }

    
    public void onMouseClicked(GuiContainer gui, int mousex, int mousey, int button)
    {
    }

    
    public void onMouseUp(GuiContainer gui, int mousex, int mousey, int button)
    {
    }

    
    public boolean mouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled)
    {
        return false;
    }

    
    public void onMouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled)
    {
    }

    
    public void onMouseDragged(GuiContainer gui, int mousex, int mousey, int button, long heldTime)
    {
    }
}
