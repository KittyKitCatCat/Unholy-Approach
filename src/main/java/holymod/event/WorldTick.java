package holymod.event;

import holymod.init.ModItems;
import holymod.items.materials.ItemCrystal;
import holymod.items.materials.ItemShardCursed;
import holymod.network.PacketHandler;
import holymod.network.message.MessageHolyFX;
import holymod.network.message.MessageUnholyFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START;

@Mod.EventBusSubscriber
public class WorldTick
{
    static Random random;
    @SubscribeEvent
    public static void Purify(TickEvent.WorldTickEvent event)
    {
        random = new Random();
        if (event.phase == START && !event.world.isRemote) {
            List<EntityItem> items = new ArrayList<>();
            for (Entity e : event.world.loadedEntityList) {
                if (e instanceof EntityItem) {
                    items.add((EntityItem) e);
                }
            }

            for (EntityItem item : items) {
                ItemStack stack = item.getItem();
                if (stack.getItem() instanceof ItemShardCursed) {
                    if (item.isWet()) {
                        int Count = item.getItem().getCount();
                        item.world.spawnEntity(new EntityItem(item.world, item.posX, item.posY, item.posZ, new ItemStack(ModItems.shard_purified)));

                        item.getItem().setCount(Count - 1);
                        if (Count == 1)
                        {
                            item.setDead();
                        }
                    }
                }
                if (stack.getItem() instanceof ItemCrystal) {
                    if (!stack.hasTagCompound())
                    {
                        stack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound nbt = stack.getTagCompound();
                        nbt.setInteger("timer", 0);
                    }
                    if (stack.hasTagCompound())
                    {
                        double Random = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                        int timer = stack.getTagCompound().getInteger("timer");
                        if (timer >= 10)
                        {
                            if (item.world.isDaytime())
                            {
                                PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(item.posX + random.nextDouble() * 0.2, item.posY + random.nextDouble() * 0.2, item.posZ + random.nextDouble() * 0.2, 0f, 0.4f * (float)Random, 0f));
                            }
                            else
                            {
                                PacketHandler.INSTANCE.sendToAll(new MessageUnholyFX(item.posX + random.nextDouble() * 0.2, item.posY, item.posZ + random.nextDouble() * 0.2, 0f, 0.2f * random.nextFloat() * 0.2f, 0f));
                            }
                        }
                        if (timer >= 200)
                        {
                            item.world.playSound((EntityPlayer) null, item.posX, item.posY + item.height, item.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 10000.0F, 0.5F);
                            item.world.playSound((EntityPlayer) null, item.posX, item.posY + item.height, item.posZ, SoundEvents.ENTITY_PLAYER_HURT_ON_FIRE, SoundCategory.BLOCKS, 10000.0F, 0.8F);
                            if (item.world.isDaytime())
                            {
                                item.world.spawnEntity(new EntityItem(item.world, item.posX, item.posY + item.height, item.posZ, new ItemStack(ModItems.crystal_sun)));
                                for (int k = 0; k < 15; k++)
                                {
                                    double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    PacketHandler.INSTANCE.sendToAll(new MessageHolyFX(item.posX, item.posY + item.height / 2, item.posZ, 0.4f * (float)RandomZ, 0.4f * (float)RandomY, 0.4f * (float)RandomX));
                                }
                            }
                            else
                            {
                                item.world.spawnEntity(new EntityItem(item.world, item.posX, item.posY + item.height, item.posZ, new ItemStack(ModItems.crystal_moon)));
                                for (int k = 0; k < 15; k++)
                                {
                                    double RandomZ = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    double RandomY = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    double RandomX = random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1);
                                    PacketHandler.INSTANCE.sendToAll(new MessageUnholyFX(item.posX, item.posY + item.height / 2, item.posZ, 0.4f * (float)RandomZ, 0.4f * (float)RandomY, 0.4f * (float)RandomX));
                                }
                            }
                            item.setDead();
                        }
                        stack.getTagCompound().setInteger("timer", ++timer);
                    }
                }
            }
        }
    }
}