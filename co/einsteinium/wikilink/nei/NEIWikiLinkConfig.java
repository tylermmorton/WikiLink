package co.einsteinium.wikilink.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.WikiBindingHandler;
import co.einsteinium.wikilink.wiki.Wiki;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerInputHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class NEIWikiLinkConfig implements IConfigureNEI
{
	@Override
	public void loadConfig() 
	{
		API.addKeyBind("wiki", Keyboard.KEY_I);
		LanguageRegistry.instance().addStringLocalization("nei.options.keys.wiki", "Wiki Search");		
		
		GuiContainerManager.addInputHandler(new NEIWikiInputHandler());
	}
	
	@Override
	public String getName() 
	{
		return "WikiLink Addon";
	}

	@Override
	public String getVersion() 
	{
		return Reference.MOD_VERSION;
	}

	public class NEIWikiInputHandler implements IContainerInputHandler
	{

		@Override
		public boolean keyTyped(GuiContainer gui, char keyChar, int keyCode)
		{
	      
			ItemStack stackover = gui.manager.getStackMouseOver();
			
	        if(stackover == null)
	            return false;
	                
	        if(keyCode == NEIClientConfig.getKeyBinding("wiki"))
	        {
	        	//WikiBindingHandler.matchedId = stackover.itemID;
	        	//WikiBindingHandler.matchedName = stackover.getDisplayName();
	        	
	        	Wiki.setCurrentIndex(stackover.getTagCompound());
	        	
	        	
	        	//WikiBindingHandler.initSearchKey();
	            return false;
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
}
