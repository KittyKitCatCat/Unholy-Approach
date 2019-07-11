package holymod.items.gear.tools.blood_quartz;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBloodShovel extends ItemSpade
{
  public ItemBloodShovel(ToolMaterial material)
  {
    super(material);
  }
  // damage the item when it destroys a block - defaults to 1 damage for tools
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState iBlockState, BlockPos pos, EntityLivingBase playerIn)
  {
    if (iBlockState.getBlock() instanceof BlockDirt || iBlockState.getBlock() instanceof BlockGrass)
    {
      int Damage = stack.getItemDamage();
      Damage -= 1;
      stack.setItemDamage(Damage);
    }
    Boolean result = super.onBlockDestroyed(stack, worldIn, iBlockState, pos, playerIn);
    return result;
  }
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced){
    tooltip.add(" "+ TextFormatting.RED+ I18n.format("blood_shovel_tooltip"));
  }
}
