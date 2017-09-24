package melonslise.weapons.common.item.api.weapon.component;

import com.google.common.collect.Multimap;

import melonslise.weapons.common.item.api.weapon.WeaponMelee;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * A component is what a weapon item consists of in this mod. Components define the item's properties and its behavior
 * Super class for the existing melee and ranged  components.
 */
public abstract class AComponent
{
	private WeaponMelee item; // TODO CHange items/ create baseclass or interface

	public AComponent(WeaponMelee item)
	{
		this.item = item;
		this.setItemProperties();
	}

	public WeaponMelee getItem()
	{
		return this.item;
	}

	/**
	 * Sets some basic properties of the item. Usually properties like stack size, item damage and others.
	 */
	public abstract void setItemProperties();

	// TODO Move to melee?
	/**
	 * Determines the enchantability factor of the item. Usually depends on material.
	 */
	public abstract int getItemEnchantability();

	/**
	 * Applies certain attribute modifiers to the item. Adds them on top of existing ones.
	 */
	public abstract void addAttributeModifiers(Multimap<String, AttributeModifier> modifiers, EntityEquipmentSlot slot, ItemStack stack);

	
	public abstract void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected);
}