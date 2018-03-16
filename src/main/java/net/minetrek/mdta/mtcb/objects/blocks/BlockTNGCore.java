package net.minetrek.mdta.mtcb.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockTNGCore extends BlockObj implements IHasModel
{
	protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.0D,0.0D,0.5D,1.0D,1.0D,1.0D);
	protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,1.0D,0.5D);
	protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.0D,0.0D,0.0D,0.5D,1.0D,1.0D);
	protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.5D,0.0D,0.0D,1.0D,1.0D,1.0D);
	protected static final AxisAlignedBB AABB_FULL = new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,1.0D,1.0D);
	
	

	public BlockTNGCore(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);
		
		setLightLevel(1f);
		setLightOpacity(15);
	}
	
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		switch ((EnumFacing)state.getValue(FACING))
		{
			case WEST:
			{
				return AABB_WEST;
			}
			case NORTH:
			{
				return AABB_NORTH;
			}
			case SOUTH:
			{
				return AABB_SOUTH;
			}
			case EAST:
			{
				return AABB_EAST;
			}
			default:
			{
				return AABB_FULL;
			}
		}	
    }

}
