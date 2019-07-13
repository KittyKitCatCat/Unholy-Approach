package holymod.items.gear.tools;

import holymod.HolyMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid= HolyMod.MODID)
public class ItemEnderArtifact extends Item
{
  // you must use Block in the constructor, not BlockVariants, otherwise you won't be able to register the block properly.
  //   i.e. using GameRegistry.registerBlock(block, ItemBlockVariants.class, name)
  public ItemEnderArtifact()
  {
    this.setMaxStackSize(1);
    this.canRepair = true;
  }

  @SubscribeEvent
  public static void RightClickItem(PlayerInteractEvent.RightClickItem event)
  {
      ItemStack stack = event.getItemStack();
      if (stack.getItem() instanceof ItemEnderArtifact)
      {
          event.getEntityPlayer().displayGUIChest(event.getEntityPlayer().getInventoryEnderChest());
      }
  }
}