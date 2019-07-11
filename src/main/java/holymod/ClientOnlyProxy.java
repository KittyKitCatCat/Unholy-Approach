package holymod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * ClientProxy is used to set up the mod and start it running on normal minecraft.  It contains all the code that should run on the
 *   client side only.
 *   For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
 */
public class ClientOnlyProxy extends CommonProxy
{

  /**
   * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
   */
  public void preInit()
  {
    super.preInit();
    holymod.custom_tabs.StartupClientOnly.preInitClientOnly();
  }

  /**
   * Do your mod setup. Build whatever data structures you care about. Register recipes,
   * send FMLInterModComms messages to other mods.
   */
  public void init()
  {
    super.init();
    holymod.custom_tabs.StartupClientOnly.initClientOnly();
  }

  /**
   * Handle interaction with other mods, complete your setup based on this.
   */
  @Override
  public void registerItemRenderer(Item item, int meta, String id) {
    ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(HolyMod.MODID + ":" + id, "inventory"));
  }
  public void postInit()
  {
    super.postInit();
    holymod.custom_tabs.StartupClientOnly.postInitClientOnly();
  }

  public boolean playerIsInCreativeMode(EntityPlayer player) {
    if (player instanceof EntityPlayerMP) {
      EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
      return entityPlayerMP.interactionManager.isCreative();
    } else if (player instanceof EntityPlayerSP) {
      return Minecraft.getMinecraft().playerController.isInCreativeMode();
    }
    return false;
  }

  public boolean isDedicatedServer() {return false;}

  @Override
  protected void preInit(FMLPreInitializationEvent event) {

  }

}
