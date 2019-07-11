package holymod.items.gear.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.Baubles;
import holymod.network.PacketHandler;
import holymod.network.message.MessageCursedFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@Mod.EventBusSubscriber
public class ItemCrimtaneNecklace extends Item implements IBauble
{
	@GameRegistry.ObjectHolder(Baubles.MODID + ":charm")
	public static final Item RING = null;


	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.CHARM;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for (int i = 0; i < baubles.getSlots(); i++)
				if ((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
					baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
					if (!player.capabilities.isCreativeMode) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					}
					onEquipped(player.getHeldItem(hand), player);
					break;
				}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	public static Random random = new Random();
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if (player instanceof EntityPlayerSP && player == Minecraft.getMinecraft().player)
		{
			EntityPlayerSP playerSp = (EntityPlayerSP) player;
			if (playerSp.isSprinting())
			{
				if (playerSp.onGround && !playerSp.isInWater())
				{
					PacketHandler.INSTANCE.sendToAll(new MessageCursedFX(player.posX + (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)) * (double)player.width, player.getEntityBoundingBox().minY + 0.1D, player.posZ + (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)) * (double)player.width, (float)(player.motionZ + (float)(random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)) / 8), 0.08f, (float)(player.motionX + (float)(random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)) / 8)));
					player.moveRelative(0F, 0F, 0.01F, 3F);
				}
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
	}
}
