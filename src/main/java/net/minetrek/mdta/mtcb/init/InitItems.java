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
	
	
	/*
	 * CREATIVE TAB ICONS
	 */
	public static final Item ITEM_ENT_ICON = new ItemBase("item_ent_icon", null);
	public static final Item ITEM_DSC_ICON = new ItemBase("item_dsc_icon", null);
	public static final Item ITEM_TOS_ICON = new ItemBase("item_tos_icon", null);
	public static final Item ITEM_TOS_MOVIES_ICON = new ItemBase("item_tos_movies_icon", null);
	public static final Item ITEM_TNG_ICON = new ItemBase("item_tng_icon", null);
	public static final Item ITEM_DS9_ICON = new ItemBase("item_ds9_icon", null);
	public static final Item ITEM_VOY_ICON = new ItemBase("item_voy_icon", null);
	public static final Item ITEM_TNG_MOVIES_ICON = new ItemBase("item_tng_movies_icon", null);
	public static final Item ITEM_JJ_ICON = new ItemBase("item_jj_icon", null);
	public static final Item ITEM_MISC_ICON = new ItemBase("item_misc_icon", null);
}
