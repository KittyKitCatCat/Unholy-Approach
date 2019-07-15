package holymod.items.gear.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.Baubles;
import holymod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
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
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.IItemHandler;

import java.util.Random;

public class ItemRingWater extends Item implements IBauble
{
	@GameRegistry.ObjectHolder(Baubles.MODID + ":ring")
	public static final Item RING = null;


	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
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
		if (player instanceof EntityPlayer)
		{
			if (player.isInWater())
			{
				GameSettings settings = Minecraft.getMinecraft().gameSettings;
				KeyBinding jump = settings.keyBindJump;
				KeyBinding forward = settings.keyBindForward;
				if (GameSettings.isKeyDown(jump))
				{
					player.moveRelative(0F, 0F, 0.005F, 3F);
					player.motionY += 0.06f;
				}
				else
				{
					if (GameSettings.isKeyDown(forward))
					{
						player.moveRelative(0F, 0F, 0.02F, 3F);
					}
				}
			}
		}
	}
	@SubscribeEvent
	public static void DecreaseDrownDamage(LivingHurtEvent event)
	{
		if (event.getSource() == DamageSource.DROWN)
		{
			if (event.getEntityLiving() instanceof EntityPlayer)
			{
				EntityPlayer player = Minecraft.getMinecraft().player;
				if(!isBaubleEquipped(player).isEmpty())
				{
					event.setAmount(event.getAmount() * 0.5f);
				}
			}
		}
	}
	public static ItemStack isBaubleEquipped(EntityPlayer player)
	{
		IItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slot = BaublesApi.isBaubleEquipped(player, ModItems.ring_water);
		if (slot > 0)
		{
			return baubles.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
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
