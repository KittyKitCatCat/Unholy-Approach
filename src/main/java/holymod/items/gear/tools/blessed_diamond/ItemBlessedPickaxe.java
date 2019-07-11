package holymod.items.gear.tools.blessed_diamond;


import holymod.network.PacketHandler;
import holymod.network.message.MessageHolyFX;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemBlessedPickaxe extends ItemPickaxe
{
  public ItemBlessedPickaxe(ToolMaterial material)
  {
    super(material);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
  {
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blessed_pickaxe_tooltip"));
  }
  public static Random random = new Random();
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState iBlockState, BlockPos pos, EntityLivingBase playerIn)
  {
    random = new Random();
    if (Math.random() < 0.2)
    {
      for (int k = 0; k < 4; k++)
      {
        double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
        double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
        double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
        PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(pos.getX(), pos.getY(), pos.getZ(), 0.04f * (float) RandomZ, 0.4f * (float) RandomY, 0.04f * (float) RandomX));
      }
      playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 60, 1));
    }
    Boolean result = super.onBlockDestroyed(stack, worldIn, iBlockState, pos, playerIn);
    return result;
  }
}
