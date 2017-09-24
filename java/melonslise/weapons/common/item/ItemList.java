package melonslise.weapons.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

// Rename?
public class ItemList
{
	public static Item basic;

	public static void register(RegistryEvent.Register<Item> event)
	{

		event.getRegistry().registerAll(basic);
	}

	// TODO Client
	public static void registerModels(ModelRegistryEvent event)
	{
		
	}
}