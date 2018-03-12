package net.minetrek.mdta.mtcb.objects.items;



import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



/*
 * Class to extend and customise an ItemDoor which works in combination with a Door Block
 */
public class ItemDoorBase extends ItemDoor implements IHasModel
{	
	/**
	 * @param  name String to be used as the registryName and unlocalizedName for an ItemDoor created from this class
	 * @param  tab Sets which CTab or CreativeTab a Door should be grouped into.
	 * @param  blockIn Door Block that should be associated with an ItemDoor.
	 */
	public ItemDoorBase(String name, CreativeTabs tab, Block blockIn)
	{
		super(blockIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);
	}
	
	
	
	
	
	/*
	 * This creates an ItemRenderer for this Door's Model and sets an inventory variant 
	 */
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, References.MOD_DEFAULT_VARIANT);
		Main.logger.info("AWOOGA Added ItemDoor: " + this.getRegistryName().toString());
	}

}
