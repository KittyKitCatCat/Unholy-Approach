package holymod.items.debug;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBloodLight extends ItemBlock
{
  // you must use Block in the constructor, not BlockVariants, otherwise you won't be able to register the block properly.
  //   i.e. using GameRegistry.registerBlock(block, ItemBlockVariants.class, name)
  public ItemBloodLight(Block block)
  {
    super(block);
  }
}