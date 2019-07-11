package holymod.items.gear.tools.lumina;


import holymod.network.PacketHandler;
import holymod.network.message.MessageHolyFX;
import holymod.network.message.MessageSmokeFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemProvidence extends ItemSword {

    public ItemProvidence(ToolMaterial material) {
        super(material);
    }
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced){
        tooltip.add(" "+ TextFormatting.YELLOW+ I18n.format("the_lumina_holy_tooltip"));
    }
    private Random random;
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
            float DAMAGE = 4f;
            random = new Random();
            if (target.isPotionActive(MobEffects.WEAKNESS))
            {
                attacker.heal(2f);
            }
            else if (Math.random() < 0.2)
            {
                for (int k = 0; k < 15; k++)
                {
                    double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(target.posX, target.posY + target.height / 2, target.posZ, 0.75f * (float) RandomZ, 0.75f * (float) RandomY, 0.75f * (float) RandomX));
                }
                for (int k = 0; k < 8; k++)
                {
                    double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                    PacketHandler.INSTANCE.sendToAll(new MessageSmokeFX(target.posX, target.posY + target.height / 2, target.posZ, 0.2f * (float) RandomZ, 0.2f * (float) RandomY, 0.2f * (float) RandomX));
                }
                int hurtSave = target.hurtResistantTime;
                target.hurtResistantTime = 0;
                if (!target.attackEntityFrom(DamageSource.causeMobDamage(attacker), DAMAGE))
                {
                    target.hurtResistantTime = hurtSave;
                }
                target.attackEntityFrom(DamageSource.causeMobDamage(attacker), DAMAGE);

                target.world.playSound((EntityPlayer) null, target.posX, target.posY, target.posZ, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 10000.0F, 0.8F);
                target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 1));
                target.setFire(6);
            }

        return super.hitEntity(stack, target, attacker);
    }
}