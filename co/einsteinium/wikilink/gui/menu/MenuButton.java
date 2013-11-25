package co.einsteinium.wikilink.gui.menu;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class MenuButton extends GuiButton
{
	/** The ResourceLocation for the button textures **/
	protected static final ResourceLocation buttonTextures = new ResourceLocation("wikilink:gui/wikilink_menu.png");
	
    /** True if this control is enabled, false to disable. */
    public boolean enabled;
	
	public MenuButton(int id, int posX, int posY, String display, boolean enabled)
	{
		super(id, posX, posY, 108, 24, display);
		
		this.id = id;
		this.width = 108;
		this.height = 24;
		this.xPosition = posX;
		this.yPosition = posY;
		
		this.enabled = enabled;
		this.drawButton = true;
		this.displayString = display;
		
	}
	
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
	{	
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            
            int k = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 156 + (k * 24), this.width, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 156 + (k * 24), this.width, this.height);
            
            mouseDragged(par1Minecraft, par2, par3);

            /** 
             *  GRAY = 14738632
             *  YELW = 16777120
             *  **/
            int color = 14738632;
            if(!this.enabled )
            {
                color = -6250336;
            }
            else if(this.field_82253_i)
            {
                color = 16777120;
            }
            drawString(fontrenderer, this.displayString, this.xPosition + 3, this.yPosition + 8, color);
         }
	}
}
