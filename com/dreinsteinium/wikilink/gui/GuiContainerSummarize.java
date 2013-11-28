package com.dreinsteinium.wikilink.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.dreinsteinium.wikilink.gui.util.WikiLinkContainer;
import com.dreinsteinium.wikilink.gui.widget.Widget;
import com.dreinsteinium.wikilink.gui.widget.WidgetFakeItem;
import com.dreinsteinium.wikilink.gui.widget.WidgetShortenedString;

import cpw.mods.fml.client.FMLClientHandler;

/** The GuiContainer Class for the Summarize 
 *  screen. This screen is used when data is
 *  recieved by the Feed the Beast wiki.
 *  
 *  @since  11/27/2013
 *  @author DrEinsteinium
 *  **/
public class GuiContainerSummarize extends GuiContainer
{
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/gui_summary.png");
	
	private ItemStack item;
	private static WikiLinkContainer container;
	
	public GuiContainerSummarize(ItemStack item) 
	{
		super(container = new WikiLinkContainer());
		
		this.item = item;
		this.xSize = 256;
		this.ySize = 256;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
			
		//Add a "visual" slot
		container.addSlot(0, 233, 232);
		
		this.buttonList.add(new GuiButton(0, posX + 6, posY + 230, 110, 20, "WikiLink Menu"));
		this.buttonList.add(new GuiButton(1, posX + 119, posY + 230, 110, 20, "Feed the Beast Wiki"));

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);
		
		Widget itemic = new WidgetFakeItem(this.item, posX + 233, posY + 232, this.fontRenderer, this.renderEngine);
			itemic.draw();
	
		Widget header = new WidgetShortenedString(this.item.getDisplayName(), posX + 123, posY + 8, 242, fontRenderer);		
			header.draw();
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		action:switch(button.id)
		{
			case 0: // WikiLink Menu
			{
				FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerMenu(this.item));
				break action;
			}
			case 1: // FTB Wiki
			{
				
			}
		}
	}

}
