package co.einsteinium.wikilink.ext.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.gui.menu.GuiContainerMenu;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerInputHandler;
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
        		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerMenu(manager.getStackMouseOver()));
        		//FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerWikiLinkMenu(new InventoryWikiLinkMenu(), manager.getStackMouseOver()));
        		/*
	        	Link.generatedLinkMapping.clear();
	        	Link.generatedLinkListing.clear();
	        	
	        	InventoryWikiLinkMenu fakeSlot = new InventoryWikiLinkMenu();
	        	;*/	
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
