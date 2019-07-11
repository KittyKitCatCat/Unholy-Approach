package holymod.items.gear.tools.blood_quartz;


import holymod.init.ModBlocks;
import holymod.init.ModItems;
import holymod.network.PacketHandler;
import holymod.network.message.MessageCursedFX;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class ItemBloodPickaxe extends ItemPickaxe
{
  public ItemBloodPickaxe(ToolMaterial material)
  {
    super(material);
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
  {
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blood_pickaxe_tooltip"));
  }

  @Nonnull
  @Override
  public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float par8, float par9, float par10)
  {
    return place(player, world, pos, hand, side, par8, par9, par10, ModBlocks.blood_light, 0, 0F, 0F, 0F);
  }
  public static Random random = new Random();
  public static EnumActionResult place(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ, Block block, int cost, float r, float g, float b)
  {
    int Slot = -1;
    for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
    {
      ItemStack itemstack = player.inventory.getStackInSlot(i);
      int Damage = itemstack.getItemDamage();
      if (itemstack.getItem() == ModItems.blood_lamp)
      {
        if (Damage != 200)
        {
          Slot = i;
          break;
        }
      }
    }
    if (Slot == -1)
    {
      return EnumActionResult.FAIL;
    }
    if (player.inventory.hasItemStack(player.inventory.getStackInSlot(Slot)))
    {
      int Damage = player.inventory.getStackInSlot(Slot).getItemDamage();
      ItemStack stack = player.getHeldItem(hand);
      IBlockState state = player.world.getBlockState(pos);
      if (state.getBlock() == ModBlocks.blood_light)
      {
        player.world.setBlockToAir(pos);
        if (player.inventory.getStackInSlot(Slot).getItemDamage() == 200)
        {
          return EnumActionResult.FAIL;
        }
        player.inventory.getStackInSlot(Slot).damageItem(-1, player);
        return EnumActionResult.SUCCESS;
      }
      if (Damage != 200)
      {
        ItemStack stackToPlace = new ItemStack(block);
        player.inventory.getStackInSlot(Slot).damageItem(1, player);
        player.setHeldItem(hand, stackToPlace);
        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY() + 0.5D;
        double d2 = (double) pos.getZ() + 0.5D;
        for (int k = 0; k < 6; k++) {
          PacketHandler.INSTANCE.sendToAll(new MessageCursedFX(d0 + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), d1, d2 + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), 0.1f + (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.1f, 0.1f + (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1))));
        }
        stackToPlace.onItemUse(player, world, pos, hand, side, hitX, hitY, hitZ);
        player.setHeldItem(hand, stack);

        return EnumActionResult.SUCCESS;
      }
    }
    return EnumActionResult.PASS;
  }
}
