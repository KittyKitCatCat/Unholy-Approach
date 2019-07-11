package holymod.blocks;

import holymod.network.PacketHandler;
import holymod.network.message.MessageCursedFX;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;


public class BlockBloodLight extends Block
{
  public BlockBloodLight()
  {
    super(Material.FIRE);
  }
  public static Random random = new Random();

  @Nullable
  @Override
  public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
  {
    return NULL_AABB;
  }
  @Override
  public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
  {
    return false;
  }
  public boolean isOpaqueCube(IBlockState state)
  {
    return false;
  }

  public boolean isFullCube(IBlockState state)
  {
    return false;
  }

  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.INVISIBLE;
  }

  @SideOnly(Side.CLIENT)
  public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
  {
    double d0 = (double)pos.getX() + 0.5D;
    double d1 = (double)pos.getY() + 0.5D;
    double d2 = (double)pos.getZ() + 0.5D;
    PacketHandler.INSTANCE.sendToAll(new MessageCursedFX(d0 + (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1) / 2), d1, d2 + (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1) / 2), 0f, 0.01f, 0f));
  }
}
