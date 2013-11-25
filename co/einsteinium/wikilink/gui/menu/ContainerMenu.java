package co.einsteinium.wikilink.gui.menu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** ContainerMenu
 *  @since  WL 4.0.1.1
 *  @author DrEinsteinium
 * **/
public class ContainerMenu extends Container
{
	ContainerMenu container;
	
	
	public ContainerMenu()
	{	
		this.addSlotToContainer(new Slot(new InventoryMenu(), 0, 233, 7));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return false;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i)
	{
		return null;
	}

}
