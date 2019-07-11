package holymod.items.gear.tools.blood_quartz;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBloodSword extends ItemSword {
  public ItemBloodSword(ToolMaterial material) {
    super(material);
  }

  float DAMAGE = 0.5f;

  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
  {
      int hurtSave = target.hurtResistantTime;
      target.hurtResistantTime = 0;
      if (!target.attackEntityFrom(DamageSource.causeMobDamage(attacker).setDamageBypassesArmor(), DAMAGE))
      {
        target.hurtResistantTime = hurtSave;
      }
      target.attackEntityFrom(DamageSource.causeMobDamage(attacker).setDamageBypassesArmor(), DAMAGE);
    return super.hitEntity(stack, target, attacker);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
  {
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blood_sword_tooltip"));
  }
}