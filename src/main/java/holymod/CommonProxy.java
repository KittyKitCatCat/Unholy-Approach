package holymod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * CommonProxy is used to set up the mod and start it running.  It contains all the code that should run on both the
 *   Standalone client and the dedicated server.
 *   For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
 */
public abstract class CommonProxy {

  /**
   * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
   */
  public void preInit() {
    holymod.custom_tabs.StartupCommon.preInitCommon();
  }

  /**
   * Do your mod setup. Build whatever data structures you care about. Register recipes,
   * send FMLInterModComms messages to other mods.
   */
  public void init() {
    holymod.custom_tabs.StartupCommon.initCommon();
  }

  /**
   * Handle interaction with other mods, complete your setup based on this.
   */
  public static IThreadListener getThreadListener(final MessageContext context) {
    if (context.side.isServer()) {
      return context.getServerHandler().player.mcServer;
    } else {
      throw new WrongSideException("Tried to get the IThreadListener from a client-side MessageContext on the dedicated server");
    }
  }

  public void postInit() {
    holymod.custom_tabs.StartupCommon.postInitCommon();
  }

  public void registerItemRenderer(Item item, int meta, String id) {
  }

  public void registerItemRenderer(Block block, int meta, String id) {
    registerItemRenderer(Item.getItemFromBlock(block), meta, id);
  }

  // helper to determine whether the given player is in creative mode
  //  not necessary for most examples
  abstract public boolean playerIsInCreativeMode(EntityPlayer player);

  public static EntityPlayer getPlayer(final MessageContext context)
  {
    if (context.side.isServer())
    {
      return context.getServerHandler().player;
    }
    else
    {
      throw new WrongSideException("Tried to get the player from a client-side MessageContext on the dedicated server");
    }
  }

  static class WrongSideException extends RuntimeException {
    public WrongSideException(final String message) {
      super(message);
    }

    public WrongSideException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * is this a dedicated server?
   *
   * @return true if this is a dedicated server, false otherwise
   */
  abstract public boolean isDedicatedServer();

  protected abstract void preInit(FMLPreInitializationEvent event);
}