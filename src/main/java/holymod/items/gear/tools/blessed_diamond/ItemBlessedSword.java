package holymod.items.gear.tools.blessed_diamond;


import holymod.network.PacketHandler;
import holymod.network.message.MessageHolyFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemBlessedSword extends ItemSword {
  public ItemBlessedSword(ToolMaterial material) {
    super(material);
  }

    private Random random;
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
  {
      random = new Random();
      if (Math.random() < 0.2)
      {
          for (int k = 0; k < 4; k++)
          {
              double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
              double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
              double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
              PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(attacker.posX, attacker.posY + attacker.height / 2, attacker.posZ, 0.04f * (float) RandomZ, 0.4f * (float) RandomY, 0.04f * (float) RandomX));
          }
          attacker.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 1));
      }

    return super.hitEntity(stack, target, attacker);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
  {
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blessed_sword_tooltip"));
  }
}