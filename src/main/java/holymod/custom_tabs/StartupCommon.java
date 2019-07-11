package holymod.custom_tabs;

import holymod.blocks.BlockBloodLight;
import holymod.blocks.BlockCrystalRefinery;
import holymod.blocks.tileentities.TileEntityCrystalRefinery;
import holymod.init.ModBlocks;
import holymod.init.ModItems;
import holymod.items.armor.ItemCrown;
import holymod.items.debug.ItemBloodLight;
import holymod.items.gear.baubles.ItemCrimtaneNecklace;
import holymod.items.gear.baubles.ItemPurityGlideBraclet;
import holymod.items.gear.baubles.ItemRingCursed;
import holymod.items.gear.baubles.ItemRingHoly;
import holymod.items.gear.tools.ItemBloodbathBow;
import holymod.items.gear.tools.ItemDaywalkerBow;
import holymod.items.gear.tools.ItemDollBase;
import holymod.items.gear.tools.ItemShardDagger;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedAxe;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedPickaxe;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedShovel;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedSword;
import holymod.items.gear.tools.blood_quartz.*;
import holymod.items.gear.tools.lumina.ItemAbbadon;
import holymod.items.gear.tools.lumina.ItemProvidence;
import holymod.items.materials.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static holymod.HolyMod.BloodQuartzToolMaterial;

/**
 * User: The Grey Ghost
 * Date: 24/12/2014
 *
 * The Startup classes for this example are called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 */
public class StartupCommon
{


  public static void preInitCommon() {
      ModItems.customTab = new CreativeTabs("holyMod") {
          @Override
          @SideOnly(Side.CLIENT)
          public ItemStack getTabIconItem() {
              return new ItemStack(ModItems.shard_cursed);
          }
      };

//  The lines below create a test block and item instance that are going to be added to the creative tabs.
//  An item can be listed on multiple tabs by overriding Item.getCreativeTabs()
//  A block can only be listed on one tab, unless you give it a custom ItemBlock which overrides .getCreativeTabs()

      // add an item (an item without a corresponding block)
      // set up logging of the various methods - for any methods you don't want to log, change to false

      GameRegistry.registerTileEntity(TileEntityCrystalRefinery.class, "crystal_refinery");

      // You need to register a GUIHandler for the container.  However there can be only one handler per mod, so for the purposes
      //   of this project, we create a single GuiHandlerRegistry for all examples.
      // We register this GuiHandlerRegistry with the NetworkRegistry, and then tell the GuiHandlerRegistry about
      //   each example's GuiHandler, in this case GuiHandlerMBE30, so that when it gets a request from NetworkRegistry,
      //   it passes the request on to the correct example's GuiHandler.

      ModBlocks.crystal_refinery = new BlockCrystalRefinery().setUnlocalizedName("crystal_refinery");
      ModBlocks.crystal_refinery.setRegistryName("crystal_refinery");
      ForgeRegistries.BLOCKS.register(ModBlocks.crystal_refinery);

      ModItems.crystal_refinery = new ItemBlock(ModBlocks.crystal_refinery);
      ModItems.crystal_refinery.setRegistryName("crystal_refinery");
      ForgeRegistries.ITEMS.register(ModItems.crystal_refinery);

      ModItems.voodoo_doll_misfortune = new ItemDollBase().setUnlocalizedName("voodoo_doll_misfortune").setCreativeTab(ModItems.customTab);
      ModItems.voodoo_doll_misfortune.setRegistryName("voodoo_doll_misfortune");
      ModItems.voodoo_doll_misfortune.setMaxDamage(561);
      ForgeRegistries.ITEMS.register(ModItems.voodoo_doll_misfortune);

      ModItems.voodoo_doll_rending = new ItemDollBase().setUnlocalizedName("voodoo_doll_rending").setCreativeTab(ModItems.customTab);
      ModItems.voodoo_doll_rending.setRegistryName("voodoo_doll_rending");
      ModItems.voodoo_doll_rending.setMaxDamage(281);
      ForgeRegistries.ITEMS.register(ModItems.voodoo_doll_rending);

      ModItems.voodoo_doll_control = new ItemDollBase().setUnlocalizedName("voodoo_doll_control").setCreativeTab(ModItems.customTab);
      ModItems.voodoo_doll_control.setRegistryName("voodoo_doll_control");
      ModItems.voodoo_doll_control.setMaxDamage(1081);
      ForgeRegistries.ITEMS.register(ModItems.voodoo_doll_control);

      ModItems.voodoo_doll_divine_sight = new ItemDollBase().setUnlocalizedName("voodoo_doll_divine_sight").setCreativeTab(ModItems.customTab);
      ModItems.voodoo_doll_divine_sight.setRegistryName("voodoo_doll_divine_sight");
      ModItems.voodoo_doll_divine_sight.setMaxDamage(4);
      ForgeRegistries.ITEMS.register(ModItems.voodoo_doll_divine_sight);

      ModBlocks.blood_light = new BlockBloodLight().setUnlocalizedName("blood_light").setLightLevel(8F);
      ModBlocks.blood_light.setRegistryName("blood_light");
      ForgeRegistries.BLOCKS.register(ModBlocks.blood_light);

      ModItems.blood_lamp = new ItemBloodLamp().setUnlocalizedName("blood_lamp").setCreativeTab(ModItems.customTab);
      ModItems.blood_lamp.setRegistryName("blood_lamp");
      ForgeRegistries.ITEMS.register(ModItems.blood_lamp);

      ModItems.voodoo_doll = new ItemVoodooDollMaterial().setUnlocalizedName("voodoo_doll").setCreativeTab(ModItems.customTab);
      ModItems.voodoo_doll.setRegistryName("voodoo_doll");
      ModItems.voodoo_doll.setMaxStackSize(16);
      ForgeRegistries.ITEMS.register(ModItems.voodoo_doll);

      ModItems.ring = new ItemRing().setUnlocalizedName("ring").setCreativeTab(ModItems.customTab);
      ModItems.ring.setRegistryName("ring");
      ModItems.ring.setMaxStackSize(16);
      ForgeRegistries.ITEMS.register(ModItems.ring);

      ModItems.block_tile_blood_lamp = new ItemBloodLight(ModBlocks.blood_light).setUnlocalizedName("block_tile_blood_lamp").setCreativeTab(ModItems.customTab);
      ModItems.block_tile_blood_lamp.setRegistryName("block_tile_blood_lamp");
      ForgeRegistries.ITEMS.register(ModItems.block_tile_blood_lamp);

      ModItems.blood_pickaxe = new ItemBloodPickaxe(BloodQuartzToolMaterial).setUnlocalizedName("blood_pickaxe").setCreativeTab(ModItems.customTab);
      ModItems.blood_pickaxe.setRegistryName("blood_pickaxe");
      ForgeRegistries.ITEMS.register(ModItems.blood_pickaxe);

      ModItems.blood_sword = new ItemBloodSword(BloodQuartzToolMaterial).setUnlocalizedName("blood_sword").setCreativeTab(ModItems.customTab);
      ModItems.blood_sword.setRegistryName("blood_sword");
      ForgeRegistries.ITEMS.register(ModItems.blood_sword);

      ModItems.blood_shovel = new ItemBloodShovel(BloodQuartzToolMaterial).setUnlocalizedName("blood_shovel").setCreativeTab(ModItems.customTab);
      ModItems.blood_shovel.setRegistryName("blood_shovel");
      ForgeRegistries.ITEMS.register(ModItems.blood_shovel);

      ModItems.blood_axe = new ItemBloodAxe(BloodQuartzToolMaterial).setUnlocalizedName("blood_axe").setCreativeTab(ModItems.customTab);
      ModItems.blood_axe.setRegistryName("blood_axe");
      ForgeRegistries.ITEMS.register(ModItems.blood_axe);

      ModItems.daywalker_bow = new ItemDaywalkerBow().setUnlocalizedName("daywalker_bow").setCreativeTab(ModItems.customTab);
      ModItems.daywalker_bow.setRegistryName("daywalker_bow");
      ForgeRegistries.ITEMS.register(ModItems.daywalker_bow);

      ModItems.crown_of_sorrow = new ItemCrown().setUnlocalizedName("crown_of_sorrow").setCreativeTab(ModItems.customTab);
      ModItems.crown_of_sorrow.setRegistryName("crown_of_sorrow");
      ForgeRegistries.ITEMS.register(ModItems.crown_of_sorrow);

      ModItems.bloodbath_bow = new ItemBloodbathBow().setUnlocalizedName("bloodbath_bow").setCreativeTab(ModItems.customTab);
      ModItems.bloodbath_bow.setRegistryName("bloodbath_bow");
      ForgeRegistries.ITEMS.register(ModItems.bloodbath_bow);

      ModItems.blessed_pickaxe = new ItemBlessedPickaxe(BloodQuartzToolMaterial).setUnlocalizedName("blessed_pickaxe").setCreativeTab(ModItems.customTab);
      ModItems.blessed_pickaxe.setRegistryName("blessed_pickaxe");
      ForgeRegistries.ITEMS.register(ModItems.blessed_pickaxe);

      ModItems.blessed_sword = new ItemBlessedSword(BloodQuartzToolMaterial).setUnlocalizedName("blessed_sword").setCreativeTab(ModItems.customTab);
      ModItems.blessed_sword.setRegistryName("blessed_sword");
      ForgeRegistries.ITEMS.register(ModItems.blessed_sword);

      ModItems.blessed_shovel = new ItemBlessedShovel(BloodQuartzToolMaterial).setUnlocalizedName("blessed_shovel").setCreativeTab(ModItems.customTab);
      ModItems.blessed_shovel.setRegistryName("blessed_shovel");
      ForgeRegistries.ITEMS.register(ModItems.blessed_shovel);

      ModItems.blessed_axe = new ItemBlessedAxe(BloodQuartzToolMaterial).setUnlocalizedName("blessed_axe").setCreativeTab(ModItems.customTab);
      ModItems.blessed_axe.setRegistryName("blessed_axe");
      ForgeRegistries.ITEMS.register(ModItems.blessed_axe);

      ModItems.purity_glide_braclet = new ItemPurityGlideBraclet().setUnlocalizedName("purity_glide_braclet").setCreativeTab(ModItems.customTab);
      ModItems.purity_glide_braclet.setMaxStackSize(1);
      ModItems.purity_glide_braclet.setRegistryName("purity_glide_braclet");
      ModItems.purity_glide_braclet.setMaxDamage(0);
      ForgeRegistries.ITEMS.register(ModItems.purity_glide_braclet);

      ModItems.crimtane_pendant = new ItemCrimtaneNecklace().setUnlocalizedName("crimtane_pendant").setCreativeTab(ModItems.customTab);
      ModItems.crimtane_pendant.setMaxStackSize(1);
      ModItems.crimtane_pendant.setRegistryName("crimtane_pendant");
      ModItems.crimtane_pendant.setMaxDamage(0);
      ForgeRegistries.ITEMS.register(ModItems.crimtane_pendant);

      ModItems.ring_cursed = new ItemRingCursed().setUnlocalizedName("ring_cursed").setCreativeTab(ModItems.customTab);
      ModItems.ring_cursed.setMaxStackSize(1);
      ModItems.ring_cursed.setRegistryName("ring_cursed");
      ModItems.ring_cursed.setMaxDamage(0);
      ForgeRegistries.ITEMS.register(ModItems.ring_cursed);

      ModItems.ring_holy = new ItemRingHoly().setUnlocalizedName("ring_holy").setCreativeTab(ModItems.customTab);
      ModItems.ring_holy.setMaxStackSize(1);
      ModItems.ring_holy.setRegistryName("ring_holy");
      ModItems.ring_holy.setMaxDamage(0);
      ForgeRegistries.ITEMS.register(ModItems.ring_holy);

      ModItems.the_abbadon = new ItemAbbadon(Item.ToolMaterial.DIAMOND).setUnlocalizedName("the_abbadon").setCreativeTab(ModItems.customTab);
      ModItems.the_abbadon.setRegistryName("the_abbadon");
      ModItems.the_abbadon.setMaxDamage(1561);
      ModItems.the_abbadon.setMaxStackSize(1);
      ForgeRegistries.ITEMS.register(ModItems.the_abbadon);

      ModItems.the_providence = new ItemProvidence(Item.ToolMaterial.DIAMOND).setUnlocalizedName("the_providence").setCreativeTab(ModItems.customTab);
      ModItems.the_providence.setRegistryName("the_providence");
      ModItems.the_providence.setMaxDamage(1561);
      ModItems.the_providence.setMaxStackSize(1);
      ForgeRegistries.ITEMS.register(ModItems.the_providence);

      ModItems.shard_dagger = new ItemShardDagger(Item.ToolMaterial.WOOD).setUnlocalizedName("shard_dagger").setCreativeTab(ModItems.customTab);
      ModItems.shard_dagger.setRegistryName("shard_dagger");
      ModItems.shard_dagger.setMaxDamage(250);
      ModItems.shard_dagger.setMaxStackSize(1);
      ForgeRegistries.ITEMS.register(ModItems.shard_dagger);


      ModItems.blood_quartz = new ItemBloodQuartz().setUnlocalizedName("blood_quartz").setCreativeTab(ModItems.customTab);
      ModItems.blood_quartz.setRegistryName("blood_quartz");
      ModItems.blood_quartz.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.blood_quartz);


      ModItems.blessed_diamond = new ItemBlessedDiamond().setUnlocalizedName("blessed_diamond").setCreativeTab(ModItems.customTab);
      ModItems.blessed_diamond.setRegistryName("blessed_diamond");
      ModItems.blessed_diamond.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.blessed_diamond);

      ModItems.shard_cursed = new ItemShardCursed().setUnlocalizedName("shard_cursed").setCreativeTab(ModItems.customTab);
      ModItems.shard_cursed.setRegistryName("shard_cursed");
      ModItems.shard_cursed.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.shard_cursed);

      ModItems.shard_purified = new ItemShardPurified().setUnlocalizedName("shard_purified").setCreativeTab(ModItems.customTab);
      ModItems.shard_purified.setRegistryName("shard_purified");
      ModItems.shard_purified.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.shard_purified);

      ModItems.crystal_moon = new ItemCrystalMoon().setUnlocalizedName("crystal_moon").setCreativeTab(ModItems.customTab);
      ModItems.crystal_moon.setRegistryName("crystal_moon");
      ModItems.crystal_moon.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.crystal_moon);

      ModItems.crystal_sun = new ItemCrystalSun().setUnlocalizedName("crystal_sun").setCreativeTab(ModItems.customTab);
      ModItems.crystal_sun.setRegistryName("crystal_sun");
      ModItems.crystal_sun.setMaxStackSize(64);
      ForgeRegistries.ITEMS.register(ModItems.crystal_sun);

      ModItems.crystal_normal = new ItemCrystal().setUnlocalizedName("crystal_normal").setCreativeTab(ModItems.customTab);
      ModItems.crystal_normal.setRegistryName("crystal_normal");
      ForgeRegistries.ITEMS.register(ModItems.crystal_normal);
  }
    public static void initCommon()
  {
  }

  public static void postInitCommon()
  {
  }
}
