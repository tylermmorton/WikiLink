package co.einsteinium.wikilink.gui;

import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import co.einsteinium.wikilink.WikiLink;


/** GuiWikiLinkMenu
 *  
 *  This menu will be the main menu for the WikiLink information lookup system.
 *  
 *  It will include the ability to set a spotlight (ghost)item, used to fill in
 *  the item parameters for the WikiLink database search. Users can also press I
 *  in NEI while hovering over an item in order to fill the ghost item slot with
 *  the hovered item.
 * 
 *  The ItemId of the item supplied will be sent through all of the registered
 *  databases in order to find all relevent wikis that can be searched for that
 *  specifc item. 
 *  
 *  It will first return the most relevant WikiLink, and after it will list all
 *  relevent YouTube videos(if registered). After all relevant systems have been
 *  listed it will continue to list all default search engines such as Google and 
 *  Bing.
 *  
 *  It will then build a list of the relevent wikis and display them in the brown
 *  scrolling box in the GUI. Here, users can select the link they want to open 
 *  and either copy it to their clipboard or open it in their default browser.
 * 
 *  -- 
 *  
 *  There will also be a second tab on the side(or top) of the GUI that will handle
 *  WikiLink's configurations.
 *  
 *  A similar listing GUI will be available to scroll through. Users can pick config
 *  options from the list and change them instantly in game by pressing buttons. The
 *  GUI will also include a large grey box explaining what the config option does and
 *  what it can be changed to. 
 * 
 */
public class GuiWikiLinkMenu extends GuiContainer
{
	public GuiWikiLinkMenu(InventoryPlayer par1Inventory) 
	{
		super(new ContainerWikiLinkMenu(par1Inventory));
		
		/*
		// Draw the hotbar
		for(int i = 0; i < 9; i++)
		{
		   this.drawSlotInventory(new Slot(par1Inventory, i, 204 + i * 18, 7 ));
		}
		
		// Draw the inventory
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.drawSlotInventory(new Slot(par1Inventory, 9 + x + y * 9, 204 + x * 18, 7 + y * 18 ));
			}
		}
		*/
	}

	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/menu.png");
	
	public int x = 0; 
	public int y = 0;
	public int z = 0;
	
	@Override
	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
		}
	}
	
	public final int xSizeOfTexture = 175;
	public final int ySizeOfTexture = 226;
	
	//protected int xSize = 175;
	//protected int ySize = 244;
	
	//int guiLeft = (this.width - this.xSize) / 2;
	//int guiRight = (this.height - this.ySize) / 2; 
	
	/*
	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		
		this.mc.renderEngine.func_110577_a(textureLocation);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F,1.0F);
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
		
		//drawString(fontRenderer, title, posX + 252, posY + 20, 0x6A5ACD);
		
		// This makes sure text is always inside of the GUI
		//fontRenderer.drawSplitString(<String>, posX + 252, posY + 30, 80, 7);
	}*/
	
	@Override
	public boolean doesGuiPauseGame()
	{			
		return false;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		// ID, x, y, width, height, text
		buttonList.add(new GuiButton(1, posX + 7, posY + 124, 80, 20, "Open WikiLink"));
		buttonList.add(new GuiButton(2, posX + 89, posY + 124, 80, 20, "Clipboard"));
	}
	
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 1:
			{
				WikiLink.LogHelper.info("Button 1 Pressed");
			}
			case 2:
			{
				WikiLink.LogHelper.info("Button 2 Pressed");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
	{
		super.mouseClicked(mouseX,  mouseY,  mouseButton);
		
		for(GuiButton button : (List<GuiButton>) buttonList)
		{
			if(button.mousePressed(mc, mouseX, mouseY))
			{
				mc.sndManager.playSoundFX("random.click", 1, 1);
				actionPerformed(button);
			}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{
		drawDefaultBackground();
		
		this.mc.renderEngine.func_110577_a(textureLocation);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F,1.0F);
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
	}
}
