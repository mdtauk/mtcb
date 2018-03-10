package net.minetrek.mdta.mtcb.proxies;



import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minetrek.mdta.mtcb.util.handlers.HandleRegistration;
import net.minetrek.mdta.mtcb.util.handlers.HandleSounds;



public class CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{}



	public void preInit(FMLPreInitializationEvent event)
	{}



	public void init(FMLInitializationEvent event)
	{}



	public void postInit(FMLPostInitializationEvent event)
	{}



	public void registerVariantRenderer(Item item, int meta, String filename, String id)
	{}



}
