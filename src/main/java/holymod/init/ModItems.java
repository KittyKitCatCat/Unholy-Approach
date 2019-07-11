package holymod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static CreativeTabs customTab;

//Basic Gear
    public static Item blood_axe;
    public static Item blood_shovel;
    public static Item blood_pickaxe;
    public static Item blood_sword;
    public static Item blessed_axe;
    public static Item blessed_shovel;
    public static Item blessed_pickaxe;
    public static Item blessed_sword;

    //Armor
    public static Item crown_of_sorrow;

//Crafting Materials
    public static Item voodoo_doll;
    public static Item shard_cursed;
    public static Item shard_purified;
    public static Item blood_quartz;
    public static Item blessed_diamond;
    public static Item crystal_sun;
    public static Item crystal_moon;
    public static Item crystal_normal;
    public static Item ring;
//Baubles && Utility
    public static Item ring_cursed;
    public static Item ring_holy;
    public static Item ring_sun;
    public static Item ring_moon;
    public static Item blood_lamp;
    public static Item block_tile_blood_lamp;
    public static Item crimtane_pendant;
    public static Item purity_glide_braclet;
//Special
    public static Item crystal_refinery;
    public static Item voodoo_doll_shattering;
    public static Item voodoo_doll_rending;
    public static Item voodoo_doll_divine_sight;
    public static Item voodoo_doll_misfortune;
    public static Item voodoo_doll_control;
    public static Item the_abbadon;
    public static Item the_providence;
    public static Item bloodbath_bow;
    public static Item daywalker_bow;
//Progression
    public static Item shard_dagger;
    public static Item offering_table;

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                blood_axe,
                voodoo_doll,
                voodoo_doll_rending,
                crown_of_sorrow,
                voodoo_doll_control,
                voodoo_doll_divine_sight,
                voodoo_doll_shattering,
                voodoo_doll_misfortune,
                bloodbath_bow,
                daywalker_bow,
                crystal_refinery,
                blood_shovel,
                blood_pickaxe,
                blood_sword,
                blessed_axe,
                blessed_shovel,
                blessed_pickaxe,
                blessed_sword,
                blood_quartz,
                blessed_diamond,
                crystal_sun,
                crystal_moon,
                crystal_normal,
                blood_lamp,
                block_tile_blood_lamp,
                crimtane_pendant,
                purity_glide_braclet,
                ring_cursed,
                ring,
                ring_holy,
                ring_moon,
                ring_sun,
                the_abbadon,
                the_providence,
                offering_table,
                shard_dagger,
                shard_cursed,
                shard_purified
        );
    }
}
