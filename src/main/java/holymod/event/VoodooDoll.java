package holymod.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START;

@Mod.EventBusSubscriber
public class VoodooDoll
{
    static Random random;
    @SubscribeEvent
    public static void Load(TickEvent.WorldTickEvent event)
    {
        random = new Random();
        if (event.phase == START && !event.world.isRemote)
        {
            List<EntityLivingBase> items = new ArrayList<>();
            for (Entity e : event.world.loadedEntityList)
            {
                if (e instanceof EntityLivingBase)
                {
                    items.add((EntityLivingBase) e);
                }
            }

            for (EntityLivingBase item : items)
            {
                if (item.getTags().contains("cursed"))
                {
                    item.world.getBlockState(item.getPosition());
                }
            }
        }
    }
}