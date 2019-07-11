package holymod.init;

import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {


public static Block blood_light;
public static Block offering_table;
public static Block crystal_refinery;


    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                blood_light,
                offering_table,
                crystal_refinery
        );
    }
}
