package holymod.items.armor.hellfire;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ItemArmorHellfireLegs extends ItemArmor {

    protected String name;

    public ItemArmorHellfireLegs()
    {
        super(ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.LEGS);
    }

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "holymod:textures/armor/hellfirearmor.png";
    }

    @Override
    @Nullable
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
        return new ModelArmorHellfire(EntityEquipmentSlot.LEGS);
    }
}
