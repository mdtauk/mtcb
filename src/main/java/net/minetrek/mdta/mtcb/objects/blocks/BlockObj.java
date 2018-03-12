package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockObj extends BlockBase implements IHasModel
{

	public BlockObj(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);	
	}



	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
	}



	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	
	
	@Override
	public void registerModels()
	{
		Main.logger.debug("AWOOGA - BlockObj: OBJLoader will now add the domain " + References.MOD_ID + ":");
		OBJLoader.INSTANCE.addDomain(References.MOD_ID);
		
		
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, References.MOD_DEFAULT_VARIANT);
		Main.logger.info("AWOOGA Added Item from Block: " + this.getRegistryName().toString());
	}
	
	
	
}
