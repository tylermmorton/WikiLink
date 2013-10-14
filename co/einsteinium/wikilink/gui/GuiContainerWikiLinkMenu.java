package co.einsteinium.wikilink.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.util.BrowserHandler;
import co.einsteinium.wikilink.wiki.Link;


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
public class GuiContainerWikiLinkMenu extends GuiContainer
{
	public GuiContainerWikiLinkMenu(InventoryWikiLinkMenu par1, ItemStack stackover) 
	{
		super(new ContainerWikiLinkMenu(par1, stackover));
	}
	
	private String hyperlink = new String();
	private boolean[] isDisabled = new boolean[6];
	
	public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/menu.png");

	public int x = 0; 
	public int y = 0;
	public int z = 0;	
	
	public final int xSizeOfTexture = 176;
	public final int ySizeOfTexture = 154;
	
	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
		}
	}
	
	public boolean doesGuiPauseGame()
	{			
		return false;
	}
	
	public void initGui()
	{
		super.initGui();
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		//Link.buildGui();
		
		WikiLink.LogHelper.info(Link.getGuiDisplay(0));
		WikiLink.LogHelper.info(Link.getGuiDisplay(1));
		
		for(int i = 0; i <= 5; i++)
		{
			if(!Link.getGuiDisplay(i).isEmpty())	
			{
				//WikiLink.LogHelper.info("Adding button " + i);
				buttonList.add(new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
			}
				//buttonList.add(new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
		}
			buttonList.add(new GuiButton(6, posX + 6, posY + 129, 72, 20, "Browser"));
			buttonList.add(new GuiButton(7, posX + 79, posY + 129, 72, 20, "Clipboard"));
	}

	public void setHyperlink(String h)
	{
		hyperlink = h;
	}
	public String getHyperlink()
	{
		return hyperlink;
	}
	
	protected void actionPerformed(GuiButton button)
	{		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		switch(button.id)
		{			
			case 0:
			{
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			case 1:
			{				
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			case 2:
			{
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			case 3:
			{
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			case 4:
			{
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			case 5:
			{
				button.enabled = false;
				
				for(int i = 0; i <= 5; i++)
				{//buttonList.get(i);
					if(!Link.getGuiDisplay(i).isEmpty() && i != button.id)	
					{
						WikiLink.LogHelper.info("Adding button " + i);
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getGuiDisplay(i)));
						
					}
				}
				
				setHyperlink(Link.guiHyperlink.get(button.id));
				
				break;
			}
			// Buttons
			case 6:
			{
				WikiLink.LogHelper.info(getHyperlink());
				if(!getHyperlink().isEmpty())
				{
					BrowserHandler.browserInit(getHyperlink());
				}
				break;
			}
			case 7:
			{
				if(!getHyperlink().isEmpty())
				{
					StringSelection selection = new StringSelection(getHyperlink());
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selection, selection);
				}
				
				break;
			}	
		}
	}
	
/*	@Override
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
	}*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		RenderItem renderer = new RenderItem();
		
		 GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		 
	        RenderHelper.disableStandardItemLighting();
	        GL11.glDisable(GL11.GL_LIGHTING);
	        
	        RenderHelper.enableGUIStandardItemLighting();
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        
	        short shorta = 240;
	        short shortb = 240;
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, shorta / 1.0F, shortb / 1.0F);

		renderer.renderItemAndEffectIntoGUI(fontRenderer, renderEngine, Link.getItemStack(), posX + 153, posY + 131);
	}
}
