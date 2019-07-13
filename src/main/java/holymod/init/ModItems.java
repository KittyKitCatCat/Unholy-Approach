package holymod.init;

import holymod.HolyMod;
import holymod.items.debug.ItemBloodLight;
import holymod.items.gear.baubles.*;
import holymod.items.gear.tools.*;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedAxe;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedPickaxe;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedShovel;
import holymod.items.gear.tools.blessed_diamond.ItemBlessedSword;
import holymod.items.gear.tools.blood_quartz.*;
import holymod.items.gear.tools.lumina.ItemAbbadon;
import holymod.items.gear.tools.lumina.ItemProvidence;
import holymod.items.gear.tools.voodoo_doll.ItemDollBase;
import holymod.items.materials.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber
public class ModItems {

    public static CreativeTabs customTab = new CreativeTabs("holyMod") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.shard_cursed);
        }
    };

//Basic Gear
    public static Item endburnt_pickaxe = new ItemEndburntPickaxe(Item.ToolMaterial.DIAMOND).setUnlocalizedName("endburnt_pickaxe").setRegistryName("endburnt_pickaxe").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blood_axe = new ItemBloodAxe(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blood_axe").setRegistryName("blood_axe").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blood_shovel = new ItemBloodShovel(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blood_shovel").setRegistryName("blood_shovel").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blood_pickaxe = new ItemBloodPickaxe(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blood_pickaxe").setRegistryName("blood_pickaxe").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blood_sword = new ItemBloodSword(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blood_sword").setRegistryName("blood_sword").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blessed_axe = new ItemBlessedAxe(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blessed_axe").setRegistryName("blessed_axe").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blessed_shovel = new ItemBlessedShovel(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blessed_shovel").setRegistryName("blessed_shovel").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blessed_pickaxe = new ItemBlessedPickaxe(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blessed_pickaxe").setRegistryName("blessed_pickaxe").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blessed_sword = new ItemBlessedSword(HolyMod.BloodQuartzToolMaterial).setUnlocalizedName("blessed_sword").setRegistryName("blessed_sword").setCreativeTab(customTab).setMaxStackSize(1);

    public static Item the_abbadon = new ItemAbbadon(Item.ToolMaterial.DIAMOND).setUnlocalizedName("the_abbadon").setRegistryName("the_abbadon").setCreativeTab(customTab).setMaxDamage(2800).setMaxStackSize(1);
    public static Item the_providence = new ItemProvidence(Item.ToolMaterial.DIAMOND).setUnlocalizedName("the_providence").setRegistryName("the_providence").setCreativeTab(customTab).setMaxDamage(2800).setMaxStackSize(1);
    public static Item bloodbath_bow = new ItemBloodbathBow().setUnlocalizedName("bloodbath_bow").setRegistryName("bloodbath_bow").setCreativeTab(customTab);
    public static Item daywalker_bow = new ItemDaywalkerBow().setUnlocalizedName("daywalker_bow").setRegistryName("daywalker_bow").setCreativeTab(customTab);

    public static Item voodoo_doll  = new ItemVoodooDollMaterial().setUnlocalizedName("voodoo_doll").setRegistryName("voodoo_doll").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item shard_cursed = new ItemShardCursed().setUnlocalizedName("shard_cursed").setRegistryName("shard_cursed").setCreativeTab(customTab).setMaxStackSize(64);
    public static Item shard_purified = new ItemShardPurified().setUnlocalizedName("shard_purified").setRegistryName("shard_purified").setCreativeTab(customTab).setMaxStackSize(64);
    public static Item blood_quartz = new ItemBloodQuartz().setUnlocalizedName("blood_quartz").setRegistryName("blood_quartz").setCreativeTab(customTab).setMaxStackSize(64);
    public static Item blessed_diamond = new ItemBlessedDiamond().setUnlocalizedName("blessed_diamond").setRegistryName("blessed_diamond").setCreativeTab(customTab).setMaxStackSize(64);
    public static Item crystal_sun = new ItemCrystalSun().setUnlocalizedName("crystal_sun").setRegistryName("crystal_sun").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item crystal_moon  = new ItemCrystalMoon().setUnlocalizedName("crystal_moon").setRegistryName("crystal_moon").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item crystal_normal = new ItemCrystal().setUnlocalizedName("crystal_normal").setRegistryName("crystal_normal").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item ring = new ItemRing().setUnlocalizedName("ring").setRegistryName("ring").setCreativeTab(customTab).setMaxStackSize(16);

    public static Item ring_water = new ItemRingWater().setUnlocalizedName("ring_water").setRegistryName("ring_water").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item ring_cursed = new ItemRingCursed().setUnlocalizedName("ring_cursed").setRegistryName("ring_cursed").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item ring_dark_arts = new ItemRingDarkArts().setUnlocalizedName("ring_dark_arts").setRegistryName("ring_dark_arts").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item ring_holy = new ItemRingHoly().setUnlocalizedName("ring_holy").setRegistryName("ring_holy").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item ring_sun = new ItemRingSun().setUnlocalizedName("ring_sun").setRegistryName("ring_sun").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item ring_moon = new ItemRingMoon().setUnlocalizedName("ring_moon").setRegistryName("ring_moon").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item blood_lamp = new ItemBloodLamp().setUnlocalizedName("blood_lamp").setRegistryName("blood_lamp").setCreativeTab(customTab).setMaxDamage(200).setMaxStackSize(1);
    public static Item block_tile_blood_lamp = new ItemBloodLight(ModBlocks.blood_light).setUnlocalizedName("block_tile_blood_lamp").setRegistryName("block_tile_blood_lamp").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item crimtane_pendant = new ItemCrimtaneNecklace().setUnlocalizedName("crimtane_pendant").setRegistryName("crimtane_pendant").setCreativeTab(customTab).setMaxStackSize(1);
    public static Item purity_glide_braclet = new ItemPurityGlideBraclet().setUnlocalizedName("purity_glide_braclet").setRegistryName("purity_glide_braclet").setCreativeTab(customTab).setMaxStackSize(1);

    public static Item sunfire_core = new ItemModifierSunfireCore().setUnlocalizedName("sunfire_core").setRegistryName("sunfire_core").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item righteous_binding = new ItemModifierRighteousBinding().setUnlocalizedName("righteous_binding").setRegistryName("righteous_binding").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item holy_cross = new ItemModifierHolyCross().setUnlocalizedName("holy_cross").setRegistryName("holy_cross").setCreativeTab(customTab).setMaxStackSize(16);
    public static Item ender_artifact = new ItemEnderArtifact().setUnlocalizedName("ender_artifact").setRegistryName("ender_artifact").setCreativeTab(customTab).setMaxStackSize(1);

    public static Item voodoo_doll_shattering = new ItemDollBase().setUnlocalizedName("voodoo_doll_shattering").setRegistryName("voodoo_doll_shattering").setCreativeTab(customTab).setMaxStackSize(1).setMaxDamage(640);
    public static Item voodoo_doll_rending = new ItemDollBase().setUnlocalizedName("voodoo_doll_rending").setRegistryName("voodoo_doll_rending").setCreativeTab(customTab).setMaxStackSize(1).setMaxDamage(280);
    public static Item voodoo_doll_divine_sight = new ItemDollBase().setUnlocalizedName("voodoo_doll_divine_sight").setRegistryName("voodoo_doll_divine_sight").setCreativeTab(customTab).setMaxStackSize(1).setMaxDamage(3);
    public static Item voodoo_doll_misfortune = new ItemDollBase().setUnlocalizedName("voodoo_doll_misfortune").setRegistryName("voodoo_doll_misfortune").setCreativeTab(customTab).setMaxStackSize(1).setMaxDamage(560);
    public static Item voodoo_doll_control = new ItemDollBase().setUnlocalizedName("voodoo_doll_control").setRegistryName("voodoo_doll_control").setCreativeTab(customTab).setMaxStackSize(1).setMaxDamage(1120);

    public static Item shard_dagger = new ItemShardDagger(Item.ToolMaterial.WOOD).setUnlocalizedName("shard_dagger").setRegistryName("shard_dagger").setCreativeTab(customTab).setMaxDamage(250).setMaxStackSize(1);
    public static Item offering_table;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> evt)
    {
        IForgeRegistry<Item> r = evt.getRegistry();
        r.register(endburnt_pickaxe);
        r.register(blood_axe);
        r.register(blood_shovel);
        r.register(blood_pickaxe);
        r.register(blood_sword);
        r.register(blood_lamp);
        r.register(blessed_axe);
        r.register(blessed_shovel);
        r.register(blessed_pickaxe);
        r.register(blessed_sword);

        r.register(the_abbadon);
        r.register(the_providence);
        r.register(bloodbath_bow);
        r.register(daywalker_bow);

        r.register(voodoo_doll);
        r.register(shard_cursed);
        r.register(shard_purified);
        r.register(blood_quartz);
        r.register(blessed_diamond);
        r.register(crystal_sun);
        r.register(crystal_moon);
        r.register(crystal_normal);
        r.register(ring);

        r.register(ring_water);
        r.register(ring_cursed);
        r.register(ring_dark_arts);
        r.register(ring_holy);
        r.register(ring_sun);
        r.register(ring_moon);
        r.register(blood_lamp);
        r.register(block_tile_blood_lamp);
        r.register(crimtane_pendant);
        r.register(purity_glide_braclet);

        r.register(sunfire_core);
        r.register(holy_cross);
        r.register(righteous_binding);
        r.register(ender_artifact);

        r.register(voodoo_doll_shattering);
        r.register(voodoo_doll_rending);
        r.register(voodoo_doll_divine_sight);
        r.register(voodoo_doll_misfortune);
        r.register(voodoo_doll_control);

        r.register(shard_dagger);
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerRendering(@Nonnull ModelRegistryEvent event)
    {

        MinecraftForge.EVENT_BUS.register(new holymod.particle.DarkEnergy.TextureStitcherBreathFX());
        MinecraftForge.EVENT_BUS.register(new holymod.particle.Cloud.TextureStitcherBreathFX());
        MinecraftForge.EVENT_BUS.register(new holymod.particle.HolyFire.TextureStitcherBreathFX());
        MinecraftForge.EVENT_BUS.register(new holymod.particle.Smoke.TextureStitcherBreathFX());
        MinecraftForge.EVENT_BUS.register(new holymod.particle.Cursed.TextureStitcherBreathFX());

        final int DEFAULT_ITEM_SUBTYPE = 0;
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

        ModelResourceLocation itemModelResourceLocation_Blessed_Pickaxe = new ModelResourceLocation("holymod:blessed_pickaxe", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.blessed_pickaxe, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blessed_Pickaxe);

        ModelResourceLocation itemModelResourceLocation_Blessed_Axe = new ModelResourceLocation("holymod:blessed_axe", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.blessed_axe, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blessed_Axe);

        ModelResourceLocation itemModelResourceLocation_Blessed_Shovel = new ModelResourceLocation("holymod:blessed_shovel", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.blessed_shovel, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blessed_Shovel);

        ModelResourceLocation itemModelResourceLocation_Blessed_Sword = new ModelResourceLocation("holymod:blessed_sword", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.blessed_sword, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Blessed_Sword);

        ModelResourceLocation itemModelResourceLocation_Ender_Artifact = new ModelResourceLocation("holymod:ender_artifact", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.ender_artifact, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation_Ender_Artifact);

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
}
