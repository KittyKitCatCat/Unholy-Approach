package holymod.event;

import holymod.HolyMod;
import holymod.network.PacketHandler;
import holymod.network.message.MessageCursedFX;
import holymod.network.message.MessageHolyFX;
import holymod.network.message.MessageSmokeFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;
@Mod.EventBusSubscriber(modid=HolyMod.MODID)
public class ArrowImpact
{
    static Random random;
    //this is just an example zoom function
    @SubscribeEvent
    public static void ArrowImpact(ProjectileImpactEvent event) {
        random = new Random();
        Entity arrow = event.getEntity();
        if (arrow instanceof EntityArrow) {

            if (((EntityArrow) event.getEntity()).getIsCritical()) {
                Entity victim = event.getRayTraceResult().entityHit;
                if (victim instanceof EntityLivingBase) {
                    if (arrow.getTags().contains("fired_by_bloodbath")) {
                        for (int k = 0; k < 8; k++) {
                            PacketHandler.INSTANCE.sendToAll(new MessageCursedFX(arrow.posX, arrow.posY + arrow.height / 2, arrow.posZ, 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1))));
                        }
                        EntityLivingBase target = (EntityLivingBase) victim;
                        target.addPotionEffect(new PotionEffect(MobEffects.POISON, 70, 1));
                        target.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 70, 1));
                        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 70, 1));
                        target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 70, 1));
                        arrow.setDead();
                    }
                    if (arrow.getTags().contains("fired_by_daywalker")) {
                        for (int k = 0; k < 4; k++) {
                            PacketHandler.INSTANCE.sendToAll(new MessageSmokeFX(arrow.posX, arrow.posY + arrow.height / 2, arrow.posZ, 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1))));
                            PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(arrow.posX, arrow.posY + arrow.height / 2, arrow.posZ, 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.25f * (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1))));
                        }
                        Entity shooter = ((EntityArrow) arrow).shootingEntity;
                        if (shooter instanceof EntityLivingBase) {
                            ((EntityLivingBase) shooter).setHealth(((EntityLivingBase) shooter).getHealth() + 0.5f);
                        }
                        arrow.setDead();
                    }
                }
            }
        }
    }
}