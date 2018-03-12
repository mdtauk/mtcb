package net.minetrek.mdta.mtcb.proxies;



import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minetrek.mdta.mtcb.util.handlers.HandleRegistration;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;



/*
 * Server and Client Mod code
 */
public class CommonProxy
{
	/* 
	 *	Register custom renderers and ModelResourceLocations for Items. 
	 */
	public void registerItemRenderer(Item item, int meta, String id)
	{}



	/* 
	 *	Register custom renderers and ModelResourceLocations for Items which include variations. 
	 */
	public void registerVariantRenderer(Item item, int meta, String filename, String id)
	{}
	
	
	
	/*
	 *	Events to run before the Mod Initialises
	 */
	public void preInit(FMLPreInitializationEvent event)
	{}



	/*
	 *	Events to run during Initialisation
	 */
	public void init(FMLInitializationEvent event)
	{}



	/*
	 *	Events to run after the Mod has Initialised
	 */
	public void postInit(FMLPostInitializationEvent event)
	{}
}
