package net.minetrek.mdta.mtcb.objects.items;



import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name, CreativeTabs tab)
	{
		super();

		setUnlocalizedName(name);
		setRegistryName(name);

		setCreativeTab(tab);

		InitItems.ALL_ITEMS.add(this);
	}
	
	
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
