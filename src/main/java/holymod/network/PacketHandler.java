package holymod.network;

import holymod.HolyMod;
import holymod.network.message.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


public class PacketHandler {
        public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(HolyMod.MODID);

        private static int id = 0;

        public static void registerMessages()
        {
            INSTANCE.registerMessage(MessageCursedFX.MessageHolder.class, MessageCursedFX.class,id++, Side.CLIENT);
            INSTANCE.registerMessage(MessageSmokeFX.MessageHolder.class, MessageSmokeFX.class,id++, Side.CLIENT);
            INSTANCE.registerMessage(MessageUnholyFX.MessageHolder.class, MessageUnholyFX.class,id++, Side.CLIENT);
            INSTANCE.registerMessage(MessageMovement.Handler.class, MessageMovement.class,id++, Side.CLIENT);
            INSTANCE.registerMessage(MessageCloudFX.MessageHolder.class, MessageCloudFX.class,id++, Side.CLIENT);
            INSTANCE.registerMessage(MessageHolyFX.MessageHolder.class, MessageHolyFX.class,id++, Side.CLIENT);
        }
    }

