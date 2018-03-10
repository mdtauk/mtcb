package net.minetrek.mdta.mtcb.proxies;



import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.handlers.HandleRegistration;



public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));		
	}
	
	
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(References.MOD_ID, filename), id));
	}
	
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{}


	
	@Override
	public void init(FMLInitializationEvent event)
	{
		HandleRegistration.initRegistration();
	}


	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{}
}
