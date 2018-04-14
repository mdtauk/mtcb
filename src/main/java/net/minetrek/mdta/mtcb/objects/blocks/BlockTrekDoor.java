package net.minetrek.mdta.mtcb.objects.blocks;



import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.objects.items.ItemDoorBase;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;


/**
 * 
 * @author mdta
 *
 *  TODO
 *	BlockTrekDoors are not dropping items and are not responding to middle mouse button clicks.  
 *  Not sure how to make them work, so we will gave to come back to it when I can get some more experience, and examples.
 *
 */
/*
 * Class to extend and customise a BlockDoor
 */
public class BlockTrekDoor extends BlockDoor implements IHasModel
{
	/*
	 * MDTA I have created my own bounding boxes to match my custom models and states
	 */
	
	//
	// 1st Point X1, Y1, Z1 - 2nd Point X2, Y2, Z2
    //
    // Co-ordinate values are relative to the standard block | from 0,0,0 to 1,1,1
	//
	// X = Horizontal    
    // Y = Vertical    
    // Z = Depth
	//
    
    // We divide 1 / 16 to help position our bounding box co-ordinates
	private static double _unit = 1.0D / 16.0D;
	
	// We divide 1 / 32 to help position our bounding box co-ordinates
	private static double _halfUnit = _unit / 2.0D;
	
	
	// BoundingBox co-ordinates when a Trek Door is closed facing North or South
	protected static final AxisAlignedBB NORTH_SOUTH_AABB = new AxisAlignedBB(
			0.0D, 0.0D, (_unit * 7) - _halfUnit, 
			1.0D, 1.0D, (_unit * 9) + _halfUnit);
	
	// BoundingBox co-ordinates when a Trek Door is open with a Left Hinge
	protected static final AxisAlignedBB NORTH_SOUTH_LEFT_AABB = new AxisAlignedBB(
			(_unit * 14), 0.0D, (_unit * 3) - _halfUnit,
			1.0D, 1.0D, (_unit * 13) + _halfUnit);
	
	// BoundingBox co-ordinates when a Trek Door is open with a Right hinge
	protected static final AxisAlignedBB NORTH_SOUTH_RIGHT_AABB = new AxisAlignedBB(
			0.0D, 0.0D, (_unit * 3) - _halfUnit,
			(_unit * 2), 1.0D, (_unit * 13) + _halfUnit);
	
	
	
	// BoundingBox co-ordinates when a Trek Door is closed facing East or West
	protected static final AxisAlignedBB EAST_WEST_AABB = new AxisAlignedBB(
			(_unit * 7) - _halfUnit, 0.0D, 0.0D, 
			(_unit * 9) + _halfUnit, 1.0D, 1.0D);
	
	// BoundingBox co-ordinates when a Trek Door is open with a Left Hinge
	protected static final AxisAlignedBB EAST_WEST_LEFT_AABB = new AxisAlignedBB(
			(_unit * 3) - _halfUnit, 0.0D, (_unit * 14), 
			(_unit * 13) + _halfUnit, 1.0D, 1.0D);
	
	// BoundingBox co-ordinates when a Trek Door is open with a Right Hinge
	protected static final AxisAlignedBB EAST_WEST_RIGHT_AABB = new AxisAlignedBB(
			(_unit * 3), 0.0D, 0.0D, 
			(_unit * 13), 1.0D, (_halfUnit * 2));


	
	/**
	 * @param  name String to be used as the registryName and unlocalizedName for a BlockTrekDoor created from this class.
	 * @param  material Material to be used as a default (for Doors don't use IRON unless you require the door to only open with redstone)
	 * @param  tab Sets which CTab or CreativeTab a Door should be grouped into.
	 */
	public BlockTrekDoor(String name, Material material, CreativeTabs tab)
	{
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH)
				.withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.RIGHT)
				.withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));


		
		// Add this to the List of ALL_BLOCKS which are to be registered
		InitBlocks.ALL_BLOCKS.add(this);
		
		// Add an ItemDoorBase to the List of ALL_ITEMS which are to be registered
		InitItems.ALL_ITEMS.add(new ItemDoorBase(name, tab, this));

		this.useNeighborBrightness = true;
	}



	/*
	 * Code taken from the standard BlockDoor to set the AxisAlignedBoundingBox for the Door Blocks based on:
	 * - Direction the Door faces;
	 * - Whether the Door is open or closed;
	 * - If the Door is hinged left or right;
	 * 
	 * MDTA I have created my own bounding boxes to match my custom models
	 * @see net.minecraft.block.BlockDoor#getBoundingBox(net.minecraft.block.state.IBlockState, net.minecraft.world.IBlockAccess, net.minecraft.util.math.BlockPos)
	 */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		state = state.getActualState(source, pos);
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		boolean isOpen = !((Boolean) state.getValue(OPEN)).booleanValue();
		boolean isHingeRight = state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT;

		switch (enumfacing)
		{
		case EAST:
		default:
			return isOpen ? EAST_WEST_AABB : (isHingeRight ? EAST_WEST_LEFT_AABB : EAST_WEST_RIGHT_AABB);
		case SOUTH:
			return isOpen ? NORTH_SOUTH_AABB : (isHingeRight ? NORTH_SOUTH_RIGHT_AABB : NORTH_SOUTH_LEFT_AABB);
		case WEST:
			return isOpen ? EAST_WEST_AABB : (isHingeRight ? EAST_WEST_RIGHT_AABB : EAST_WEST_LEFT_AABB);
		case NORTH:
			return isOpen ? NORTH_SOUTH_AABB : (isHingeRight ? NORTH_SOUTH_LEFT_AABB : NORTH_SOUTH_RIGHT_AABB);
		}
	}
	
	
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : this.getItem();
    }



	/*
	 * Code taken from the standard BlockDoor to affect the Door when the player right clicks on the Door Blocks
	 * @see net.minecraft.block.BlockDoor#onBlockActivated(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (this.blockMaterial == Material.IRON)
		{
			return false;
		}
		else
		{
			BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
			IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this)
			{
				return false;
			}
			else
			{
				Minecraft mc = Minecraft.getMinecraft();
				state = iblockstate.cycleProperty(OPEN);
				worldIn.setBlockState(blockpos, state, 10);
				worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
				/*
				 * MDTA: I changed the code which plays a sound, so it will play a custom SoundEvent
				 */
				worldIn.playSound(null, pos, HandleSounds.TNG_DOOR, SoundCategory.BLOCKS, 0.5F,
						(worldIn.rand.nextFloat() * 0.1F) + 0.9F);
				return true;
			}
		}
	}


	/*
	 * Code taken from the standard BlockDoor to affect the Door when blocks around it change
	 * @see net.minecraft.block.BlockDoor#neighborChanged(net.minecraft.block.state.IBlockState, net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.Block, net.minecraft.util.math.BlockPos)
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
		{
			BlockPos blockpos = pos.down();
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this)
			{
				worldIn.setBlockToAir(pos);
			}
			else if (blockIn != this)
			{
				iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
			}
		}
		else
		{
			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

			if (iblockstate1.getBlock() != this)
			{
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP))
			{
				worldIn.setBlockToAir(pos);
				flag1 = true;

				if (iblockstate1.getBlock() == this)
				{
					worldIn.setBlockToAir(blockpos1);
				}
			}

			if (flag1)
			{
				if (!worldIn.isRemote)
				{
					this.dropBlockAsItem(worldIn, pos, state, 0);
				}
			}
			else
			{
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower())
						&& flag != ((Boolean) iblockstate1.getValue(POWERED)).booleanValue())
				{
					worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

					if (flag != ((Boolean) state.getValue(OPEN)).booleanValue())
					{
						worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
						worldIn.markBlockRangeForRenderUpdate(pos, pos);
						/*
						 * MDTA: I changed the code which plays a sound, so it will play a custom SoundEvent
						 */
						worldIn.playSound(null, pos, HandleSounds.TNG_DOOR, SoundCategory.BLOCKS, 0.5F,
								(worldIn.rand.nextFloat() * 0.1F) + 0.9F);
					}
				}
			}
		}
	}



	/*
	 * Create an ItemStack for an Item for a BlockTrekDoor
	 */
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this.getItem());
	}



	/*
	 * Get the Item that should be created for a BlockTrekDoor
	 */
	private Item getItem()
	{
		return Item.getItemFromBlock(this);
	}


	/*
	 * This creates an ItemRenderer for an Item derived from a BlockTrekDoor Block and sets an inventory variant 
	 */
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, References.MOD_DEFAULT_VARIANT);
		Main.logger.info("AWOOGA Added Item from Block: " + this.getRegistryName().toString());
	}

}
