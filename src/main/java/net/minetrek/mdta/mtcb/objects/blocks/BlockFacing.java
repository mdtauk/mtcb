package net.minetrek.mdta.mtcb.objects.blocks;



import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class BlockFacing extends BlockHorizontal implements IHasModel
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	
	// Basic constructor variant
	/**
	 * 
	 * @param name  Sets the Unlocalised and Registry name for the BlockFacing Block
	 * 
	 * @param material  Sets the Material type the block should inherit from
	 * 
	 * @param tab  Sets which Creative Tab the block should be grouped into for the Creative Mode Inventory
	 */
	public BlockFacing(String name, Material material, CreativeTabs tab)
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
	 * @param name  Sets the Unlocalised and Registry name for the BlockFacing Block
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
	public BlockFacing(String name, Material material, CreativeTabs tab, float lightLevel, int lightOpacity, SoundType sound)
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
		
		
		
	// Full constructor variant
	/**
	 * 
	 * @param name  Sets the Unlocalised and Registry name for the BlockFacing Block
	 * 
	 * @param material  Sets the Material type the block should inherit from
	 * 
	 * @param tab  Sets which Creative Tab the block should be grouped into for the Creative Mode Inventory
	 * 
	 * @param lightLevel  Sets the lightLevel emitted by the block - float value between 0-1f (n/16)
	 * 
	 * @param lightOpacity  Sets the lightOpacity value, to prevent light passing through - int value
	 *  
	 * @param resistance  Sets the resistance value, as in resistance to explosion
	 * 
	 * @param sound  Sets the type of sounds this block makes
	 * 
	 * @param hardness  Sets the value of how long it takes to break the block
	 */
	public BlockFacing(String name, Material material, CreativeTabs tab, float lightLevel, int lightOpacity, float resistance, SoundType sound, float hardness)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(tab);	
		
		setLightLevel(lightLevel);
		setLightOpacity(lightOpacity);
		setResistance(resistance);
		setSoundType(sound);
		setHardness(hardness);
		
		InitBlocks.ALL_BLOCKS.add(this);
		InitItems.ALL_ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
		return state.withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
	}
	
	
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta % 4));
	}

	
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}



	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	
	
	

}
