package com.dreinsteinium.wikilink.gui.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class WikiLinkContainer extends Container
{
	public WikiLinkContainer()
	{}
	
	public void addSlot(int index, int posX, int posY)
	{
		this.addSlotToContainer(new Slot(new WikiLinkInventory(), index, posX, posY));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return false;
	}
}
