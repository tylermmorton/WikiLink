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

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.gui.util.WikiLinkContainer;
import com.dreinsteinium.wikilink.gui.widget.Widget;
import com.dreinsteinium.wikilink.gui.widget.WidgetFakeItem;
import com.dreinsteinium.wikilink.gui.widget.WidgetScrollPane;
import com.dreinsteinium.wikilink.gui.widget.WidgetShortenedString;
import com.dreinsteinium.wikilink.web.util.WikiParser;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiContainerMenu extends GuiContainer
{
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/gui_menu.png");	

	private static WikiLinkContainer container;

	private String summary;
	private ItemStack item;
	
	private WikiParser wiki;
	
	WidgetScrollPane scroll;
	private int scrollPos = 0;
	private boolean isScrollPressed;
	
	private List scrollButtonList = new ArrayList();
	
	public GuiContainerMenu(ItemStack item) 
	{
		super(container = new WikiLinkContainer());
		
		this.item = item;
		this.xSize = 256;
		this.ySize = 156;
		
		this.wiki = new WikiParser(item);
	}
	
	public GuiContainerMenu(ItemStack item, WikiParser wiki)
	{
	    super(container = new WikiLinkContainer());
	    
	    this.wiki = wiki;
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
		
		GuiButton browserButton = new GuiButton(0, posX + 6, posY + 130, 78, 20, "Browser");
		GuiButton clipbrdButton = new GuiButton(1, posX + 88, posY + 130, 78, 20, "Clipboard");
		GuiButton summaryButton = new GuiButton(2, posX + 170, posY + 130, 78, 20, "Summarize");
		
		String response = wiki.parseResponse();
		if(response == null || response.isEmpty())
			summaryButton.enabled = false;
		
		this.buttonList.add(browserButton);
		this.buttonList.add(clipbrdButton);
		this.buttonList.add(summaryButton);
		
		this.scroll = new WidgetScrollPane(posX + 235, posY + 27, 12, 15, 120, 24, this, this.scrollButtonList, this.textureLocation, 108, 156);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
	
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;

		/** Draw the bg **/
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);
		
		scroll.draw();
		
		/** Draw the widgets **/	
		Widget header = new WidgetShortenedString(this.item.getDisplayName(), posX + 61, posY + 8, 108, fontRenderer);		
			header.draw();		
			
		Widget itemic = new WidgetFakeItem(this.item, posX + 233, posY + 7, this.fontRenderer, this.renderEngine);
			itemic.draw();	

	}
	
	public void actionPerformed(GuiButton button)
	{
		action:switch(button.id)
		{
			case 0: //Browser
			{
				WikiLink.LogHelper.info("Browser Button");
				break action;
			}
			case 1: //Clipboard
			{
				WikiLink.LogHelper.info("Clipboard Button");
				break action;
			}
			case 2: //Summarize
			{
				WikiLink.LogHelper.info("Summarize Button");
				FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerSummarize(this.item, this.wiki));
				break action;
			}
			default: // All other buttons(link selections)
			{
				
			}
		}
	}
	
	@Override
	public void handleMouseInput()
	{
	    super.handleMouseInput();
	    
	    int wheelState;
	    if((wheelState = Mouse.getEventDWheel()) != 0)
	    {
    	    scroll.updateScrollPositon(this.scroll.scrollbarPosY - (wheelState / 10));
	    }
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button)
	{   
	    super.mouseClicked(mouseX, mouseY, button);
	    
	    int posX = (this.width - this.xSize) / 2;
	    int posY = (this.height - this.ySize) / 2;
	    
	    // If they aren't pressing LMB or if the scroll bar is disabled
	    if(button != 0 || this.scroll.scrollbarState == 1)
	        return;
	    
	    //Set isScrollPressed to true when someone clicks on the bar icon
	    if(isMouseOverArea(mouseX, mouseY, posX + 235, posY + 27 + this.scroll.scrollbarPosY, 12, 15))
	        this.scroll.isScrollPressed = true;
	    
	    //Change the position of the bar if someone clicks inside of the area
	    if(isMouseOverArea(mouseX, mouseY, posX + 234, posY + 26, 14, 102))	    
	        this.scroll.updateScrollPositon((mouseY - 100));   
	}
	
	@Override
	public void mouseClickMove(int mouseX, int mouseY, int button, long timeSince)
	{
	    super.mouseClickMove(mouseX, mouseY, button, timeSince);
	    
	    int posX = (this.width - this.xSize) / 2;
        int posY = (this.height - this.ySize) / 2;
    	    
    	if(isMouseOverArea(mouseX, mouseY, posX + 234, posY + 26, 14, 102))
    	    if(Mouse.isButtonDown(0) && this.scroll.isScrollPressed)
    	    {
    	        this.scroll.updateScrollPositon((mouseY - 100));

    	        //WikiLink.LogHelper.info(String.format("You are clicking @ (%s,%s) with button #%s", mouseX-235, mouseY-100, button));
    	        
    	        // If they release the button, set isScrollPressed to false
    	        if(!Mouse.isButtonDown(0))
    	            this.scroll.isScrollPressed = false;
    	    }
	}
	
	private boolean isMouseOverArea(int mouseX, int mouseY, int posX, int posY, int sizeX, int sizeY) 
	{
	   return(mouseX >= posX && mouseX < posX + sizeX && mouseY >= posY && mouseY < posY + sizeY);
	}
	
}
