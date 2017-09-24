package melonslise.weapons.common.item.api.weapon;

import java.util.UUID;

import com.google.common.collect.Multimap;

import melonslise.weapons.common.item.api.ItemCategorized;
import melonslise.weapons.common.item.api.weapon.component.AComponentMelee;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Is an item class that implements the features defined by the melee component.
 */
public class WeaponMelee extends ItemCategorized
{
	// TODO SPAWN SWIPE PARTICLE

	private AComponentMelee componentMelee; // Getters/in super class?

	private ToolMaterial material;

	// TODO NULL MATERIAL CHECKS
	// TODO Categorize methods?

	public WeaponMelee(String name, ToolMaterial material, AComponentMelee componentMelee)
	{
		super(name);
		this.componentMelee = componentMelee;
		this.material = material;
	}

	public ToolMaterial getMaterial()
	{
		return this.material;
	}



	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer entityPlayer, Entity entity)
	{
		return this.componentMelee.onLeftClickEntity(stack, entityPlayer, entity);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entityTarget, EntityLivingBase entityAttacker)
	{
		return this.componentMelee.hitEntity(stack, entityTarget, entityAttacker);
	}



	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		return this.componentMelee.getBlockDamage(stack, state);
	}

	@Override
	public boolean canHarvestBlock(IBlockState state)
	{
		return this.componentMelee.canHarvestBlock(state);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos position, EntityLivingBase entity)
	{
		return this.componentMelee.onBlockDestroyed(stack, world, state, position, entity);
	}



	@Override
	public int getItemEnchantability()
	{
		return this.componentMelee.getItemEnchantability();
	}



	// TODO
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
		this.componentMelee.addAttributeModifiers(modifiers, slot, stack);
		return modifiers;
	}

	// TODO RENAME? MOVE?
	public UUID getAttackDamageModifierUUID()
	{
		return this.ATTACK_DAMAGE_MODIFIER;
	}

	public UUID getAttackSpeedModifierUUID()
	{
		return this.ATTACK_SPEED_MODIFIER;
	}



	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
	{
		this.componentMelee.onUpdate(stack, world, entity, slot, isSelected);
	}



/*
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		ItemStack mat = this.material.getRepairItemStack();
		if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
		return super.getIsRepairable(toRepair, repair);
	}
*/
}