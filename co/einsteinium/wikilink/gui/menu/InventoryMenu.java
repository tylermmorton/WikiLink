package co.einsteinium.wikilink.gui.menu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/** InventoryMenu for {@link ContainerMenu}
 *  <p>
 *  This class if for the "Fake Slot" inside
 *  of the GUI. The slot is not used for any
 *  actual storing of ItemStacks.
 *  <p>
 *  The ItemStack's ICON is rendered over the
 *  slot to make it look like an Item, but it
 *  is not. This prevents duping/cheating and
 *  the likes.
 * 
 *  @since  WL 4.0.1.1
 *  @author DrEinsteinium
 *  **/
public class InventoryMenu implements IInventory
{
	@Override
	public int getSizeInventory()
	{
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j)
	{
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i)
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		
	}

	@Override
	public String getInvName()
	{
		return null;
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 0;
	}

	@Override
	public void onInventoryChanged()
	{
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return false;
	}

	@Override
	public void openChest()
	{
		
	}

	@Override
	public void closeChest()
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}

}
