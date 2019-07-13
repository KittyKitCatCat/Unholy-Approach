package holymod.items.gear.tools;


import holymod.network.PacketHandler;
import holymod.network.message.MessageHolyFX;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticlePortal;
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

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class ItemEndburntPickaxe extends ItemPickaxe
{
  public ItemEndburntPickaxe(ToolMaterial material)
  {
    super(material);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
  {
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("endburnt_pickaxe_tooltip"));
  }
  public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull IBlockState state) {
    if (state.getBlock() instanceof BlockObsidian)
    {
      return toolMaterial.getEfficiency() * 5f;
    }
    return super.getDestroySpeed(stack, state);
  }
}
