package com.dreinsteinium.wikilink.gui.widget;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class WidgetScrollPane extends Widget 
{
	/** The Gui being drawn into **/
	private Gui gui;
	/** The X Position of the Scroll Bar **/
	public int posX;
	/** The Y Position of the Scroll Bar **/
	public int posY;
	/** The Width of the Scroll Bar**/
	private int width;
	/** The Height of the Scroll Bar**/
	public int sHeight;
	/** The Height of the Content Box**/
	private int cHeight;
	private int bHeight;

	/** The current position of the bar **/
	public int scrollbarPosY;
	/** isScrollable **/
	public int scrollbarState;
	
	public boolean isScrollPressed;
	
	/** The X Position of the Scroll Icon **/
	private int tposX;
	/** The Y Position of the Scroll Icon **/
	private int tposY;
	/** The texture sheet the Scroll Icon resides on **/
	private ResourceLocation texture;
	/** The list of GuiButtons the Scroll Bar will be scrolling through **/
	public List<GuiButton> buttonList;
	
	public WidgetScrollPane(int posX, int posY, int width, int sHeight, int cHeight, int bHeight, Gui gui, List<GuiButton> list, ResourceLocation texture, int tposX, int tposY)
	{
		this.gui = gui;
		this.posX = posX;
		this.posY = posY;
		this.tposX = tposX;//108
		this.tposY = tposY;//156
		this.width = width;
		this.sHeight = sHeight;
		this.cHeight = cHeight;
		this.bHeight = bHeight;
		this.texture = texture;
		this.buttonList = list;
		
		this.needsScrollbar();
	}
	
	@Override
	public void draw() 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		this.gui.drawTexturedModalRect(this.posX, this.posY + this.scrollbarPosY, this.tposX + (this.width * this.scrollbarState), this.tposY, this.width, this.sHeight);
	}
	
	/** <b>needsScrollbar</b><br>
	 *  Defines scrollbarState by checking to see
	 *  if the total height of the buttons in the
	 *  buttonList exceeds the content box height
	 *  **/
	public void needsScrollbar()
	{
		if(this.buttonList.size() * this.bHeight > this.cHeight)
			 this.scrollbarState = 0;
		else this.scrollbarState = 1;
	}
	
	/** <b>updateScrollPosition</b><br>
	 *  This method should be used every time the
	 *  scroll bar needs to update.
	 *  **/
	public void updateScrollPositon(int change)
	{
	    if(change != 0)
	    {
    		//if(this.scrollbarState == 0)
    		this.scrollbarPosY = change/*/ (this.bHeight * this.buttonList.size())*/;
    		
    		if(this.scrollbarPosY > 85)// 85 is the height of the full bar - the height of the icon
    		   this.scrollbarPosY = 85;
    		if(this.scrollbarPosY < 00)
    		   this.scrollbarPosY = 00;
    		
    		// Make sure the button list is updated properly
    		this.updateButtonList();
	    }
	}

	/** <b>updateButtonList</b><br>
	 *  Updates the buttons in the buttonList
	 *  based on the position of the scroller
	 *  **/
	public List<GuiButton> updateButtonList()
	{
        return buttonList;

	}
}
