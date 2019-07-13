package holymod.event;

import holymod.HolyMod;
import holymod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= HolyMod.MODID)
public class AnvilEvent
{
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event)
    {
        if (event.getLeft().isEmpty() || event.getRight().isEmpty())
            return;

        ItemStack item = event.getLeft();
        ItemStack modifier = event.getRight();
        assert item.getTagCompound() != null;
        if (!item.isEmpty() && (modifier.getItem() == ModItems.sunfire_core || modifier.getItem() == ModItems.holy_cross || modifier.getItem() == ModItems.righteous_binding))
        {
            ItemStack innercopy = item.copy();
            if (!innercopy.hasTagCompound())
            {
                innercopy.setTagCompound(new NBTTagCompound());
                NBTTagCompound nbt = innercopy.getTagCompound();
                assert nbt != null;
                if (nbt.getBoolean("sunfire_core") || nbt.getBoolean("holy_cross") || nbt.getBoolean("righteous_binding"))
                {
                    return;
                }
                if (modifier.getItem() == ModItems.sunfire_core)
                {
                    nbt.setBoolean("sunfire_core", true);
                }
                if (modifier.getItem() == ModItems.holy_cross)
                {
                    nbt.setBoolean("holy_cross", true);
                }
                if (modifier.getItem() == ModItems.righteous_binding)
                {
                    nbt.setBoolean("righteous_binding", true);
                }

            }
            else
            {
                NBTTagCompound nbt = innercopy.getTagCompound();
                assert nbt != null;
                if (nbt.getBoolean("sunfire_core") || nbt.getBoolean("holy_cross") || nbt.getBoolean("righteous_binding"))
                {
                    return;
                }
                if (modifier.getItem() == ModItems.sunfire_core)
                {
                    nbt.setBoolean("sunfire_core", true);
                }
                if (modifier.getItem() == ModItems.holy_cross)
                {
                    nbt.setBoolean("holy_cross", true);
                }
                if (modifier.getItem() == ModItems.righteous_binding)
                {
                    nbt.setBoolean("righteous_binding", true);
                }
            }
            event.setOutput(innercopy);
            event.setCost(10);
        }
    }
}