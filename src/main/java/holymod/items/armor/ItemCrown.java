package holymod.items.armor;

import holymod.HolyMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemCrown extends ItemArmor {

    protected String name;

    public ItemCrown() {
        super(ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.HEAD);
    }

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "holymod:textures/armor/crown.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nullable
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
        return new CrownModel();
    }

    public void registerItemModel() {
        HolyMod.proxy.registerItemRenderer(this, 0, name);
    }

}
