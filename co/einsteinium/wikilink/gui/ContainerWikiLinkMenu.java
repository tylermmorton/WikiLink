package co.einsteinium.wikilink.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerWikiLinkMenu extends Container
{

	public ContainerWikiLinkMenu(InventoryPlayer invPlayer)
	{
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{	
		return false;
	}

}
