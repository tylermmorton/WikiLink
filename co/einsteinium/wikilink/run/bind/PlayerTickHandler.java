package co.einsteinium.wikilink.run.bind;

import java.util.EnumSet;

import co.einsteinium.wikilink.util.WikiBindingHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/** PlayerTickHandler
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class PlayerTickHandler implements ITickHandler
{
	private final EnumSet<TickType> ticksToGet;

	public PlayerTickHandler(EnumSet<TickType> ticksToGet)
	{
	         this.ticksToGet = ticksToGet;
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
	         playerTick((EntityPlayer)tickData[0]);
	}
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
	}
	@Override
	public EnumSet<TickType> ticks()
	{
	         return ticksToGet;
	}
	@Override
	public String getLabel()
	{
	         return "WikiSearchPlayerTick";
	}

	public static void playerTick(EntityPlayer player)
	{
        if(KeybindWiki.keyPressed == true && player.getHeldItem() != null)
        { 
        	WikiBindingHandler.getItemID(player);
        	WikiBindingHandler.getItemName(player);
        	
        	WikiBindingHandler.getInfo(player); 	
    		
        	KeybindWiki.keyPressed = false;
        }
        else
        { KeybindWiki.keyPressed = false; }     
	}
}
