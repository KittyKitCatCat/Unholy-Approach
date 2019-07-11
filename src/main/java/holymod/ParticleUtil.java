package holymod;

import holymod.particle.Cloud.CloudParticle;
import holymod.particle.DarkEnergy.DarkEnergyParticle;
import holymod.particle.HolyFire.FlameParticle;
import holymod.particle.Cursed.CursedParticle;
import holymod.particle.Smoke.SmokeParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import java.util.Random;

public class ParticleUtil {
    public static Random random = new Random();
    public static int counter = 0;

    public static void spawnParticleHoly(World world, float x, float y, float z, float vx, float vy, float vz, float r, float g, float b, float a, float scale, int lifetime) {
        if (HolyMod.proxy instanceof ClientOnlyProxy)
        {
            counter += random.nextInt(1);
            if (counter % (Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : 2 * Minecraft.getMinecraft().gameSettings.particleSetting) == 0)
            {
                FlameParticle newEffect = new FlameParticle(world, x, y, z, vx, vy, vz);
                Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
            }
        }
    }
    public static void spawnParticleSmoke(World world, float x, float y, float z, float vx, float vy, float vz, float r, float g, float b, float a, float scale, int lifetime) {
        if (HolyMod.proxy instanceof ClientOnlyProxy)
        {
            counter += random.nextInt(1);
            if (counter % (Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : 2 * Minecraft.getMinecraft().gameSettings.particleSetting) == 0)
            {
                SmokeParticle newEffect = new SmokeParticle(world, x, y, z, vx, vy, vz);
                Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
            }
        }
    }
    public static void spawnParticleUnholy(World world, float x, float y, float z, float vx, float vy, float vz, float r, float g, float b, float a, float scale, int lifetime) {
        if (HolyMod.proxy instanceof ClientOnlyProxy)
        {
            counter += random.nextInt(1);
            if (counter % (Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : 2 * Minecraft.getMinecraft().gameSettings.particleSetting) == 0)
            {
                DarkEnergyParticle newEffect = new DarkEnergyParticle(world, x, y, z, vx, vy, vz);
                Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
            }
        }
    }
    public static void spawnParticleCursed(World world, float x, float y, float z, float vx, float vy, float vz, float r, float g, float b, float a, float scale, int lifetime) {
        if (HolyMod.proxy instanceof ClientOnlyProxy)
        {
            counter += random.nextInt(1);
            if (counter % (Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : 2 * Minecraft.getMinecraft().gameSettings.particleSetting) == 0)
            {
                CursedParticle newEffect = new CursedParticle(world, x, y, z, vx, vy, vz);
                Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
            }
        }
    }
    public static void spawnParticleCloud(World world, float x, float y, float z, float vx, float vy, float vz, float r, float g, float b, float a, float scale, int lifetime) {
        if (HolyMod.proxy instanceof ClientOnlyProxy)
        {
            counter += random.nextInt(1);
            if (counter % (Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : 2 * Minecraft.getMinecraft().gameSettings.particleSetting) == 0)
            {
                CloudParticle newEffect = new CloudParticle(world, x, y, z, vx, vy, vz);
                Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
            }
        }
    }
}
