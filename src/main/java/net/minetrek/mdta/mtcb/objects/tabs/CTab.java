package net.minetrek.mdta.mtcb.objects.tabs;



import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



/*
 * Class to extend and customise the Creative Mode Inventory Tab
 */
public class CTab extends CreativeTabs
{

	private Item _item;
	private boolean _canSearch = false;
	
	
	/**
	 * @param  label String to set the text to be displayed on the CTab screen
	 * @param  item Specify the Item from which the CTab's Icon will be taken from
	 * @param  background String of the filename.png for the image used for the CTab inventory GUI. These files must be placed in the assets.minecraft.textures.gui.container.creative_inventory package
	 * @param  canSearch Boolean to set if the CTab should display a search box 
	 */
	public CTab(String label, Item item, String background, boolean canSearch)
	{
		super(label);
		
		this.setBackgroundImageName(background);
		
		_item = item;
		
		_canSearch = canSearch;
		
	}
	
	
	
	/*
	 * Get an ItemStack from the Item provided
	 */
	public ItemStack getTabIconItem()
	{
		return new ItemStack(_item);
	}
	
	
	
	/*
	 * Sets the hasSearchBar property for a CTab
	 */
	@Override
	public boolean hasSearchBar() {
		return _canSearch;
	}

}
