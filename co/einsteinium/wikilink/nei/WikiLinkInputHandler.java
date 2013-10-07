package co.einsteinium.wikilink.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.gui.GuiContainerWikiLinkMenu;
import co.einsteinium.wikilink.gui.InventoryWikiLinkMenu;
import co.einsteinium.wikilink.util.BrowserHandler;
import co.einsteinium.wikilink.wiki.Link;
import co.einsteinium.wikilink.wiki.LinkWiki;
import co.einsteinium.wikilink.wiki.LinkYoutube;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.IContainerInputHandler;
import cpw.mods.fml.client.FMLClientHandler;

public class WikiLinkInputHandler implements IContainerInputHandler
{
	
	private static ItemStack stackover;
	
    @Override
    public boolean keyTyped(GuiContainer gui, char keyChar, int keyCode)
    {
        if (keyCode == NEIClientConfig.getKeyBinding("wiki"))
        {
        	if(gui.manager.getStackMouseOver() != null)
        	{
	        	stackover = gui.manager.getStackMouseOver();
	        	
	        	LinkWiki wiki = new LinkWiki(stackover);
	        	WikiLink.LogHelper.info(wiki.getHyperlink(stackover));
	        	
	        	WikiLink.LogHelper.info(LinkYoutube.getHyperlink(stackover) + " : " + LinkYoutube.getItemStackDisplay(stackover));
	        	
	        	//BrowserHandler.browserInit(LinkYoutube.getHyperlink(stackover));
	        	
	        	Link.setStackover(stackover);
	        	Link.setDefaultArrayLists();
	        	//LinkWiki wiki = new LinkWiki(stackover);
	        	//WikiLink.LogHelper.info(wiki.getHyperlink());
	        	
	        //	Link.printItemInformation(stackover);
	        	
	        	InventoryWikiLinkMenu fakeSlot = new InventoryWikiLinkMenu();
	        	FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerWikiLinkMenu(fakeSlot, stackover));
	        	
        	}
        }

        return false;
    }

    @Override
    public void onKeyTyped(GuiContainer gui, char keyChar, int keyID)
    {
    }

    @Override
    public boolean lastKeyTyped(GuiContainer gui, char keyChar, int keyCode)
    {
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContainer gui, int mousex, int mousey, int button)
    {
        return false;
    }

    @Override
    public void onMouseClicked(GuiContainer gui, int mousex, int mousey, int button)
    {
    }

    @Override
    public void onMouseUp(GuiContainer gui, int mousex, int mousey, int button)
    {
    }

    @Override
    public boolean mouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled)
    {
        return false;
    }

    @Override
    public void onMouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled)
    {
    }

    @Override
    public void onMouseDragged(GuiContainer gui, int mousex, int mousey, int button, long heldTime)
    {
    }
}
