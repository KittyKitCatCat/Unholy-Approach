package holymod.custom_tabs;


import holymod.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author Nephroid
 *
 * User: Nephroid
 * Date: December 26, 2014
 *
 * The Startup classes for this example are called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 */
public class StartupClientOnly
{

  public static void preInitClientOnly() {
    // required in order for the renderer to know how to render your item.

      MinecraftForge.EVENT_BUS.register(new holymod.particle.DarkEnergy.TextureStitcherBreathFX());
      MinecraftForge.EVENT_BUS.register(new holymod.particle.Cloud.TextureStitcherBreathFX());
    MinecraftForge.EVENT_BUS.register(new holymod.particle.HolyFire.TextureStitcherBreathFX());
    MinecraftForge.EVENT_BUS.register(new holymod.particle.Smoke.TextureStitcherBreathFX());
    MinecraftForge.EVENT_BUS.register(new holymod.particle.Cursed.TextureStitcherBreathFX());

    final int DEFAULT_ITEM_SUBTYPE = 0;


    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("holymod:crystal_refinery", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.crystal_refinery, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

    ModelResourceLocation itemModelResourceLocation_The_Abbadon = new ModelResourceLocation("holymod:the_abbadon", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.the_abbadon, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_The_Abbadon);

    ModelResourceLocation itemModelResourceLocation_The_Providence = new ModelResourceLocation("holymod:the_providence", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.the_providence, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_The_Providence);

    ModelResourceLocation itemModelResourceLocation_Shard_Cursed = new ModelResourceLocation("holymod:shard_cursed", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.shard_cursed, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Shard_Cursed);

    ModelResourceLocation itemModelResourceLocation_Shard_Purified = new ModelResourceLocation("holymod:shard_purified", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.shard_purified, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Shard_Purified);

    ModelResourceLocation itemModelResourceLocation_Purity_Glide_Braclet = new ModelResourceLocation("holymod:purity_glide_braclet", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.purity_glide_braclet, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Purity_Glide_Braclet);

    ModelResourceLocation itemModelResourceLocation_Crystal_Normal = new ModelResourceLocation("holymod:crystal_normal", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.crystal_normal, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Crystal_Normal);

    ModelResourceLocation itemModelResourceLocation_Crystal_Sun = new ModelResourceLocation("holymod:crystal_sun", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.crystal_sun, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Crystal_Sun);

    ModelResourceLocation itemModelResourceLocation_Crystal_Moon = new ModelResourceLocation("holymod:crystal_moon", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.crystal_moon, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Crystal_Moon);

    ModelResourceLocation itemModelResourceLocation_Crimtane_Pendant = new ModelResourceLocation("holymod:crimtane_pendant", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.crimtane_pendant, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Crimtane_Pendant);

    ModelResourceLocation itemModelResourceLocation_Bloodbath_Bow = new ModelResourceLocation("holymod:bloodbath_bow", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.bloodbath_bow, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Bloodbath_Bow);

    ModelResourceLocation itemModelResourceLocation_Daywalker_Bow = new ModelResourceLocation("holymod:daywalker_bow", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.daywalker_bow, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Daywalker_Bow);

    ModelResourceLocation itemModelResourceLocation_Blood_Pickaxe = new ModelResourceLocation("holymod:blood_pickaxe", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_pickaxe, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Pickaxe);

    ModelResourceLocation itemModelResourceLocation_Blood_Axe = new ModelResourceLocation("holymod:blood_axe", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_axe, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Axe);

    ModelResourceLocation itemModelResourceLocation_Blood_Shovel = new ModelResourceLocation("holymod:blood_shovel", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_shovel, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Shovel);

    ModelResourceLocation itemModelResourceLocation_Blood_Sword = new ModelResourceLocation("holymod:blood_sword", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_sword, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Sword);

    ModelResourceLocation itemModelResourceLocation_Shard_Dagger = new ModelResourceLocation("holymod:shard_dagger", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.shard_dagger, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Shard_Dagger);

    ModelResourceLocation itemModelResourceLocation_Blood_Quartz = new ModelResourceLocation("holymod:blood_quartz", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_quartz, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Quartz);

    ModelResourceLocation itemModelResourceLocation_Blessed_Diamond = new ModelResourceLocation("holymod:blessed_diamond", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blessed_diamond, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blessed_Diamond);

    ModelResourceLocation itemModelResourceLocation_Blood_Lamp = new ModelResourceLocation("holymod:blood_lamp", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.blood_lamp, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blood_Lamp);

    ModelResourceLocation itemModelResourceLocation_Ring = new ModelResourceLocation("holymod:ring", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.ring, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Ring);

    ModelResourceLocation itemModelResourceLocation_Ring_Cursed = new ModelResourceLocation("holymod:ring_cursed", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.ring_cursed, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Ring_Cursed);

    ModelResourceLocation itemModelResourceLocation_Ring_Holy = new ModelResourceLocation("holymod:ring_holy", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.ring_holy, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Ring_Holy);

    ModelResourceLocation itemModelResourceLocation_Voodoo_Doll = new ModelResourceLocation("holymod:voodoo_doll", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.voodoo_doll, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Voodoo_Doll);

    ModelResourceLocation itemModelResourceLocation_Voodoo_Doll_Rending = new ModelResourceLocation("holymod:voodoo_doll_rending", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.voodoo_doll_rending, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Voodoo_Doll_Rending);

    ModelResourceLocation itemModelResourceLocation_Voodoo_Doll_Divine_Sight = new ModelResourceLocation("holymod:voodoo_doll_divine_sight", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.voodoo_doll_divine_sight, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Voodoo_Doll_Divine_Sight);

    ModelResourceLocation itemModelResourceLocation_Voodoo_Doll_Control = new ModelResourceLocation("holymod:voodoo_doll_control", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.voodoo_doll_control, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Voodoo_Doll_Control);

    ModelResourceLocation itemModelResourceLocation_blood_light = new ModelResourceLocation("holymod:blood_light", "inventory");
    ModelLoader.setCustomModelResourceLocation(ModItems.block_tile_blood_lamp, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_blood_light);

    ModelResourceLocation itemModelResourceLocation_blood_light_normal = new ModelResourceLocation("holymod:blood_light", "normal");
    ModelLoader.setCustomModelResourceLocation(ModItems.block_tile_blood_lamp, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_blood_light_normal);

  }

  public static void initClientOnly()
  {

  }

  public static void postInitClientOnly()
  {
  }
}
