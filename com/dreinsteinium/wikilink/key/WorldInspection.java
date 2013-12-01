package com.dreinsteinium.wikilink.key;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.dreinsteinium.wikilink.gui.GuiContainerMenu;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class WorldInspection extends KeyHandler
{
    boolean keyPressed;
    
    public WorldInspection(KeyBinding[] keyBindings, boolean[] repeatings)
    {
        super(keyBindings, repeatings);
    }
    
    @Override
    public String getLabel()
    {
        return "World Inspection";
    }
    
    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
    {
        this.keyPressed = false;
    }
    
    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {
        this.keyPressed = true;
        World world = Minecraft.getMinecraft().theWorld;
        try
        {
        if(Minecraft.getMinecraft().objectMouseOver != null)
            if(Minecraft.getMinecraft().objectMouseOver.entityHit != null)
            {
                if(Minecraft.getMinecraft().objectMouseOver.entityHit instanceof EntityLiving)
                {Entity entity = (EntityLiving)Minecraft.getMinecraft().objectMouseOver.entityHit;
                
                    //The ItemStack to pass to the GUI
                    //Since it's an entity, I pass a monster egg.
                    ItemStack item = new ItemStack(Item.monsterPlacer);
                        item.setItemDamage(EntityList.getEntityID(entity));
                        
                    FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerMenu(item));
                }   

            }                
            else if(world.blockExists(Minecraft.getMinecraft().objectMouseOver.blockX, 
                                      Minecraft.getMinecraft().objectMouseOver.blockY, 
                                      Minecraft.getMinecraft().objectMouseOver.blockZ))
                {
                    int worldX = Minecraft.getMinecraft().objectMouseOver.blockX;
                    int worldY = Minecraft.getMinecraft().objectMouseOver.blockY;
                    int worldZ = Minecraft.getMinecraft().objectMouseOver.blockZ;
                    
                    int id = world.getBlockId(worldX, worldY, worldZ);
                    ItemStack item = new ItemStack(Block.blocksList[id]);
                        item.setItemDamage(world.getBlockMetadata(worldX, worldY, worldZ));
                    
                    FMLClientHandler.instance().getClient().displayGuiScreen(new GuiContainerMenu(item));
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.PLAYER);
    }
}
