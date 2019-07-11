package holymod.items.gear.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.Baubles;
import holymod.init.ModItems;
import holymod.network.PacketHandler;
import holymod.network.message.MessageCloudFX;
import holymod.network.message.MessageMovement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.IItemHandler;

import java.util.Random;

@Mod.EventBusSubscriber
public class ItemPurityGlideBraclet extends Item implements IBauble
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
	private static int GlideCharge = 20;
	private static int Cooldown = 0;
	public static ItemStack isBaubleEquipped(EntityPlayer player)
	{
		IItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slot = BaublesApi.isBaubleEquipped(player, ModItems.purity_glide_braclet);
		if (slot > 0)
		{
			return baubles.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
	@SubscribeEvent
	public static void cancelFallDamage(LivingAttackEvent event)
	{
		if (event.getSource() == DamageSource.FALL)
		{
			if (event.getEntityLiving() instanceof EntityPlayer)
			{
				EntityPlayer player = Minecraft.getMinecraft().player;
				IItemHandler baublesInv = BaublesApi.getBaublesHandler((EntityPlayer) event.getEntity());
				if(!isBaubleEquipped(player).isEmpty())
				{
					event.setCanceled(true);
					for (int k = 0; k < 15; k++)
					{
						PacketHandler.INSTANCE.sendToAll(new MessageCloudFX(event.getEntityLiving().posX + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), event.getEntityLiving().posY, event.getEntityLiving().posZ + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), 0.1f + (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1)), 0.1f, 0.1f + (float) (random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1))));
					}
				}
			}
		}
	}
	public static Random random = new Random();
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if (player instanceof EntityPlayerSP && player == Minecraft.getMinecraft().player)
		{
			EntityPlayerSP playerSp = (EntityPlayerSP) player;
			if (Cooldown > 0)
			{
				if (!playerSp.movementInput.jump)
				{
					Cooldown = 0;
				}
			}

			if (playerSp.onGround)
			{
				Cooldown = 1;
				GlideCharge = 15;
			}
			else
			{
				if (GlideCharge != 0)
				{
					if (playerSp.movementInput.jump)
					{
						if (Cooldown == 0)
						{
							PacketHandler.INSTANCE.sendToAll(new MessageCloudFX(player.posX + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), player.posY, player.posZ + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), 0f, 0f, 0f));
							player.velocityChanged = true;
							if (player.motionY < 0.1)
							{
								player.addVelocity(0, 0.05, 0);
							}
							player.addVelocity(0, 0.1, 0);
							GlideCharge -= 1;
							player.fallDistance = 0;
							PacketHandler.INSTANCE.sendToServer(new MessageMovement());
						}
					}
				}
			}
			if (GlideCharge == 0)
			{
				if (playerSp.movementInput.jump)
				{
					if (Cooldown == 0)
					{
						PacketHandler.INSTANCE.sendToAll(new MessageCloudFX(player.posX + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), player.posY, player.posZ + random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), 0f, 0f, 0f));
						player.velocityChanged = true;
						if (player.motionY < -0.1)
						{
							player.motionY = -0.1;
						}
						player.fallDistance = 0;
						PacketHandler.INSTANCE.sendToServer(new MessageMovement());
					}
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
