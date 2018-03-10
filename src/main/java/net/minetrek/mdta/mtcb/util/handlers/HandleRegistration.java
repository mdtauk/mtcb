package net.minetrek.mdta.mtcb.util.handlers;



import net.minecraft.block.Block;
import net.minecraft.item.Item;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minetrek.mdta.mtcb.init.InitBlocks;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.util.interfaces.IHasModel;



@EventBusSubscriber
public class HandleRegistration
{
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(InitBlocks.ALL_BLOCKS.toArray(new Block[0]));
	}



	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(InitItems.ALL_ITEMS.toArray(new Item[0]));
	}
	
	
	
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



	public static void preInitRegistration()
	{}



	public static void initRegistration()
	{
		HandleSounds.registerSounds();
	}



	public static void postInitRegistration()
	{}
}
