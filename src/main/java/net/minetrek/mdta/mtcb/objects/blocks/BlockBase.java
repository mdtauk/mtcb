package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockBase extends Block implements IHasModel
{	
	// Basic constructor variant
	/**
	 * 
	 * @param name  Sets the Unlocalised and Registry name for the BlockBase Block
	 * 
	 * @param material  Sets the Material type the block should inherit from
	 * 
	 * @param tab  Sets which Creative Tab the block should be grouped into for the Creative sMode Inventory
	 */
	public BlockBase(String name, Material material, CreativeTabs tab)
	{
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		InitBlocks.ALL_BLOCKS.add(this);
		InitItems.ALL_ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	
	// Advanced constructor variant
	/**
	 * 
	 * @param name  Sets the Unlocalised and Registry name for the BlockBase Block
	 * 
	 * @param material  Sets the Material type the block should inherit from
	 * 
	 * @param tab  Sets which Creative Tab the block should be grouped into for the Creative Mode Inventory
	 * 
	 * @param lightLevel  Sets the lightLevel emitted by the block - float value between 0-1f (n/16)
	 * 
	 * @param lightOpacity  Sets the lightOpacity value, to prevent light passing through - int value
	 * 
	 * @param sound  Sets the type of sounds this block makes
	 */
	public BlockBase(String name, Material material, CreativeTabs tab, float lightLevel, int lightOpacity, SoundType sound)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(tab);	
		
		setLightLevel(lightLevel);
		setLightOpacity(lightOpacity);
		setSoundType(sound);
		
		InitBlocks.ALL_BLOCKS.add(this);
		InitItems.ALL_ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}



	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
