package holymod.items.gear.tools.blessed_diamond;


import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlessedAxe extends ItemAxe {

  public ItemBlessedAxe(Item.ToolMaterial materialIn, float damage, float attackSpeed) {
    super(materialIn, damage, attackSpeed);
  }
  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
  {
    if (attacker.isSprinting())
    {
      attacker.heal(1f);
    }
    return super.hitEntity(stack, target, attacker);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced){
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blessed_axe_tooltip"));
  }
  public ItemBlessedAxe(Item.ToolMaterial materialIn) {
    this(materialIn, 8, -3);
  }

}


