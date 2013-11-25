package co.einsteinium.wikilink.gui.menu;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.gui.font.FontHelper;

public class GuiContainerMenu extends GuiContainer
{
	//public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/wikilink_menu.png");	

	/** The ItemStack of the item being searched in the menu **/
	public ItemStack item;
	
	public float rotationYaw = 0;
	public float rotationPitch = 0;
	public String summary = null;
	
	/* Scrollbar */
	private boolean isScrolling;
	private boolean wasClicking;
	
	private int nextScroll = 0;
	private int currentScroll = 0;
	
	private int scrollbarPosY = 0;
	private int scrollIconWidth  = 12;
	private int scrollIconHeight = 15;
	
	public List<GuiButton> optionList = new ArrayList();
	
	public GuiContainerMenu(ItemStack item)
	{
		super(new ContainerMenu());
		
		this.item = item;
		this.xSize = 256;
		this.ySize = 156;
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{			
		return true;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		optionList.clear();
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		GuiButton itemButton = new GuiButton(0, posX + 233, posY + 27, 16, 20, "I");
		GuiButton summaryButton = new GuiButton(3, posX + 170, posY + 130, 78, 20, "Summarize");
		
		if(summary == null)
			summaryButton.enabled = false;	
		
		itemButton.enabled = false;
		
		this.buttonList.add(itemButton);		
		this.buttonList.add(summaryButton);
		this.buttonList.add(new GuiButton(1, posX + 6, posY + 130, 78, 20, "Browser"));
		this.buttonList.add(new GuiButton(2, posX + 88, posY + 130, 78, 20, "Clipboard"));
		
		int relI = 0;
		for(int i = relI; i <= relI + 5; i++)
		{
			 optionList.add(new MenuButton(i + 4, posX + 120, posY + 7 + (24 * i), "Test " + i, true));
		}
		
		WikiLink.LogHelper.info("Option List " + optionList.size());
		this.buttonList.addAll(this.optionList);
	}
	
	@Override
	public void updateScreen()
	{
		//this.scrollbarY++;
		this.rotationYaw+=2;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);
		
		if(this.getEntityToRender(item) != null)
			this.renderEntityInScreen(this.getEntityToRender(item), posX + 61, posY + 115);
		
		this.renderItemInSlot(this.item, posX + 233, posY + 7);
		this.drawHeader(this.getItemNameToDraw(item), posX + 61, posY + 8);
		
		this.drawScrollIcon(posX + 235, posY + 51);
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{			
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		
		action:switch(button.id)
		{
			// I
			case 0:
			{
				WikiLink.LogHelper.info("I");
				break action;
			}
			// Browser
			case 1:
			{
				WikiLink.LogHelper.info("Browser");
				break action;
			}
			// Clipboard
			case 2:
			{
				WikiLink.LogHelper.info("Clipboard");
				break action;
			}
			// Google Search
			case 3:
			{
				WikiLink.LogHelper.info("Summarize");
				break action;
			}
			default:
			{
				int id = button.id;
				WikiLink.LogHelper.info("Test " + button.id);
				WikiLink.LogHelper.info("State 1 " + button.enabled);
				
				button.enabled = false;	
				WikiLink.LogHelper.info("State 2 " + button.enabled);
				for(int i = 0; i < buttonList.size() -4; i++)
					if(i != id)
						buttonList.set(i +4, (new MenuButton(i + 4, posX + 120, posY + 7 + (24 * i), "Test " + i, true)));
				
				WikiLink.LogHelper.info("State 3 " + button.enabled);
			}
		}
	}
	
	/** Renders the item/block properly in the interface
	 *  <p>
	 *  Note: Shading is calculated correctly, thanks to
	 *  Reika :)
	 *  
	 *  @param item : The ItemStack to render
	 *  @param posX : The xPosition of the slot
	 *  @param posY : The yPosition of the slot
	 *  **/
	public void renderItemInSlot(ItemStack item, int posX, int posY)
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

		renderer.renderItemAndEffectIntoGUI(this.fontRenderer, renderEngine, item, posX, posY);
	}
	
	public void renderEntityInScreen(EntityLiving entity, int posX, int posY)
	{
		GL11.glPushMatrix();
		GL11.glColor3f(1F, 1F, 1F);
		GL11.glEnable(32826 /* GL_RESCALE_NORMAL_EXT */);
		GL11.glEnable(2903 /* GL_COLOR_MATERIAL */);
		GL11.glPushMatrix();
		GL11.glTranslatef(posX, this.getEntityPositionToRender(entity, posY), 50F);
		
		float f1 = this.getEntityScaleToRender(entity);
		GL11.glScalef(-f1, f1, f1);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
		
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
		
		entity.rotationPitch = 0.0F;
		entity.renderYawOffset = entity.rotationYaw = entity.prevRotationYaw = entity.prevRotationYawHead = entity.rotationYawHead = this.rotationYaw;
		
		GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180F;
		RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		GL11.glPopMatrix();
		
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(32826 /* GL_RESCALE_NORMAL_EXT */);
		GL11.glTranslatef(0F, 0F, 0.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(32826 /* GL_RESCALE_NORMAL_EXT */);
		
		int i1 = 240;
		int k1 = 240;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, i1 / 1.0F, k1 / 1.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(32826 /* GL_RESCALE_NORMAL_EXT */);
		
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(2896 /* GL_LIGHTING */);
		GL11.glDisable(2929 /* GL_DEPTH_TEST */);
		GL11.glPopMatrix();	
	}
	
	public EntityLiving getEntityToRender(ItemStack item)
	{
		EntityLiving entity = null;
		
		//if(item.getItem() instanceof ItemBlock)
			if(item.itemID == 52 || item.itemID == 383)
			{
				try
				{
					Class cz = (Class)EntityList.IDtoClassMapping.get(item.getItemDamage());
					if(cz != null)
					{
						entity = (EntityLiving)cz.getConstructor(new Class[] {World.class}).newInstance(new Object[] {this.mc.theWorld});
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}	
		return entity;
	}
	
	public float getEntityScaleToRender(EntityLiving entity)
	{
		float scale = 0;
		
		if(entity instanceof EntityCow)
			 return 50F;
		else if(entity instanceof EntityBat)
			 return 90F;
		else if(entity instanceof EntityPig)
			 return 50F;
		else if(entity instanceof EntityWolf)
			 return 55F;
		else if(entity instanceof EntityWitch)
			 return 35F;
		else if(entity instanceof EntitySheep)
			 return 50F;
		else if(entity instanceof EntityHorse)
			 return 35F;
		else if(entity instanceof EntityBlaze)
			 return 50F;
		else if(entity instanceof EntityGhast)
			 return 10F;
		else if(entity instanceof EntitySpider)
			 return 45F;
		else if(entity instanceof EntityZombie)
			 return 45F;
		else if(entity instanceof EntityOcelot)
			 return 38F;
		else if(entity instanceof EntityCreeper)
			 return 45F;
		else if(entity instanceof EntityChicken)
			 return 90F;
		else if(entity instanceof EntityVillager)
			 return 45F;
		else if(entity instanceof EntitySkeleton)
			 return 45F;
		else if(entity instanceof EntitySilverfish)
			 return 65F;
		else if(this.item.itemID == 52 && this.item.getItemDamage() == 53)
			 return 7.5F;
		else return 30F;
	}
	
	public int getEntityPositionToRender(EntityLiving entity, int posY)
	{
		if(entity instanceof EntityGhast)
			 return posY - 40;
		else if(entity instanceof EntityBat)
			 return posY + 15;
		else if(entity instanceof EntityWolf)
			 return posY - 15;
		else if(entity instanceof EntityBlaze)
			 return posY + 5;
		else if(entity instanceof EntitySquid)
			 return posY - 40;
		else if(entity instanceof EntitySpider)
			 return posY - 25;
		else if(entity instanceof EntityOcelot)
			 return posY - 25;
		else if(entity instanceof EntityWither)
			 return posY + 20;
		else if(entity instanceof EntitySilverfish)
			 return posY - 30;
		else return posY;
	}
	
	public String getItemNameToDraw(ItemStack item)
	{
		if(item.itemID == 52 || item.itemID == 383)	
			return this.getEntityToRender(item).getTranslatedEntityName();
		
		else return item.getDisplayName();
	}
	
	public void drawHeader(String str, int posX, int posY)
	{
		if(fontRenderer.getStringWidth(str) >= 108)
		  shorten:for(int i = 0; i < str.length(); i++)
		  {
			  str = str.substring(0, str.length() - i).trim() + "...";
			  if(fontRenderer.getStringWidth(str) <= 108)
				  break shorten;
		  }
		
		fontRenderer.drawStringWithShadow(str, posX - fontRenderer.getStringWidth(str) / 2, posY, 0xFFFFFF);
	}	
	
	public void shortenButtonString(String str)
	{
		if(fontRenderer.getStringWidth(str) >= 50)
			shorten:for(int i = 0; i < str.length(); i++)
			{
				str = str.substring(0, str.length() - i).trim() + "...";
					if(fontRenderer.getStringWidth(str) <= 50)
						break shorten;
			}
	}
	
	@Override
	public void handleMouseInput()
	{
		super.handleMouseInput();
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		//if(!(this.scrollbarY >= 127) && !(this.scrollbarY < 52))
		//if(isPointInRegion(posX, posY, this.xSize, this.ySize, Mouse.getX(), Mouse.getY()))
			if(isScrollable() == 0)
				this.scrollbarPosY -= Mouse.getEventDWheel() / this.optionList.size();
		
		if(this.scrollbarPosY > 61)
		   this.scrollbarPosY = 61;
		if(this.scrollbarPosY < 00)
		   this.scrollbarPosY = 00;
		
		this.nextScroll = this.scrollbarPosY / this.optionList.size() + 4;
	}

	public int isScrollable()
	{
		if(this.optionList.size() > 5)
			 return 0;
		else return 1;
	}
	public boolean needsScrollbar()
	{
		if(this.optionList.size() > 5)
			 return true;
		else return false;
	}
	
	public void updateScroll()
	{
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		
		if(this.currentScroll != this.nextScroll)
			for(int i = 0; i < 4; i++)
			{
				WikiLink.LogHelper.info("Scroll ready to update");
				//buttonList.set(i + 4, new MenuButton(i, posX + 120, posY + 7 + (24 * i), "Test " + i +4, true));
			}
		
	}
	
	public void drawScrollIcon(int posX, int posY)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		drawTexturedModalRect(posX, posY + this.scrollbarPosY, 108 + (this.scrollIconWidth * isScrollable()), 156, this.scrollIconWidth, this.scrollIconHeight);
	}
	
	public boolean isPointInRegion(int x, int y, int width, int height, int pointX, int pointY) 
	{
         return pointX >= x && pointX < x + width && pointY >= y && pointY < y + height;
	}
}
