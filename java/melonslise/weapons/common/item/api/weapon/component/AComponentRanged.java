package melonslise.weapons.common.item.api.weapon.component;

import melonslise.weapons.common.item.api.weapon.WeaponMelee;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Defines the item's interactions in ranged combat. Interactions like spawning projectile entities, or damaging entities at a range and their properties are defined by this component.
 * Basically defines the item's "right-clicking" features.
 */
public abstract class AComponentRanged extends AComponent
{
	public AComponentRanged(WeaponMelee item)
	{
		super(item);
	}

	/**
	 * Defines what the item does when used (otherwise right-clicked) and returns the result of the action.
	 */
	public abstract ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand);

	public abstract EnumAction getItemUseAction(ItemStack stack);

	// TODO Rename time
	public abstract int getMaxItemUseDuration(ItemStack stack);

	public abstract void onUsingTick(ItemStack stack, EntityLivingBase entity, int count);

	public abstract void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft);
}