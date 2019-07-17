package holymod.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorDruidHead extends ItemArmor {

    public ItemArmorDruidHead() {
        super(ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "holymod:textures/armor/druidarmor.png";
    }

    @Override
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
        return new ModelArmorDruid(EntityEquipmentSlot.HEAD);
    }
}
