package net.minetrek.mdta.mtcb.objects.items;



import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;


/*
 * Class to extend and customise an Item
 */
public class ItemBase extends Item implements IHasModel
{
	/**
	 * @param  name String to be used as the registryName and unlocalizedName for an Item created from this class.
	 * @param  tab Sets which CTab or CreativeTab a Door should be grouped into.
	 */
	public ItemBase(String name, CreativeTabs tab)
	{
		super();

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		InitItems.ALL_ITEMS.add(this);
	}
	
	
	
	/*
	 * This creates an ItemRenderer for an Item's Model and sets an inventory variant 
	 */
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, References.MOD_DEFAULT_VARIANT);
		Main.logger.info("AWOOGA Added Item: " + this.getRegistryName().toString());
	}

}
