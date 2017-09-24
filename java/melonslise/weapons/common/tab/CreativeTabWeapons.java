package melonslise.weapons.common.tab;

import melonslise.weapons.Weapons;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

// TODO REname
// TODO Make universal?
public class CreativeTabWeapons extends CreativeTabs
{
	public CreativeTabWeapons()
	{
		super(Weapons.ID);
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Items.APPLE, 1); // TODO
	}
}