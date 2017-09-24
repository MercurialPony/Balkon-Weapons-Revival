package melonslise.weapons.common.attribute;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

// TODO Not sure where this belongs?
public class AttributeList
{
	// TODO Unlocalized name consts
	public static final IAttribute ATTACK_SPEED = new RangedAttribute(null, "attackSpeed", 0D, Double.MIN_VALUE, Double.MAX_VALUE);
	public static final IAttribute IGNORE_ARMOR = new RangedAttribute(null, "ignoreArmor", 0D, 0D, Double.MAX_VALUE);
	public static final IAttribute KNOCKBACK = new RangedAttribute(null, "knockback", 0.4D, 0D, Double.MAX_VALUE);
	public static final IAttribute REACH = new RangedAttribute(null, "reach", 0D, 0D, Double.MAX_VALUE);

	public static final UUID ATTACK_SPEED_MODIFIER = UUID.fromString("b207ebfd-105d-47bc-bd6e-040bbb463460");
	public static final UUID IGNORE_ARMOR_MODIFIER = UUID.fromString("3010ada5-6a7b-4d1c-ac1b-f54d2b6b3521");
	public static final UUID KNOCKBACK_MODIFIER = UUID.fromString("5ff5c256-fedb-4553-ab78-8758ebb36b7a");
	public static final UUID REACH_MODIFIER = UUID.fromString("465c79cf-d8c1-4b32-b7df-5584279a4ba8");
}