package com.dreinsteinium.wikilink.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.cfg.ConfigHandler;
import com.dreinsteinium.wikilink.gui.util.WikiLinkContainer;
import com.dreinsteinium.wikilink.plg.PluginRegistrar;
import com.dreinsteinium.wikilink.util.BrowserHandler;
import com.dreinsteinium.wikilink.web.link.EnumLink;
import com.dreinsteinium.wikilink.web.link.Link;
import com.dreinsteinium.wikilink.web.link.LinkEntity;
import com.dreinsteinium.wikilink.web.link.LinkGoogle;
import com.dreinsteinium.wikilink.web.link.LinkThread;
import com.dreinsteinium.wikilink.web.link.LinkWebsite;
import com.dreinsteinium.wikilink.web.link.LinkWikiLink;
import com.dreinsteinium.wikilink.web.link.LinkYoutube;
import com.dreinsteinium.wikilink.web.util.WikiParser;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiContainerMenu extends GuiContainer
{
    private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
    private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/wikilinkmenu.png");  
    
    public int posX;
    public int posY;
    private static WikiLinkContainer container;
    
    public ItemStack item;
    public WikiParser wiki;
    
    private String hyperlink;
    private String paragraph;
    
    private static GuiButton browser;
    private static GuiButton clipboard;
    private static GuiButton summarize;
    
    private static GuiButtonLink clicked;
    
    /** Scroll Bar **/
    private int scrollbarPosY;
    private int scrollbarIndex;
      
    private int scrollbarChange;
    private int scrollbarChangeReq;
    
    private boolean isScrollPressed;
    
    private List<GuiButtonLink> scrollButtonList = new ArrayList();
    
    public GuiContainerMenu(ItemStack itemstack)
    {
        super(container = new WikiLinkContainer());
        
        this.xSize = 176;
        this.ySize = 156;
        
        this.item = itemstack;   
        
        if(ConfigHandler.enableSummarize)
        this.wiki = new WikiParser(item);
    }
    public GuiContainerMenu(ItemStack itemstack, WikiParser wiki)
    {
        super(container = new WikiLinkContainer());
        
        this.xSize = 176;
        this.ySize = 156;
        
        this.wiki = wiki;
        this.item = itemstack;  
    }
    
    @Override
    public void initGui()
    {        
        this.posX = (this.width - this.xSize) / 2;
        this.posY = (this.height - this.ySize) / 2;
             
        container.addSlot(container.inventorySlots.size() + 1, posX + 152, posY + 111);
        
        this.browser = new GuiButton(0, posX + 7, posY + 130, 68, 20, I18n.getString("wikilink.gui.menu.browser"));
        this.clipboard = new GuiButton(1, posX + 79, posY + 130, 68, 20, I18n.getString("wikilink.gui.menu.clipboard"));
        this.summarize = new GuiButton(2, posX + 152, posY + 130, 16, 20, "?");      
       
        this.initButtons(); 
        
        //Send the request to the FTB wiki and parse
        if(ConfigHandler.enableSummarize)
        {String response = wiki.parseResponse();
            if(response != null)
               this.paragraph = response;            
        }
        
        this.updateButtons();        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.textureLocation);
        
        this.posX = (this.width - this.xSize) / 2;
        this.posY = (this.height - this.ySize) / 2;
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
        drawTexturedModalRect(this.posX, this.posY, 0, 0, this.xSize, this.ySize);
        
        this.updateItemStackFocus(this.item);
               
        if(this.needsScrollbar())
        {
           Minecraft.getMinecraft().getTextureManager().bindTexture(this.textureLocation);
           this.drawTexturedModalRect(posX + 154, posY + 7 + this.scrollbarPosY, 176, 0, 12, 15);
        }
        else 
        {
           Minecraft.getMinecraft().getTextureManager().bindTexture(this.textureLocation);
           this.drawTexturedModalRect(posX + 154, posY + 7 + this.scrollbarPosY, 176 + 12, 0, 12, 15);
        }
        
    } 
    
    @Override
    public void actionPerformed(GuiButton button)
    {         
        if(button.id == 0)
        {
            WikiLink.LogHelper.info(this.hyperlink);
            BrowserHandler.browserInit(this.hyperlink);
        }
        if(button.id == 1)
        {
            this.setClipboardString(this.hyperlink);
        }
        if(button.id == 2)
        {
            FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerSummarize(this.item, this.wiki));
        }
        if(button.id >= 3)
        {   
            if(button instanceof GuiButtonLink)
            {button.enabled = false;           
             this.clicked = (GuiButtonLink)button;                
                this.hyperlink = clicked.hyperlink;
                
                for(int i = 3; i < this.buttonList.size(); i++)
                  if(this.buttonList.get(i) instanceof GuiButtonLink)
                  {GuiButtonLink temp = (GuiButtonLink)this.buttonList.get(i);
                   if(!temp.equals(clicked))
                       temp.enabled = true;
                  }                     
            }
            
            this.updateButtons();
        }                
    }
        
    /** Redraws the ItemStack into the focus slot **/
    private void updateItemStackFocus(ItemStack itemstack)
    {
        if(itemstack != null)
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
               
           renderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.renderEngine, itemstack, this.posX + 152, this.posY + 111);
        }       
    }
    
    public boolean needsScrollbar()
    {
        if(this.scrollButtonList.size() > 5)
             return true;
        else return false;
    }
    
    public void initButtons()
    {    
        this.scrollButtonList.clear();
        
        if(ConfigHandler.enableWiki)
        {
            //If the item is an egg or spawner, add the entity link
            if(this.item.itemID == 52 || this.item.itemID == 383)
            {EntityLiving entity = this.getEntityToRender(this.item);
                LinkEntity link = new LinkEntity(this.item, entity);
                this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), link.getDisplay() + " (" + link.entity.getEntityName() + ")", link.getHyperlink(), link, true, this));
            }
            
            for(int i = 0; i < PluginRegistrar.getWikiIdMap().size(); i++)
            if(PluginRegistrar.getWikiIdMap().get(i).equals(Link.getModId(this.item)))
            {LinkWikiLink link = new LinkWikiLink(this.item, i);
             this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), link.getDisplay() + " (" + item.getDisplayName() + ")", link.getHyperlink(), link, true, this));
            }
        }
          
        if(ConfigHandler.enableWebsite)
        for(Map.Entry<String, String> entry : PluginRegistrar.getWebsiteDisplayMap().entrySet())
        {
           if(entry.getKey().equals(Link.getModId(this.item)))
           {
               LinkWebsite link = new LinkWebsite(this.item);
               this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), link.getDisplay(), link.getHyperlink(), link, true, this));
           }
       }
        
        if(ConfigHandler.enableYoutube)
        for(int i = 0; i < PluginRegistrar.getYoutubeItemList().size(); i++)
        {if(ItemStack.areItemStacksEqual(PluginRegistrar.getYoutubeItemList().get(i), this.item))   
            {LinkYoutube link = new LinkYoutube(this.item, PluginRegistrar.getYoutubeCodeList().get(i));
                this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), link.getDisplay(), link.getHyperlink(), link, true, this));
            }
        }
        
        if(ConfigHandler.enableThread)
        for(Map.Entry<String, String> entry: PluginRegistrar.getThreadMap().entrySet())
        {
            if(Link.getModId(this.item).equals(entry.getKey()))
            {
                LinkThread link = new LinkThread(this.item);
                this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), link.getDisplay(), link.getHyperlink(), link, true, this));
            }
        }
        
        if(ConfigHandler.enableGoogle)
        {
            LinkGoogle lucky = new LinkGoogle(this.item, EnumLink.LUCKY);
            LinkGoogle google = new LinkGoogle(this.item, EnumLink.GOOGLE);
        
            this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), google.getDisplay(), google.getHyperlink(), google, true, this));
            this.scrollButtonList.add(new GuiButtonLink(scrollButtonList.size() + 3, posX + 8, posY + 7 + (24 * (scrollButtonList.size())), lucky.getDisplay(), lucky.getHyperlink(), lucky, true, this));
        }

                
        this.scrollbarChangeReq = 85 / this.scrollButtonList.size();
        this.updateButtonsList();
        
    }
    
    public void updateButtons()
    {
        if(this.browser != null)
        {if(this.hyperlink != null)
         {  
            this.browser.enabled = true;
            this.clipboard.enabled = true;  
         } 
        else
        {
            this.browser.enabled = false;
            this.clipboard.enabled = false;   
        }
         if(this.paragraph != null)        
            this.summarize.enabled = true;         
         else         
            this.summarize.enabled = false;
         
        }
    }
    
    public void updateButtonsList()
    {       
        this.buttonList.clear();
             buttonList.add(this.browser);
             buttonList.add(this.clipboard);
             buttonList.add(this.summarize);
             
        int id = 3;
        for(int i = this.scrollbarIndex; i < this.scrollbarIndex + 5 && i < this.scrollButtonList.size(); i++)   
        {   GuiButtonLink but = this.scrollButtonList.get(i); 
            this.buttonList.add(new GuiButtonLink(id, posX + 8, posY + 7 + (24 * (i - this.scrollbarIndex)), but.displayString, but.hyperlink, but.link, but.enabled, this));
            
            id++;  
        }
    }
    
    public void updateScrollPositon(int change)
    {
        if(change != 0 && this.needsScrollbar() == true)
        {
            //if(this.scrollbarState == 0)
            this.scrollbarPosY = change/*/ (this.bHeight * this.buttonList.size())*/;
                    
            if(this.scrollbarPosY > 85)// 85 is the height of the full bar - the height of the icon
                this.scrollbarPosY = 85;
            if(this.scrollbarPosY < 00)
                this.scrollbarPosY = 00;
            
            // Reset the browser and clipboard buttons because the button is being
            // re-enabled. It's kind of a workaround for another logic glitch in the
            // code some where that I can not find. 
            this.hyperlink = null;
            
            // If the change is greater than what is required.
            //if(change >= this.scrollbarChangeReq || change <= (-1 * this.scrollbarChangeReq))
                this.updateScrollIndex();
        }
    }
    
    public void updateScrollIndex()
    {   
        if(this.scrollbarPosY <= this.scrollbarChangeReq)
        {
           this.scrollbarIndex = 0;
           this.scrollbarChange = this.scrollbarPosY;
                   
           this.updateButtonsList();
        }
        else if(this.scrollbarPosY - this.scrollbarChange >= this.scrollbarChangeReq)           
        {
           this.scrollbarIndex++;        
           this.scrollbarChange = this.scrollbarPosY; 
           this.updateButtonsList(); 
        }
        else if(this.scrollbarPosY - this.scrollbarChange <= (-1 * this.scrollbarChangeReq))   
        {
           this.scrollbarIndex--;
           this.scrollbarChange = this.scrollbarPosY; 
           
           //Reset the scroll index if it gets below 0 for
           //some glitchy reason...
           if(this.scrollbarIndex < 0)
              this.scrollbarIndex = 0;
           
           this.updateButtonsList(); 
        }                                   
    }
   
    private boolean isMouseOverArea(int mouseX, int mouseY, int posX, int posY, int width, int height) 
    {
       return(mouseX >= posX && mouseX < posX + width && mouseY >= posY && mouseY < posY + height);
    }
    
    @Override
    public void handleMouseInput()
    {
        super.handleMouseInput();
        
        int wheelState;
        if((wheelState = Mouse.getEventDWheel()) != 0)      
            this.updateScrollPositon(this.scrollbarPosY - (wheelState / 10));       
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button)
    {   
        super.mouseClicked(mouseX, mouseY, button);
        
        int posX = (this.width - this.xSize) / 2;
        int posY = (this.height - this.ySize) / 2;
       
        //If they aren't pressing LMB or if the scroll bar is disabled
        if(button != 0 || this.needsScrollbar() == false)
           return;
        
        //Set isScrollPressed to true when someone clicks on the bar icon
        if(isMouseOverArea(mouseX, mouseY, posX + 154, posY + 7 + this.scrollbarPosY, 12, 15))
            this.isScrollPressed = true;
        
        //Change the position of the bar if someone clicks inside of the area
        //if(isMouseOverArea(mouseX, mouseY, posX + 234, posY + 26, 14, 102))       
        //    this.updateScrollPositon((mouseY - 100));   
    }
    
    @Override
    public void mouseClickMove(int mouseX, int mouseY, int button, long timeSince)
    {
        super.mouseClickMove(mouseX, mouseY, button, timeSince);
        
        int posX = (this.width - this.xSize) / 2;
        int posY = (this.height - this.ySize) / 2;
            
        //if(isMouseOverArea(mouseX, mouseY, posX + 234, posY + 26, 14, 102))
            if(Mouse.isButtonDown(0) && this.isScrollPressed)
            {
                this.updateScrollPositon((mouseY - posY) - 5);

                // If they release the button, set isScrollPressed to false
                if(!Mouse.isButtonDown(0))
                    this.isScrollPressed = false;
            }
    }
    
    public EntityLiving getEntityToRender(ItemStack item)
    {
        EntityLiving entity = null;
        
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
}