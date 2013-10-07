package co.einsteinium.wikilink.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class GuiWikiLinkButton extends GuiButton
{
    /** Button width in pixels */
    protected int width;

    /** Button height in pixels */
    protected int height;

    /** The x position of this control. */
    public int xPosition;

    /** The y position of this control. */
    public int yPosition;

    /** The string displayed on this control. */
    public String displayString;

    /** ID for this control. */
    public int id;

    /** True if this control is enabled, false to disable. */
    public boolean enabled;
    
    /** Hides the button completely if false. */
    public boolean drawButton;
    protected boolean field_82253_i;
	
	protected static final ResourceLocation buttonTextures = new ResourceLocation("wikilink:gui/menu.png");
	
	public GuiWikiLinkButton(int par1, int par2, int par3, int par4, int par5, String par6Str) 
	{
		super(par1, par2, par3, par4, par5, par6Str);
				
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.drawButton = true;
        this.id = par1;
        this.xPosition = par2;
        this.yPosition = par3;
        this.width = par4;
        this.height = par5;
        this.displayString = par6Str;
	}
	
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
	{	
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            
            int k = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 154 + (k * 20), this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 154 + (k * 20), this.width / 2, this.height);
            
            this.mouseDragged(par1Minecraft, par2, par3);
            int l = 14737632;

            if (!this.enabled )
            {
                l = -6250336;
            }
            else if (this.field_82253_i)
            {
                l = 16777120;
            }
            this.drawString(fontrenderer, this.displayString, this.xPosition + 3, this.yPosition + 6, l);
            //this.drawString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }

	}
	
/*
	@Override
    public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
    {
        return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
    }
*/
}
