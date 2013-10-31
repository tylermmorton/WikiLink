package co.einsteinium.wikilink.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerWikiLinkMenu extends Container
{	
	public ContainerWikiLinkMenu(InventoryWikiLinkMenu fakeInv, ItemStack stackover)
	{
		this.addSlotToContainer(new Slot(fakeInv, 0, 153, 131));
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
