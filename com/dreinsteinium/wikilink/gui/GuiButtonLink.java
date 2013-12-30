package com.dreinsteinium.wikilink.gui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.dreinsteinium.wikilink.web.link.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GuiButtonLink extends GuiButton
{

    protected static final ResourceLocation buttonTextures = new ResourceLocation("wikilink:gui/wikilinkmenu.png");
    
    public String hyperlink; 
  
    public boolean needsTooltip;
    
    public Link link;
    public GuiContainerMenu container;
        
    public GuiButtonLink(int id, int posX, int posY, String display, String hyperlink, Link link, boolean enabled, GuiContainerMenu container)
    {
        super(id, posX, posY, 138, 24, display);
        this.link = link;
        this.width = 138;
        this.height = 24;
        this.enabled = enabled;
        this.hyperlink = hyperlink;
        
        this.container = container;
    }
    
    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            
            this.zLevel = 0.0F;
            int hoverstate = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 156 + hoverstate * 24, this.width, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 138 - this.width / 2, 156 + hoverstate * 24, this.width / 2, this.height);
            
            this.mouseDragged(par1Minecraft, par2, par3);
            
            int color = 14737632;
            if (!this.enabled)
            {
                color = 16777120;
            }
            else if (this.field_82253_i)
            {
                color = 16777120;
            }
            
            this.drawString(fontrenderer, this.shortenStringToDraw(this.displayString, 138, fontrenderer), this.xPosition + 3, this.yPosition + 8, color);     
                        
          //if(this.needsTooltip)
            {if(hoverstate == 2)
                {
                    List list = new ArrayList<String>();
                    if(this.link instanceof LinkYoutube)
                    {LinkYoutube link1 = (LinkYoutube)link;
                       list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.youtube.video"));
                       list.add("\u00a7a" + link1.title.trim());
                       list.add("");
                       list.add("\u00a7r" + I18n.getString("wikilink.gui.menu.youtube.authors") + " : \u00a76" + link1.username);
                       list.add("\u00a7r" + I18n.getString("wikilink.gui.menu.youtube.view") + " : \u00a7a\u00a7l" + NumberFormat.getInstance().format(Integer.valueOf(link1.viewCount)));
                       list.add("");
                       list.add("\u00a7r" + I18n.getString("wikilink.gui.menu.youtube.like") + " : \u00a7a\u00a7l" + NumberFormat.getInstance().format(Integer.valueOf(link1.likeCount)));
                       list.add("\u00a7r" + I18n.getString("wikilink.gui.menu.youtube.dislike") + " : \u00a74\u00a7l" + NumberFormat.getInstance().format(Integer.valueOf(link1.dislikeCount)));
                       list.add("\u00a7r" + I18n.getString("wikilink.gui.menu.youtube.favorites") + " : \u00a7e\u00a7l" + NumberFormat.getInstance().format(Integer.valueOf(link1.favoriteCount)));
                       list.add("");
                       list.add("\u00a79\u00a7owww.youtube.com");
                    }
                    else if(this.link instanceof LinkWikiLink)
                    {LinkWikiLink link1 = (LinkWikiLink)link;
                       list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.wiki.search"));
                       list.add("\u00a7a" + link1.getDisplay());
                       list.add("\u00a72> " + container.item.getDisplayName());
                       list.add("");
                       list.add("\u00a79\u00a7o" + link1.getWikiDomainMap().get(link1.index));
                    }
                    else if(this.link instanceof LinkGoogle)
                    {LinkGoogle link1 = (LinkGoogle)link;
                        list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.google.search"));
                        if(link1.getDisplay().equals(link1.getDisplayString(EnumLink.LUCKY)))                       
                            list.add("\u00a7a" + I18n.getString("wikilink.gui.menu.google.iluckyquestion"));              
                        list.add("\u00a72> " + container.item.getDisplayName() + " - " + Link.getModId(container.item));
                        list.add("");
                        list.add("\u00a79\u00a7owww.google.com");
                    }
                    else if(this.link instanceof LinkThread)
                    {LinkThread link1 = (LinkThread)link;
                        list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.thread.forumthread"));
                        list.add("\u00a7a" + link1.getDisplay());
                        list.add("");
                        list.add("\u00a79\u00a7ominecraftforum.net");
                    }
                    else if(this.link instanceof LinkWebsite)
                    {LinkWebsite link1 = (LinkWebsite)link;
                        list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.website.websitelink"));
                        list.add("\u00a7a" + link1.getDisplay());
                        list.add("");
                        list.add("\u00a79\u00a7o" + link1.getWebsiteDomainMap().get(link1.getModId(container.item)));
                    }
                    else if(this.link instanceof LinkEntity)
                    {LinkEntity link1 = (LinkEntity)link;
                    list.add("\u00a76\u00a7l" + I18n.getString("wikilink.gui.menu.wiki.search"));
                    list.add("\u00a7a" + link1.getDisplay());
                    list.add("\u00a72> " + link1.entity.getEntityName());
                    list.add("");
                    list.add("\u00a79\u00a7owww.minecraftwiki.net");
                    }
                                                                 
                    this.drawTooltip(list, par2, par3, fontrenderer);
                }
                
            }
        }
    }
    
    public void drawTooltip(List list, int par2, int par3, FontRenderer fontrenderer)
    {
        int tipwidth = 0;
        for(int i = 0; i < list.size(); i++)
            if(fontrenderer.getStringWidth((String)list.get(i)) > tipwidth)
                tipwidth = fontrenderer.getStringWidth((String)list.get(i));
        
        
        int tipposX = par2 + 12;
        int tipposY = par3 - 12;
        int tipheight = 8;

        if (list.size() > 1)
        {
            tipheight += 2 + (list.size() - 1) * 10;
        }

        if (tipposX + tipwidth > container.width)
        {
            tipposX -= 28 + tipwidth;
        }

        if (tipposY + tipheight + 6 > container.height)
        {
            tipposY = container.height - tipheight - 6;
        }

        this.zLevel = 300.0F;
        int color1 = -267386864;
        this.drawGradientRect(tipposX - 3, tipposY - 4, tipposX + tipwidth + 3, tipposY - 3, color1, color1);
        this.drawGradientRect(tipposX - 3, tipposY + tipheight + 3, tipposX + tipwidth + 3, tipposY + tipheight + 4, color1, color1);
        this.drawGradientRect(tipposX - 3, tipposY - 3, tipposX + tipwidth + 3, tipposY + tipheight + 3, color1, color1);
        this.drawGradientRect(tipposX - 4, tipposY - 3, tipposX - 3, tipposY + tipheight + 3, color1, color1);
        this.drawGradientRect(tipposX + tipwidth + 3, tipposY - 3, tipposX + tipwidth + 4, tipposY + tipheight + 3, color1, color1);
        int color2 = 1347420415;
        int j2 = (color2 & 16711422) >> 1 | color2 & -16777216;
        this.drawGradientRect(tipposX - 3, tipposY - 3 + 1, tipposX - 3 + 1, tipposY + tipheight + 3 - 1, color2, j2);
        this.drawGradientRect(tipposX + tipwidth + 2, tipposY - 3 + 1, tipposX + tipwidth + 3, tipposY + tipheight + 3 - 1, color2, j2);
        this.drawGradientRect(tipposX - 3, tipposY - 3, tipposX + tipwidth + 3, tipposY - 3 + 1, color2, color2);
        this.drawGradientRect(tipposX - 3, tipposY + tipheight + 2, tipposX + tipwidth + 3, tipposY + tipheight + 3, j2, j2);

        for (int k2 = 0; k2 < list.size(); ++k2)
        {
            String s1 = (String)list.get(k2);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            fontrenderer.drawStringWithShadow(s1, tipposX, tipposY, -1);

            if (k2 == 0)
            {
                tipposY += 2;
            }

            tipposY += 10;
        }

        this.zLevel = 1.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.disableStandardItemLighting();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }
    
    public String shortenStringToDraw(String str, int width, FontRenderer fontrenderer)
    {
        if (fontrenderer.getStringWidth(str) > width - 3)
        {
            this.needsTooltip = true;
            shorten: for (int i = 0; i < str.length(); i++)
            {
                str = str.substring(0, str.length() - i).trim() + "...";
                if(str.endsWith(")") || str.endsWith("("))
                   str = str.substring(0, str.length() - (i+1)).trim() + "...";
                if (fontrenderer.getStringWidth(str) < width - 3)
                    break shorten;
            }
        }
        return str;
    }
}
