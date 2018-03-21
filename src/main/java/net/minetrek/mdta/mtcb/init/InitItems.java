package net.minetrek.mdta.mtcb.init;



import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTNGCore;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekDoor;
import net.minetrek.mdta.mtcb.objects.items.ItemBase;
import net.minetrek.mdta.mtcb.objects.items.ItemDoorBase;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;



/*
 * List of All Items to be instantiated and then added to the registration list
 */
public class InitItems
{
	public static final List<Item> ALL_ITEMS = new ArrayList<Item>();
	
	
	
	public static final Item ITEM_TNG_ICON = new ItemBase("item_tng_icon", null);
}
