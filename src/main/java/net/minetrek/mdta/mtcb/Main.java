package net.minetrek.mdta.mtcb;



import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minetrek.mdta.mtcb.init.InitItems;
import net.minetrek.mdta.mtcb.objects.tabs.CTab;
import net.minetrek.mdta.mtcb.proxies.CommonProxy;
import net.minetrek.mdta.mtcb.util.References;



/*
 * Lets Forge know that this is a Mod.
 * 
 * You provide it with the Mod's ID, Name, Versions, and Minecraft Version it is
 * designed for
 */
@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION, acceptedMinecraftVersions = References.MOD_MC_VERSION)
public class Main
{
	/*
	 * We set up proxies to separate code that works for server and client code.
	 * We use a common class for most things and separate client only code like
	 * rendering
	 * into an extended class.
	 */
	@SidedProxy(clientSide = References.MOD_CLIENT_PROXY, serverSide = References.MOD_COMMON_PROXY)
	public static CommonProxy proxy;


	/*
	 * This creates the mod instance by telling Forge it should run the Main class.
	 */
	@Mod.Instance
	public static Main instance;


	/**
	 * TODO: Shorten the labels for the tabs to better fit the space
	 */
	// Create instances of our Creative Tabs
	public static final CreativeTabs TAB_ENT = new CTab("tab_ent", Items.IRON_HOE, "entbg.png", false);
	public static final CreativeTabs TAB_DSC = new CTab("tab_dsc", Items.IRON_AXE, "dscbg.png", false);
	public static final CreativeTabs TAB_TOS = new CTab("tab_tos", Items.DIAMOND_HOE, "tosbg.png", false);
	public static final CreativeTabs TAB_MOVIE = new CTab("tab_movie", Items.DIAMOND_SHOVEL, "moviesbg.png", false);
	public static final CreativeTabs TAB_TNG = new CTab("tab_tng", InitItems.ITEM_TNG_ICON, "tngbg.png", true);
	public static final CreativeTabs TAB_DS9 = new CTab("tab_ds9", Items.DIAMOND_AXE, "ds9bg.png", false);
	public static final CreativeTabs TAB_VOY = new CTab("tab_voy", Items.DIAMOND_PICKAXE, "voybg.png", false);
	public static final CreativeTabs TAB_JJ = new CTab("tab_jj", Items.BUCKET, "jjbg.png", false);
	public static final CreativeTabs TAB_TNGMOVIE = new CTab("tab_tngmovie", Items.APPLE, "tngmoviebg.png", false);
	public static final CreativeTabs TAB_MISC = new CTab("tab_misc", Items.MELON, "miscbg.png", false);
	/**/



	/*
	 * Creates a Logger for the project, and names it logger.
	 * 
	 * You call to it with Main.logger to send output to the console.
	 */
	public static Logger logger;



	/*
	 * Pre Init is the place to let the game know about all the blocks, items, etc
	 * that your mod provides.
	 * 
	 * Registering blocks and items to the GameRegistry
	 * Registering tile entities
	 * Registering entities
	 * Assigning ore dictionary names
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		proxy.preInit(event);
		
		Main.logger.debug("AWOOGA - Main.preInit: OBJLoader will now add the domain " + References.MOD_ID + ":");
		OBJLoader.INSTANCE.addDomain(References.MOD_ID.toLowerCase());
	}



	/*
	 * Init is where to accomplish any game related tasks that rely upon the items
	 * and blocks set up in preInit.
	 * 
	 * Registering world generators
	 * Registering recipes
	 * Registering event handlers
	 * Sending IMC messages
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}



	/*
	 * Post Init is where your mod usually does things which rely upon or are relied
	 * upon by other mods.
	 * 
	 * Mod compatibility, or anything which depends on other mods� init phases being
	 * finished.
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}
