package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



/*
 * Class to extend and customise a BlockFacing to render OBJ models (When I can get it working)
 */
public class BlockObj extends BlockFacing implements IHasModel
{

	public BlockObj(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);

		this.useNeighborBrightness = true;
		
		this.isOpaqueCube(null);
		
		this.isFullCube(null);
	}
	
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
	
	
	/**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }



	@Override
	public void registerModels()
	{
		Main.logger.debug("AWOOGA - BlockObj: OBJLoader will now add the domain " + References.MOD_ID + ":");
		OBJLoader.INSTANCE.addDomain(References.MOD_ID);


		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, References.MOD_DEFAULT_VARIANT);
		Main.logger.info("AWOOGA Added Item from BlockObj: " + this.getRegistryName().toString());
	}



}
