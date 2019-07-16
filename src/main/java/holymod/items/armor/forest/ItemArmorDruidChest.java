package holymod.items.armor.forest;

import holymod.HolyMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemArmorDruidChest extends ItemArmor {

    protected String name;

    public ItemArmorDruidChest() {
        super(ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.CHEST);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "holymod:textures/armor/druidarmor.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nullable
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
        return new ModelArmorDruid(EntityEquipmentSlot.CHEST);
    }

    public void registerItemModel() {
        HolyMod.proxy.registerItemRenderer(this, 0, name);
    }

}
