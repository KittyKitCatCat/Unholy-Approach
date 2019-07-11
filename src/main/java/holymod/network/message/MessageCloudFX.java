package holymod.network.message;

import holymod.ParticleUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class MessageCloudFX implements IMessage {
    double x, y, z;
    float vz, vy, vx;

    public MessageCloudFX() {
    }

    public MessageCloudFX(double x, double y, double z, float vz, float vy, float vx) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.vz = vz;
        this.vy = vy;
        this.vx = vx;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readDouble();
        y = buf.readDouble();
        z = buf.readDouble();
        vx = buf.readFloat();
        vy = buf.readFloat();
        vz = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
        buf.writeFloat(vx);
        buf.writeFloat(vy);
        buf.writeFloat(vz);
    }

    public static class MessageHolder implements IMessageHandler<MessageCloudFX, IMessage> {
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(final MessageCloudFX message, final MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                World world = Minecraft.getMinecraft().world;
                Random random = world.rand;
                ParticleUtil.spawnParticleCloud(world, (float)message.x, (float)message.y, (float) message.z, message.vx, message.vy, message.vz, 255, 255, 0, 0.2f, 1.0f, 6+random.nextInt(12));
            });
            return null;
        }
    }
}
