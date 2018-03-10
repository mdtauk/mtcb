package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.objects.items.ItemDoorBase;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockTrekDoor extends BlockDoor implements IHasModel
{
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
	
	// 1st Point X1, Y1, Z1 - 2nd Point X2, Y2, Z2
	//
	// Values are Decimal so 16 / 1 | 1/16 = 0.0625D
	//
	// /|
	//			X __    Y |    Z /
	// |/_
	//
	private static double oneSixteenth = 0.0625D;
	private static double oneThirtyTwo = 0.03125D;

	protected static final AxisAlignedBB NORTH_SOUTH_AABB = new AxisAlignedBB(
			0.0D, 0.0D, (oneSixteenth * 7) - oneThirtyTwo, 
			1.0D, 1.0D, (oneSixteenth * 9) + oneThirtyTwo);
	
	protected static final AxisAlignedBB NORTH_SOUTH_LEFT_AABB = new AxisAlignedBB(
			(oneSixteenth * 14), 0.0D, (oneSixteenth * 3) - oneThirtyTwo,
			1.0D, 1.0D, (oneSixteenth * 13) + oneThirtyTwo);
	
	protected static final AxisAlignedBB NORTH_SOUTH_RIGHT_AABB = new AxisAlignedBB(
			0.0D, 0.0D, (oneSixteenth * 3) - oneThirtyTwo,
			(oneSixteenth * 2), 1.0D, (oneSixteenth * 13) + oneThirtyTwo);
	
	protected static final AxisAlignedBB EAST_WEST_AABB = new AxisAlignedBB(
			(oneSixteenth * 7) - oneThirtyTwo, 0.0D, 0.0D, 
			(oneSixteenth * 9) + oneThirtyTwo, 1.0D, 1.0D);
	
	protected static final AxisAlignedBB EAST_WEST_LEFT_AABB = new AxisAlignedBB(
			(oneSixteenth * 3) - oneThirtyTwo, 0.0D, (oneSixteenth * 14), 
			(oneSixteenth * 13) + oneThirtyTwo, 1.0D, 1.0D);
	
	protected static final AxisAlignedBB EAST_WEST_RIGHT_AABB = new AxisAlignedBB(
			(oneSixteenth * 3), 0.0D, 0.0D, 
			(oneSixteenth * 13), 1.0D, (oneSixteenth * 2));



	public BlockTrekDoor(String name, Material material, CreativeTabs tab)
	{
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH)
				.withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.RIGHT)
				.withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));



		InitBlocks.ALL_BLOCKS.add(this);
		InitItems.ALL_ITEMS.add(new ItemDoorBase(name, tab, this));

		this.useNeighborBrightness = true;
	}



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
				worldIn.playSound(null, pos, HandleSounds.TNG_DOOR, SoundCategory.BLOCKS, 0.5F,
						(worldIn.rand.nextFloat() * 0.1F) + 0.9F);
				return true;
			}
		}
	}



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
						worldIn.playSound(null, pos, HandleSounds.TNG_DOOR, SoundCategory.BLOCKS, 0.5F,
								(worldIn.rand.nextFloat() * 0.1F) + 0.9F);
					}
				}
			}
		}
	}



	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this.getItem());
	}



	private Item getItem()
	{
		return Item.getItemFromBlock(this);
	}



	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
