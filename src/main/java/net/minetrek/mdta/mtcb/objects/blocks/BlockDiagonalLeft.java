package net.minetrek.mdta.mtcb.objects.blocks;



import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.BlockStairs.EnumShape;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



/*
 * Class to extend and customise a BlockFacing for 45 degree walls, with
 * adjusted boundary boxes
 * 
 * MDTA: Mon 12 Mar - 08:58 - Code has been copied and pasted from the
 * BlockStairs class
 * I will try to test how this works for my diagonal blocks
 */
public class BlockDiagonalLeft extends BlockFacing implements IHasModel
{
	private static double _unit = 1.0D / 16.0D;
	private static double _unitFull = 1.0D;



	public static final AxisAlignedBB AABB_FULL_CUBE = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);



	@Nullable
	public static final AxisAlignedBB NULL_AABB = null;



	/*-
	 *  Bounding Boxes - Block Facing NORTH
	 * 
	 *  ↑ X                      16, Y, 16
	 *  ┌────────────────────────────┬───╖ 16
	 *  │                            │   ║
	 *  │                        ┌───┤   ║ 14
	 *  │                        │   │   ║
	 *  │                    ┌───┤   │   ║ 12
	 *  │                    │   │   │   ║
	 *  │                ┌───┤   │   │   ║ 10
	 *  │                │   │   │   │   ║
	 *  │           ┌────┤   │   │   │   ║ 8
	 *  │           │  H │ G │ E │ C │ A ║
	 *  │       ┌───┴────┴───┤   │   │   ║ 6
	 *  │       │      F     │   │   │   ║
	 *  │   ┌───┴────────────┴───┤   │   ║ 4
	 *  │   │          D         │   │   ║
	 *  ├───┴────────────────────┴───┤   ║ 2
	 *  │              B             │   ║
	 *  ╘════════════════════════════╧═══╝ 0
	 *  0, Y, 0                        → Z
	 */
	protected static final AxisAlignedBB AABB_LEFT_NORTH_A = new AxisAlignedBB(
			0.0D, 0.0D, _unit * 14, 
			_unit * 16, _unitFull, _unit * 16);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_B = new AxisAlignedBB(
			0.0D, 0.0D, 0.0D, 
			_unit * 2, _unitFull, _unit * 14);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_C = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 12, 
			_unit * 14, _unitFull, _unit * 14);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_D = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 2, 
			_unit * 4, _unitFull, _unit * 12);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_E = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 10, 
			_unit * 12, _unitFull, _unit * 12);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_F = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 4, 
			_unit * 6, _unitFull, _unit * 10);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_G = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 8, 
			_unit * 10, _unitFull, _unit * 10);
	
	protected static final AxisAlignedBB AABB_LEFT_NORTH_H = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 6, 
			_unit * 8, _unitFull, _unit * 8);



	/*-
	 *  Bounding Boxes - Block Facing EAST
	 * 
	 *  ↑ X                      16, Y, 16
	 *  ╓───┬────────────────────────────┐ 16
	 *  ║   │                            │
	 *  ║   ├───┐                        │ 14
	 *  ║   │   │                        │
	 *  ║   │   ├───┐                    │ 12
	 *  ║   │   │   │                    │
	 *  ║   │   │   ├───┐                │ 10
	 *  ║   │   │   │   │                │
	 *  ║   │   │   │   ├───┐            │ 8
	 *  ║ B │ D │ F │ G │ H │            │
	 *  ║   │   ├───┴───┴───┴────┐       │ 6
	 *  ║   │   │         E      │       │
	 *  ║   ├───┴────────────────┴───┐   │ 4
	 *  ║   │             C          │   │
	 *  ╟───┴────────────────────────┴───┤ 2
	 *  ║                 A              │
	 *  ╚════════════════════════════════╛ 0
	 *  0, Y, 0                        → Z
	 */
	protected static final AxisAlignedBB AABB_LEFT_EAST_A = new AxisAlignedBB(
			0.0D, 0.0D, 0.0D, 
			_unit * 2, _unitFull, _unit * 16);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_B = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 2, 
			_unit * 16, _unitFull, _unit * 2);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_C = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 2, 
			_unit * 4, _unitFull, _unit * 14);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_D = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 2, 
			_unit * 14, _unitFull, _unit * 4);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_E = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 4, 
			_unit * 6, _unitFull, _unit * 12);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_F = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 4, 
			_unit * 12, _unitFull, _unit * 6);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_G = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 6, 
			_unit * 10, _unitFull, _unit * 10);
	
	protected static final AxisAlignedBB AABB_LEFT_EAST_H = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit* 8, 
			_unit * 8, _unitFull, _unit * 10);



	/*-
	 *  Bounding Boxes - Block Facing SOUTH
	 * 
	 *  ↑ X                      16, Y, 16
	 *  ╔═══╤════════════════════════════╕ 16
	 *  ║   │             B              │
	 *  ║   ├───┬────────────────────┬───┤ 14
	 *  ║   │   │         D          │   │
	 *  ║   │   ├───┬────────────┬───┘   │ 12
	 *  ║   │   │   │     F      │       │
	 *  ║   │   │   ├───┬────┬───┘       │ 10
	 *  ║ A │ C │ E │ G │ H  │           │
	 *  ║   │   │   │   ├────┘           │ 8
	 *  ║   │   │   │   │                │
	 *  ║   │   │   ├───┘                │ 6
	 *  ║   │   │   │                    │
	 *  ║   │   ├───┘                    │ 4
	 *  ║   │   │                        │
	 *  ║   ├───┘                        │ 2
	 *  ║   │                            │
	 *  ╙───┴────────────────────────────┘ 0
	 *  0, Y, 0                        → Z
	 */
	protected static final AxisAlignedBB AABB_LEFT_SOUTH_A = new AxisAlignedBB(
			0.0D, 0.0D, 0.0D, 
			_unit * 16, _unitFull, _unit * 2);
	
	protected static final AxisAlignedBB AABB_LEFT_SOUTH_B = new AxisAlignedBB(
			_unit * 14, 0.0D, _unit * 2, 
			_unit * 16, _unitFull, _unit * 16);
	
	protected static final AxisAlignedBB AABB_LEFT_SOUTH_C = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 2, 
			_unit * 14, _unitFull, _unit * 4);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_D = new AxisAlignedBB(
			_unit * 12, 0.0D, _unit * 4, 
			_unit * 14, _unitFull, _unit * 14);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_E = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 4, 
			_unit * 12, _unitFull, _unit * 6);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_F = new AxisAlignedBB(
			_unit * 10, 0.0D, _unit * 6, 
			_unit * 12, _unitFull, _unit * 12);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_G = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 6, 
			_unit * 10, _unitFull, _unit * 8);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_H = new AxisAlignedBB(
			_unit * 8, 0.0D, _unit * 8, 
			_unit * 10, _unitFull, _unit * 10);



	/*-
	 *  Bounding Boxes - Block Facing West
	 * 
	 *  ↑ X                      16, Y, 16
	 *  ╒════════════════════════════════╗ 16
	 *  │                  A             ║
	 *  ├────┬───────────────────────┬───╢ 14
	 *  │    │             C         │   ║
	 *  │    └───┬───────────────┬───┤   ║ 12
	 *  │        │         E     │   │   ║
	 *  │        └───┬───────┬───┤   │   ║ 10
	 *  │            │     G │   │   │   ║
	 *  │            └───┬───┤   │   │   ║ 8
	 *  │                │ H │ F │ D │ B ║
	 *  │                └───┤   │   │   ║ 6
	 *  │                    │   │   │   ║
	 *  │                    └───┤   │   ║ 4
	 *  │                        │   │   ║
	 *  │                        └───┤   ║ 2
	 *  │                            │   ║
	 *  └────────────────────────────┴───╜ 0
	 *  0, Y, 0                        → Z
	 */
	protected static final AxisAlignedBB AABB_LEFT_WEST_A = new AxisAlignedBB(
			_unit * 14, 0.0D, 0.0D, 
			_unit * 16, _unitFull, _unit * 16);

	protected static final AxisAlignedBB AABB_LEFT_WEST_B = new AxisAlignedBB(
			0.0D, 0.0D, _unit * 14, 
			_unit * 14,	_unitFull, _unit * 16);

	protected static final AxisAlignedBB AABB_LEFT_WEST_C = new AxisAlignedBB(
			_unit * 12, 0.0D, _unit * 2, 
			_unit * 14,	_unitFull, _unit * 14);

	protected static final AxisAlignedBB AABB_LEFT_WEST_D = new AxisAlignedBB(
			_unit * 2, 0.0D, _unit * 12, 
			_unit * 12,	_unitFull, _unit * 14);

	protected static final AxisAlignedBB AABB_LEFT_WEST_E = new AxisAlignedBB(
			_unit * 10, 0.0D, _unit * 4, 
			_unit * 12,	_unitFull, _unit * 12);

	protected static final AxisAlignedBB AABB_LEFT_WEST_F = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 10, 
			_unit * 10,	_unitFull, _unit * 12);

	protected static final AxisAlignedBB AABB_LEFT_WEST_G = new AxisAlignedBB(
			_unit * 8, 0.0D, _unit * 6,
			_unit * 10,	_unitFull, _unit * 10);

	protected static final AxisAlignedBB AABB_LEFT_WEST_H = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 8, 
			_unit * 8, _unitFull, _unit * 10);



	public BlockDiagonalLeft(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);

		this.useNeighborBrightness = true;
	}



	/**
	 * Adds collision boxes to the Block's CollisionBoxes for interacting with the
	 * player
	 */
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	{
		if (!isActualState)
		{
			state = this.getActualState(state, worldIn, pos);
		}

		// Repeat this method for each collision box in a list.
		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
		}
	}



	/*
	 * Create and return a list of AxisAlignedBoundingBoxes based on the direction
	 * the block is facing.
	 */
	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState state)
	{		
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();

		switch ((EnumFacing)state.getValue(FACING))
		{
			case WEST:
			default:
			{
				list.add(AABB_LEFT_WEST_A);
				list.add(AABB_LEFT_WEST_B);
				list.add(AABB_LEFT_WEST_C);
				list.add(AABB_LEFT_WEST_D);
				list.add(AABB_LEFT_WEST_E);
				list.add(AABB_LEFT_WEST_F);
				list.add(AABB_LEFT_WEST_G);
				list.add(AABB_LEFT_WEST_H);
				break;
			}
			case NORTH:
			{
				list.add(AABB_LEFT_NORTH_A);
				list.add(AABB_LEFT_NORTH_B);
				list.add(AABB_LEFT_NORTH_C);
				list.add(AABB_LEFT_NORTH_D);
				list.add(AABB_LEFT_NORTH_E);
				list.add(AABB_LEFT_NORTH_F);
				list.add(AABB_LEFT_NORTH_G);
				list.add(AABB_LEFT_NORTH_H);
				break;
			}
			case SOUTH:
			{
				list.add(AABB_LEFT_SOUTH_A);
				list.add(AABB_LEFT_SOUTH_B);
				list.add(AABB_LEFT_SOUTH_C);
				list.add(AABB_LEFT_SOUTH_D);
				list.add(AABB_LEFT_SOUTH_E);
				list.add(AABB_LEFT_SOUTH_F);
				list.add(AABB_LEFT_SOUTH_G);
				list.add(AABB_LEFT_SOUTH_H);
				break;
			}
			case EAST:
			{
				list.add(AABB_LEFT_EAST_A);
				list.add(AABB_LEFT_EAST_B);
				list.add(AABB_LEFT_EAST_C);
				list.add(AABB_LEFT_EAST_D);
				list.add(AABB_LEFT_EAST_E);
				list.add(AABB_LEFT_EAST_F);
				list.add(AABB_LEFT_EAST_G);
				list.add(AABB_LEFT_EAST_H);
				break;
			}
		}	
		
		return list;
	}
	
		
	
	/*
	 * Get the bounding box to be used to display the visual highlight box around
	 * the block
	 * 
	 * @see
	 * net.minecraft.block.Block#getSelectedBoundingBox(net.minecraft.block.state.
	 * IBlockState, net.minecraft.world.World, net.minecraft.util.math.BlockPos)
	 */
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		switch ((EnumFacing)state.getValue(FACING))
		{
			case WEST:
			default:
			{
				return AABB_FULL_CUBE.offset(pos);
			}
			case NORTH:
			{
				return AABB_LEFT_NORTH_C.offset(pos);
			}
			case SOUTH:
			{
				return AABB_FULL_CUBE.offset(pos);
			}
			case EAST:
			{
				return AABB_FULL_CUBE.offset(pos);
			}
		}
	}



	/**
	 * Ray traces through the blocks collision from start vector to end vector
	 * returning a ray trace hit.
	 */

	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
	{
		List<RayTraceResult> listRT = Lists.<RayTraceResult>newArrayList();

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(blockState))
		{
			listRT.add(this.rayTrace(pos, start, end, axisalignedbb));
		}

		RayTraceResult raytraceresult1 = null;
		double d1 = 0.0D;

		for (RayTraceResult raytraceresult : listRT)
		{
			if (raytraceresult != null)
			{
				double d0 = raytraceresult.hitVec.squareDistanceTo(end);

				if (d0 > d1)
				{
					raytraceresult1 = raytraceresult;
					d1 = d0;
				}
			}
		}

		return raytraceresult1;
	}

	
	
	/**
	 * Determines if the faces of THIS block should cull when placed beside other blocks
	 */
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
		if (net.minecraftforge.common.ForgeModContainer.disableStairSlabCulling)
            return super.doesSideBlockRendering(state, world, pos, face);

        if ( state.isOpaqueCube() )
            return true;
        		
		return false;
    }
	
	
	
	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}



	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

}
