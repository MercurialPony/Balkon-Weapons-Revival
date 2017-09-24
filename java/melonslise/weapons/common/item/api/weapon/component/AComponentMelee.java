package melonslise.weapons.common.item.api.weapon.component;

import com.google.common.collect.Multimap;

import melonslise.weapons.common.item.api.weapon.WeaponMelee;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Defines the item's interactions in melee combat. Interactions like hitting entities, blocks and their properties are defined by this component.
 * Basically defines the item's "left-clicking" features.
 */
public abstract class AComponentMelee extends AComponent
{
	public AComponentMelee(WeaponMelee item)
	{
		super(item);
	}



	// TODO Body
	/**
	 * Returns the amount of damage done by the item. Is used when creating the attack damage attribute modifier.
	 * Return 0 for the item to have default damage.
	 */
	public abstract float getEntityDamage();

	// TODO PARAMS?
	public abstract int getAttackDelay(ItemStack stack, EntityLivingBase entityTarget, EntityLivingBase entityAttacker);

	// TODO PARAMS?
	public abstract float getKnockBack(ItemStack stack, EntityLivingBase entityTarget, EntityLivingBase entityAttacker);

	/**
	 * Defines what happens when a player is about to hit an entity with the item.
	 * @return false if the damage should be applied and true if the damage shouldn't be applied.
	 */
	public abstract boolean onLeftClickEntity(ItemStack stack, EntityPlayer entityPlayer, Entity entity);



	/**
	 * Returns the amount of damage done to the hit block.
	 */
	public abstract float getBlockDamage(ItemStack stack, IBlockState state);

	/**
	 * Determines if the hit block is harvestable by the item.
	 */
	public abstract boolean canHarvestBlock(IBlockState state);

	/**
	 * Defines what happens when a block is destroyed with the item.
	 * @return true if the "Use Item" statistic should be triggered.
	 */
	public abstract boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos position, EntityLivingBase entity);



	/**
	 * Defines what happens when a player hits an entity with the item. Usually used only to decrease the item damage.
	 */
	public abstract boolean hitEntity(ItemStack stack, EntityLivingBase entityTarget, EntityLivingBase entityAttacker);



	/**
	 * Adds certain attribute modifiers that are specific to melee combat to the item.
	 */
	@Override
	public void addAttributeModifiers(Multimap<String, AttributeModifier> modifiers, EntityEquipmentSlot slot, ItemStack stack)
	{
		if(slot.equals(EntityEquipmentSlot.MAINHAND))
		{
			if(this.getEntityDamage() > 0)
			{
				modifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(this.getItem().getAttackDamageModifierUUID(), "Weapon modifier", this.getEntityDamage(), 0));
			}
		}
	}
}