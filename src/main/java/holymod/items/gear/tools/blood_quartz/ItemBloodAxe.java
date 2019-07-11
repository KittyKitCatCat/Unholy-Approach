package holymod.items.gear.tools.blood_quartz;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemBloodAxe extends ItemAxe {

  public ItemBloodAxe(Item.ToolMaterial materialIn, float damage, float attackSpeed) {
    super(materialIn, damage, attackSpeed);
  }
  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
  {
    float FullHealth = attacker.getMaxHealth();
    float Health = attacker.getHealth();
    if (Health == FullHealth)
    {
      target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 30, 1));
      target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 30, 1));
    }
    return super.hitEntity(stack, target, attacker);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced){
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blood_axe_tooltip"));
  }
  public ItemBloodAxe(Item.ToolMaterial materialIn) {
    this(materialIn, 8, -3);
  }

}


