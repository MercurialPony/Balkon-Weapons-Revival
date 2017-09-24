package melonslise.weapons.common.item.api;

import melonslise.weapons.Weapons;

public class ItemCategorized extends ItemNamed
{
	public ItemCategorized(String name)
	{
		super(name);
		this.setCreativeTab(Weapons.creativeTab);
	}
}