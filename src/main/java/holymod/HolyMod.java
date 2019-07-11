package holymod;

import holymod.network.PacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HolyMod.MODID, version = HolyMod.VERSION)
public class HolyMod
{
  // you also need to update the modid and version in two other places as well:
  //  build.gradle file (the version, group, and archivesBaseName parameters)
  //  resources/mcmod.info (the name, description, and version parameters)
    public static final String MODID = "holymod";
    public static final String VERSION = "1.12.2a";

    // The instance of your mod that Forge uses.  Optional.
    @Mod.Instance(HolyMod.MODID)
    public static HolyMod instance;

    //        WOOD(0, 59, 2.0F, 0.0F, 15),
    //        STONE(1, 131, 4.0F, 1.0F, 5),
    //        IRON(2, 250, 6.0F, 2.0F, 14),
    //        DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    //        GOLD(0, 32, 12.0F, 0.0F, 22);
    public static final Item.ToolMaterial BloodQuartzToolMaterial = EnumHelper.addToolMaterial("BloodQuartzToolMaterial", 3, 1000, 6, 2.5f, 20);

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="holymod.ClientOnlyProxy", serverSide="holymod.DedicatedServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
      PacketHandler.registerMessages();
      proxy.preInit();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
      proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
      proxy.postInit();
    }
    public static String prependModID(String name) {return MODID + ":" + name;}
}
