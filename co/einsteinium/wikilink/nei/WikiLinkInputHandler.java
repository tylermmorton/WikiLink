package co.einsteinium.wikilink.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.gui.GuiContainerWikiLinkMenu;
import co.einsteinium.wikilink.gui.InventoryWikiLinkMenu;
import co.einsteinium.wikilink.wiki.Link;
import co.einsteinium.wikilink.wiki.LinkWiki;
import co.einsteinium.wikilink.wiki.LinkYoutube;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.IContainerInputHandler;
import cpw.mods.fml.client.FMLClientHandler;

public class WikiLinkInputHandler implements IContainerInputHandler
{
	
	private static ItemStack stackover;
	
    
    public boolean keyTyped(GuiContainer gui, char keyChar, int keyCode)
    {
        if (keyCode == NEIClientConfig.getKeyBinding("wiki"))
        {
        	if(gui.manager.getStackMouseOver() != null)
        	{
	        	stackover = gui.manager.getStackMouseOver();
	        	
	        	Link.setDefaultArrayLists();
	        	Link.setItemStack(stackover, false);
	        	LinkWiki wiki = new LinkWiki(stackover);
	        	
	        	if(Link.videoItemStackLink.get(stackover.itemID) != null)
	        	{
	        		LinkYoutube vid = new LinkYoutube(stackover);
	        	}
	        	
	        	InventoryWikiLinkMenu fakeSlot = new InventoryWikiLinkMenu();
	        	FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerWikiLinkMenu(fakeSlot, stackover));
	        	
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
