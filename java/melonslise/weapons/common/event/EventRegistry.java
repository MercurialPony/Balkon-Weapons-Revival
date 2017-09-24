package melonslise.weapons.common.event;

import melonslise.weapons.common.item.ItemList;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// TODO Rename?
@Mod.EventBusSubscriber
public class EventRegistry
{
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		ItemList.register(event);
	}
}