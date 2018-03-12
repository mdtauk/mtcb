package net.minetrek.mdta.mtcb.util.handlers;



import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minetrek.mdta.mtcb.util.References;



public class HandleSounds
{
	/*
	 * Define SoundEvents which will be instantiated below
	 */
	public static SoundEvent TNG_DOOR;
	public static SoundEvent TNG_DOOR_PLACE;
	
	public static SoundType TNG_DOOR_TYPE;
	
	
	
	/*
	 * A method to instantiate SoundEvents which are to be registered
	 */
	public static void registerSounds()
	{
		TNG_DOOR = registerSound("sound_tng_door");
		TNG_DOOR_PLACE = registerSound("sound_tng_door_place");
		
		TNG_DOOR_TYPE = new SoundType(1.0F, 1.0F, TNG_DOOR_PLACE, TNG_DOOR_PLACE, TNG_DOOR_PLACE, TNG_DOOR_PLACE, TNG_DOOR_PLACE);
	}
	
	
	
	/*
	 * An event to register instantiated SoundEvents within the Forge Registries
	 */
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(References.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		//ForgeRegistries.SOUND_TYPES.register(event);
		return event;
	}
}