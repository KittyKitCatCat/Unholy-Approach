package holymod.items.gear.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.Baubles;
import holymod.init.ModItems;
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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.IItemHandler;

import java.util.Random;

@Mod.EventBusSubscriber
public class ItemRingSun extends Item implements IBauble
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
	public static ItemStack isBaubleEquipped(EntityPlayer player)
	{
		IItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slot = BaublesApi.isBaubleEquipped(player, ModItems.ring_sun);
		if (slot > 0)
		{
			return baubles.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
	public static Random random = new Random();
	@SubscribeEvent
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if (player instanceof EntityPlayerSP && player == Minecraft.getMinecraft().player)
		{
			EntityPlayerSP playerSp = (EntityPlayerSP) player;
			if (playerSp.world.isDaytime())
			{
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
