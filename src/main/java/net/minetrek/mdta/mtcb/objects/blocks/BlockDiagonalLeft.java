package net.minetrek.mdta.mtcb.objects.blocks;



import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
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
	/*-
	 * B O U N D I N G   B O X   G O A L
	 * 
	 *                               
	 * 1/0                 1/1       ┃
	 * ╒═════════════════════╗     ━━╋━━        ╭───◂
	 * │          A          ║       ┃          │ ╔════╤══════════╕     Z ┃
	 * │                     ║       ▼          ▼ ║    │          │       ▼
	 * ├──────┬────────┬─────╢                    ║    ├─────┬────┤       
	 * │      │        │     ║                    ║    │     │    │        ╱
	 * │      │   C    │     ║ Outer sides        ║    │     │    │     Y ╱ = Height
	 * │      │        │  B  ║ for culling        ║    ├─────┘    │
	 * │      └────────┤     ║                    ║    │          │      
	 * │               │     ║                    ╙────┴──────────┘     X ━━━►
	 * │               │     ║ The AABBs need to
	 * └───────────────┴─────╜ rotate with the block
	 * 0/0                0/1
	 * 
	 * Facing: North Align: Left units are 1 16th
	 * 
	 * A = 6 x 16 | B = 10 x 16 | C = 6 x 6 | D & E = 2 x 2
	 */

	private static double _unit = 1.0D / 16.0D;



	public static final AxisAlignedBB AABB_FULL_CUBE = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	@Nullable
	public static final AxisAlignedBB NULL_AABB = null;



	protected static final AxisAlignedBB AABB_LEFT_NORTH_A = new AxisAlignedBB(
			0.0D, 0.0D, _unit * 10, 
			_unit * 16, _unit * 16, _unit * 16);

	protected static final AxisAlignedBB AABB_LEFT_NORTH_B = new AxisAlignedBB(
			0.0D, 0.0D, 0.0D, 
			_unit * 6, _unit * 16, _unit * 10);

	protected static final AxisAlignedBB AABB_LEFT_NORTH_C = new AxisAlignedBB(
			_unit * 6, 0.0D, _unit * 4, 
			_unit * 12, _unit * 16, _unit * 10);


	/**
	 * TODO: Add collision boxes for the block facing East
	 */
	protected static final AxisAlignedBB AABB_LEFT_EAST_A = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_LEFT_EAST_B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_LEFT_EAST_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_A = new AxisAlignedBB( 
			0.0D, 0.0D, 0.0D,																				
			_unit * 16, _unit * 16, _unit * 6);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_B = new AxisAlignedBB( 
			_unit * 10, 0.0D, _unit * 6,																				
			_unit * 16, _unit * 16, _unit * 16);

	protected static final AxisAlignedBB AABB_LEFT_SOUTH_C = new AxisAlignedBB( 
			_unit * 4, 0.0D, _unit * 6,
			_unit * 10, _unit * 19, _unit * 12);

	
	
	protected static final AxisAlignedBB AABB_LEFT_WEST_A = new AxisAlignedBB(
			_unit * 10, 0.0D, 0.0D, 
			_unit * 16, _unit * 16, _unit * 16);
	protected static final AxisAlignedBB AABB_LEFT_WEST_B = new AxisAlignedBB(
			0.0D, 0.0D, _unit * 10, 
			_unit * 10, _unit * 16, _unit * 16);
	protected static final AxisAlignedBB AABB_LEFT_WEST_C = new AxisAlignedBB(
			_unit * 4, 0.0D, _unit * 4, 
			_unit * 10, _unit * 16, _unit * 10);

	/**/

	/*
	protected static final AxisAlignedBB AABB_RIGHT_NORTH_A = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_NORTH_B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_NORTH_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

	protected static final AxisAlignedBB AABB_RIGHT_EAST_A = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_EAST_B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_EAST_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

	protected static final AxisAlignedBB AABB_RIGHT_SOUTH_A = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_SOUTH_B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_SOUTH_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

	protected static final AxisAlignedBB AABB_RIGHT_WEST_A = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_WEST_B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_RIGHT_WEST_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	*/



	public BlockDiagonalLeft(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);

		this.useNeighborBrightness = true;
	}


	/**
	 * TODO: Switch out the collision to fit the facing direction
	 */
	@Override
	public void addCollisionBoxToList(IBlockState iBlockState, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	{
		IBlockState state = this.getActualState(iBlockState, worldIn, pos);

		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEFT_WEST_A);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEFT_WEST_B);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEFT_WEST_C);
	}



	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState state)
	{
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
	    list.add(AABB_LEFT_WEST_A);
		list.add(AABB_LEFT_WEST_B);
		list.add(AABB_LEFT_WEST_C);

		return list;
	}



	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		//return AABB_LEFT_WEST_C.offset(pos);
		
		return AABB_FULL_CUBE.offset(pos);
	}



	/**
	 * Ray traces through the blocks collision from start vector to end vector
	 * returning a ray trace hit.
	 */
	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
	{
		List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, worldIn, pos)))
		{
			list.add(this.rayTrace(pos, start, end, axisalignedbb));
		}

		RayTraceResult raytraceresult1 = null;
		double d1 = 0.0D;

		for (RayTraceResult raytraceresult : list)
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
