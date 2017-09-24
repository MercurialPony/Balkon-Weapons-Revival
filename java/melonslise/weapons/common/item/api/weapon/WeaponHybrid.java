package melonslise.weapons.common.item.api.weapon;

import com.google.common.collect.Multimap;

import melonslise.weapons.common.item.api.weapon.component.AComponentMelee;
import melonslise.weapons.common.item.api.weapon.component.AComponentRanged;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

// TODO Rename to combined?
/**
 * Is an item that implements the features defined by the ranged component.
 * However a melee component is still required since an item's melee interactions can't go undefined (even if it's supposed to act like a basic item).
 */
public class WeaponHybrid extends WeaponMelee
{
	private AComponentRanged componentRanged; // TODO Getter

	public WeaponHybrid(String name, ToolMaterial material, AComponentMelee componentMelee, AComponentRanged componentRanged)
	{
		super(name, material, componentMelee);
		this.componentRanged = componentRanged;
	}

	// TODO Sort methods

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		return this.componentRanged.onItemRightClick(world, player, hand);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return this.componentRanged.getItemUseAction(stack);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return this.componentRanged.getMaxItemUseDuration(stack);
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase entity, int count)
	{
		this.componentRanged.onUsingTick(stack, entity, count);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft)
	{
		this.componentRanged.onPlayerStoppedUsing(stack, world, entity, timeLeft);
	}

	// TODO
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
		this.componentRanged.addAttributeModifiers(modifiers, slot, stack);
		return modifiers;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
	{
		super.onUpdate(stack, world, entity, slot, isSelected);
		this.componentRanged.onUpdate(stack, world, entity, slot, isSelected);
	}
}