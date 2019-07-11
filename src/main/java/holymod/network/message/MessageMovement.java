package holymod.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageMovement implements IMessage
{

    public MessageMovement() {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<MessageMovement, IMessage> {



        @Override

        public IMessage onMessage(MessageMovement message, MessageContext ctx) {

            EntityPlayerMP player = ctx.getServerHandler().player;

            player.mcServer.addScheduledTask(() ->
            {
                player.fallDistance = 0;
            });


            return null;

        }

    }
}
