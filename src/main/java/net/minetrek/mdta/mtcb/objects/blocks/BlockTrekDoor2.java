package net.minetrek.mdta.mtcb.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
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



public class BlockTrekDoor2 extends Block implements IHasModel
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<BlockDoor.EnumHingePosition> HINGE = PropertyEnum.<BlockDoor.EnumHingePosition>create("hinge", BlockDoor.EnumHingePosition.class);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyEnum<BlockDoor.EnumDoorHalf> HALF = PropertyEnum.<BlockDoor.EnumDoorHalf>create("half", BlockDoor.EnumDoorHalf.class);
    
    public static Item itemToDrop;
    
    
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
	public BlockTrekDoor2(String name, Material material, CreativeTabs tab, Item itemDrop)
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
		
		itemToDrop = itemDrop;

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
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    /**
     * Determines if an entity can path through this block
     */
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return isOpen(combineMetadata(worldIn, pos));
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    private int getCloseSound()
    {
        return this.blockMaterial == Material.IRON ? 1011 : 1012;
    }

    private int getOpenSound()
    {
        return this.blockMaterial == Material.IRON ? 1005 : 1006;
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
	
	
	
	public void toggleDoor(World worldIn, BlockPos pos, boolean open)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == this)
        {
            BlockPos blockpos = iblockstate.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
            IBlockState iblockstate1 = pos == blockpos ? iblockstate : worldIn.getBlockState(blockpos);

            if (iblockstate1.getBlock() == this && ((Boolean)iblockstate1.getValue(OPEN)).booleanValue() != open)
            {
                worldIn.setBlockState(blockpos, iblockstate1.withProperty(OPEN, Boolean.valueOf(open)), 10);
                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
                worldIn.playSound(null, pos, HandleSounds.TNG_DOOR, SoundCategory.BLOCKS, 0.5F,
						(worldIn.rand.nextFloat() * 0.1F) + 0.9F);
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
	
	
	
	/**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String getLocalizedName()
    {
        return I18n.translateToLocal((this.getUnlocalizedName() + ".name").replaceAll("tile", "item"));
    }
    
    
    
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : itemToDrop;
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        if (pos.getY() >= worldIn.getHeight() - 1)
        {
            return false;
        }
        else
        {
            IBlockState state = worldIn.getBlockState(pos.down());
            return (state.isTopSolid() || state.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID) && super.canPlaceBlockAt(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos.up());
        }
    }

    public EnumPushReaction getMobilityFlag(IBlockState state)
    {
        return EnumPushReaction.DESTROY;
    }

    public static int combineMetadata(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        int i = iblockstate.getBlock().getMetaFromState(iblockstate);
        boolean flag = isTop(i);
        IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
        int j = iblockstate1.getBlock().getMetaFromState(iblockstate1);
        int k = flag ? j : i;
        IBlockState iblockstate2 = worldIn.getBlockState(pos.up());
        int l = iblockstate2.getBlock().getMetaFromState(iblockstate2);
        int i1 = flag ? i : l;
        boolean flag1 = (i1 & 1) != 0;
        boolean flag2 = (i1 & 2) != 0;
        return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
    }

    public ItemStack getItem()
    {
        return new ItemStack(this.itemToDrop);
    }
    

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually
     * collect this block
     */
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        BlockPos blockpos = pos.down();
        BlockPos blockpos1 = pos.up();

        if (player.capabilities.isCreativeMode && state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER && worldIn.getBlockState(blockpos).getBlock() == this)
        {
            worldIn.setBlockToAir(blockpos);
        }

        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER && worldIn.getBlockState(blockpos1).getBlock() == this)
        {
            if (player.capabilities.isCreativeMode)
            {
                worldIn.setBlockToAir(pos);
            }

            worldIn.setBlockToAir(blockpos1);
        }
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());

            if (iblockstate.getBlock() == this)
            {
                state = state.withProperty(HINGE, iblockstate.getValue(HINGE)).withProperty(POWERED, iblockstate.getValue(POWERED));
            }
        }
        else
        {
            IBlockState iblockstate1 = worldIn.getBlockState(pos.down());

            if (iblockstate1.getBlock() == this)
            {
                state = state.withProperty(FACING, iblockstate1.getValue(FACING)).withProperty(OPEN, iblockstate1.getValue(OPEN));
            }
        }

        return state;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.getValue(HALF) != BlockDoor.EnumDoorHalf.LOWER ? state : state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING))).cycleProperty(HINGE);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(HINGE, (meta & 1) > 0 ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER).withProperty(FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW()).withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
        {
            i = i | 8;

            if (state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT)
            {
                i |= 1;
            }

            if (((Boolean)state.getValue(POWERED)).booleanValue())
            {
                i |= 2;
            }
        }
        else
        {
            i = i | ((EnumFacing)state.getValue(FACING)).rotateY().getHorizontalIndex();

            if (((Boolean)state.getValue(OPEN)).booleanValue())
            {
                i |= 4;
            }
        }

        return i;
    }

    protected static int removeHalfBit(int meta)
    {
        return meta & 7;
    }

    public static boolean isOpen(IBlockAccess worldIn, BlockPos pos)
    {
        return isOpen(combineMetadata(worldIn, pos));
    }

    public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos)
    {
        return getFacing(combineMetadata(worldIn, pos));
    }

    public static EnumFacing getFacing(int combinedMeta)
    {
        return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
    }

    protected static boolean isOpen(int combinedMeta)
    {
        return (combinedMeta & 4) != 0;
    }

    protected static boolean isTop(int meta)
    {
        return (meta & 8) != 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HALF, FACING, OPEN, HINGE, POWERED});
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    public static enum EnumDoorHalf implements IStringSerializable
    {
        UPPER,
        LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
    }

    public static enum EnumHingePosition implements IStringSerializable
    {
        LEFT,
        RIGHT;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == LEFT ? "left" : "right";
        }
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
