package melonslise.weapons.common.item.api;

import net.minecraft.item.Item;

// TODO Rename Entry?
public class ItemNamed extends Item
{
	public ItemNamed(String name)
	{
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}