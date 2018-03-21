package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.BlockCarpet;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.objects.tabs.CTab;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockTrekCarpet extends BlockCarpet implements IHasModel
{
	// 0.015625D = 1 / 64
	protected static final AxisAlignedBB TREKCARPET_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.015625D, 1.0D);
	
	
	
	protected BlockTrekCarpet(String name, CTab tab)
	{

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		InitBlocks.ALL_BLOCKS.add(this);
		InitItems.ALL_ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
        this.setTickRandomly(true);
    }



	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return TREKCARPET_AABB;
	}



	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, References.MOD_DEFAULT_VARIANT);
	}

}
