package net.minetrek.mdta.mtcb.proxies;



import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.util.References;
import net.minetrek.mdta.mtcb.util.handlers.HandleRegistration;


/*
 *  Client only Mod Code, extends the Client and Server code
 */
public class ClientProxy extends CommonProxy
{
	/* 
	 *	Register custom renderers and ModelResourceLocations for Items. 
	 */
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{	
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));		
	}
	
	
	
	/* 
	 *	Register custom renderers and ModelResourceLocations for Items which include variations. 
	 */
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(References.MOD_ID, filename), id));
	}
	
	
	
	/*
	 *	Events to run before the Mod Initialises
	 */
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		Main.logger.debug("AWOOGA - ClientProxy: OBJLoader will now add the domain " + References.MOD_ID + ":");
		OBJLoader.INSTANCE.addDomain(References.MOD_ID);
	}


	
	/*
	 *	Events to run during Initialisation
	 */
	@Override
	public void init(FMLInitializationEvent event)
	{
		HandleRegistration.initRegistration();
	}


	
	/*
	 *	Events to run after the Mod has Initialised
	 */
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{}
}
