package net.minetrek.mdta.mtcb.util.handlers;



import net.minecraft.block.Block;
import net.minecraft.item.Item;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;


/*
 * We subscribe to the Forge EventBus and run code as Blocks and Items are registered by Forge
 */
@EventBusSubscriber
public class HandleRegistration
{
	/*
	 *  Subscribe to the Event as Blocks are registered
	 */
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(InitBlocks.ALL_BLOCKS.toArray(new Block[0]));
	}



	/*
	 *  Subscribe to the Event as Items are registered
	 */
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(InitItems.ALL_ITEMS.toArray(new Item[0]));
	}
	
	
	
	/*
	 *  Subscribe to the Event as Block and Item Models are registered
	 */
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Block block : InitBlocks.ALL_BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
		
		
		for(Item item : InitItems.ALL_ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
	}



	/*
	 *  Code to be done before you Initialise Registration of objects
	 */
	public static void preInitRegistration()
	{}



	/*
	 *  Code to be done while Initialising Registration of objects
	 */
	public static void initRegistration()
	{
		HandleSounds.registerSounds();
	}



	/*
	 *  Code to be done after Initialising Registration of objects
	 */
	public static void postInitRegistration()
	{}
}
