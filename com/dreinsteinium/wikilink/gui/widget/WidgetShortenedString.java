package com.dreinsteinium.wikilink.gui.widget;

import net.minecraft.client.gui.FontRenderer;

/** <b>WidgetShortenedString:</b><br>
 *  Element inside of a screen that is meant to draw
 *  a centered string within a set width. If the str
 *  is longer than the width, it will shorten it to 
 *  fit and add "..." to the end.
 *  @author DrEinsteinium
 *  **/
public class WidgetShortenedString extends Widget
{
	private String str;
	private FontRenderer fontrenderer;
	
	private int posX;
	private int posY;
	private int width;
	
	private int color = 0xFFFFFF;
	
	public WidgetShortenedString(String str, int posX, int posY, int width, FontRenderer fontrenderer)
	{
		this.str = str;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.fontrenderer = fontrenderer;
	}
	
	@Override
	public void draw()
	{
		if(this.fontrenderer.getStringWidth(this.str) >= this.width)
			  shorten:for(int i = 0; i < this.str.length(); i++)
			  {
				  this.str = this.str.substring(0, this.str.length() - i).trim() + "...";
				  if(this.fontrenderer.getStringWidth(this.str) <= this.width)
					  break shorten;
			  }
		fontrenderer.drawStringWithShadow(this.str, this.posX - this.fontrenderer.getStringWidth(this.str) / 2, this.posY, this.color);
	}
	
	/** setColor<br>
	 *  Set the color of the string to be displayed
	 *  on the screen. Default color is 0xFFFFFF.
	 *  **/
	public void setColor(int color)
	{
		this.color = color;
	}

}
