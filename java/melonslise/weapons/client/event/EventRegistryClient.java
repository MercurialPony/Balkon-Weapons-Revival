package melonslise.weapons.client.event;

import melonslise.weapons.common.item.ItemList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

//TODO Rename?
@Mod.EventBusSubscriber(Side.CLIENT)
public class EventRegistryClient
{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		ItemList.registerModels(event);
	}
}