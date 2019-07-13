package holymod.init;

import holymod.blocks.BlockBloodLight;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
@Mod.EventBusSubscriber
public class ModBlocks {


public static Block blood_light = new BlockBloodLight().setUnlocalizedName("blood_light").setRegistryName("blood_light").setLightLevel(8F);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> evt)
    {
        IForgeRegistry<Block> r = evt.getRegistry();
        r.register(blood_light);
    }
}
