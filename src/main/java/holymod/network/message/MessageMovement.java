package holymod.network.message;

import holymod.CommonProxy;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageMovement implements IMessage
{
    public double Velocity;
    public int playerID;

    public MessageMovement(double Velocity, EntityPlayer player)
    {
        this.Velocity = Velocity;
        this.playerID = player.getEntityId();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeDouble(Velocity);
        buf.writeInt(playerID);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.Velocity = buf.readDouble();
        this.playerID = buf.readInt();
    }

//-------------------------------------------------------------------------------------------------------------------------//

    public static class Handler implements IMessageHandler<MessageMovement, IMessage>
    {
        @Override
            public IMessage onMessage(MessageMovement message, MessageContext ctx)
        {
            CommonProxy.getThreadListener(ctx).addScheduledTask(() ->
            {
                if(CommonProxy.getPlayer(ctx) != null)
                {
                    EntityPlayer player = (EntityPlayer) CommonProxy.getPlayer(ctx).world.getEntityByID(message.playerID);
                    GameSettings settings = Minecraft.getMinecraft().gameSettings;
                    KeyBinding jump = settings.keyBindJump;

                    //settings.isKeyDown(jump);
                    player.motionY = message.Velocity;
                }
            });

            return null;
        }
    }
}