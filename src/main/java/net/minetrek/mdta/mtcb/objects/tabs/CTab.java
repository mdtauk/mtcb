package net.minetrek.mdta.mtcb.objects.tabs;



import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class CTab extends CreativeTabs
{

	private Item _item;
	
	
	
	public CTab(String label, Item item, String background)
	{
		super(label);
		
		this.setBackgroundImageName(background);
		
		_item = item;
		
	}
	
	

	public ItemStack getTabIconItem()
	{
		return new ItemStack(_item);
	}
	
	
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
