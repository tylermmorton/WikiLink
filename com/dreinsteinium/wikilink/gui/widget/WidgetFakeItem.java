package com.dreinsteinium.wikilink.gui.widget;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class WidgetFakeItem extends Widget
{
	private int posX; 
	private int posY;
	
	private ItemStack item;
	private FontRenderer fontrenderer;
	private TextureManager renderengine;
	
	public WidgetFakeItem(ItemStack item, int posX, int posY, FontRenderer fontrenderer, TextureManager renderengine)
	{
		this.posX = posX;
		this.posY = posY;
		this.item = item;
		this.fontrenderer = fontrenderer;
		this.renderengine = renderengine;
	}
	
	@Override
	public void draw() 
	{
		RenderItem renderer = new RenderItem();
		
		 GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		 
	        RenderHelper.disableStandardItemLighting();
	        GL11.glDisable(GL11.GL_LIGHTING);
	        
	        RenderHelper.enableGUIStandardItemLighting();
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);       
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240 / 1.0F, 240 / 1.0F);

		renderer.renderItemAndEffectIntoGUI(fontrenderer, renderengine, item, posX, posY);
	}

}
