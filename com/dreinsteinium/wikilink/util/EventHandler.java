package com.dreinsteinium.wikilink.util;

import java.lang.reflect.Field;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EventHandler
{
    @ForgeSubscribe
    public void capeEvent(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving instanceof EntityPlayer)
        {
            if(!event.entityLiving.worldObj.isRemote)
               return;
        
            EntityPlayer player = (EntityPlayer)event.entityLiving;
            
            try
            {   //if(player.username == "DrEinsteinium")
                {Field locationCape = AbstractClientPlayer.class.getDeclaredField("locationCape");
                    locationCape.setAccessible(true);
                    
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
