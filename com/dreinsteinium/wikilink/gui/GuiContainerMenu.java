package com.dreinsteinium.wikilink.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.dreinsteinium.wikilink.gui.util.WikiLinkContainer;
import com.dreinsteinium.wikilink.gui.widget.WidgetFakeItem;
import com.dreinsteinium.wikilink.gui.widget.WidgetScrollPane;
import com.dreinsteinium.wikilink.gui.widget.WidgetShortenedString;

public class GuiContainerMenu extends GuiContainer
{
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/gui_menu.png");	

	private static WikiLinkContainer container;

	private ItemStack item;
	
	private WidgetFakeItem itemic;
	private WidgetScrollPane scroll;
	private WidgetShortenedString header;
	
	private List<GuiButton> linkList = new ArrayList<GuiButton>();
	
	public GuiContainerMenu(ItemStack item) 
	{
		super(container = new WikiLinkContainer());
		
		this.item = item;
		this.xSize = 256;
		this.ySize = 156;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;

		GuiButton summaryButton = new GuiButton(3, posX + 170, posY + 130, 78, 20, "Summarize");

		this.buttonList.add(summaryButton);
		this.buttonList.add(new GuiButton(1, posX + 6, posY + 130, 78, 20, "Browser"));
		this.buttonList.add(new GuiButton(2, posX + 88, posY + 130, 78, 20, "Clipboard"));
		
		for(int i = 3; i < 9; i++)
			this.linkList.add(new GuiButton(i, posX + 88, posY + 130, 78, 20, "Clipboard"));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
	
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);

		itemic = new WidgetFakeItem(this.item, posX + 233, posY + 7, this.fontRenderer, this.renderEngine);
			itemic.draw();	
			
		scroll = new WidgetScrollPane(posX + 235, posY + 27, 12, 15, 100, 24, this, linkList, this.textureLocation, 108, 156);	
			scroll.draw();
			
		header = new WidgetShortenedString(this.item.getDisplayName(), posX + 61, posY + 8, 242, fontRenderer);		
			header.draw();
	}
	
	@Override
	public void updateScreen()
	{
		//if(!scroll.updateButtonList().isEmpty())
			//for(int x = 3; x < 8; x++)
				//this.buttonList.set(x, scroll.updateButtonList().get(x-3));		
	}
	
	@Override
	public void handleMouseInput()
	{
		super.handleMouseInput();
		
		scroll.updateScrollPositon(Mouse.getEventDWheel());
	}
}
