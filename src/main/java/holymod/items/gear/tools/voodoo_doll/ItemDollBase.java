package holymod.items.gear.tools;

import holymod.HolyMod;
import holymod.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;
@Mod.EventBusSubscriber(modid= HolyMod.MODID)
public class ItemDollBase extends Item
{
  // you must use Block in the constructor, not BlockVariants, otherwise you won't be able to register the block properly.
  //   i.e. using GameRegistry.registerBlock(block, ItemBlockVariants.class, name)
  public ItemDollBase()
  {
    this.setMaxStackSize(1);
    this.canRepair = true;
  }

  private static void Effect(Entity target, EntityLivingBase attacker)
  {
      Random random = new Random();
      EnumHand hand = attacker.getActiveHand();
      ItemStack stack = attacker.getHeldItem(hand);

      if (stack.getItem() == ModItems.voodoo_doll_control)
      {
          target.setVelocity(random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1), random.nextDouble() * 0.5 * (random.nextDouble() > 0.5 ? -1 : 1));
      }
      if (stack.getItem() == ModItems.voodoo_doll_divine_sight)
      {
          if (target instanceof EntityPlayer)
          {
              if(!attacker.world.isRemote)
              {
                  ((EntityPlayer) attacker).displayGUIChest(((EntityPlayer) target).getInventoryEnderChest());
              }
          }

      }
      if (stack.getItem() == ModItems.voodoo_doll_rending)
      {
          int hurtSave = target.hurtResistantTime;
          target.hurtResistantTime = 0;
          if (!target.attackEntityFrom(DamageSource.causeIndirectDamage(attacker, (EntityLivingBase) target).setDamageBypassesArmor(), 2f))
          {
              target.hurtResistantTime = hurtSave;
          }
          target.attackEntityFrom(DamageSource.causeIndirectDamage(attacker, (EntityLivingBase) target).setDamageBypassesArmor(), 2f);

      }
      if (stack.getItem() == ModItems.voodoo_doll_misfortune)
      {
          if (target instanceof EntityLivingBase)
          {
          }
      }
  }
  @SubscribeEvent
  public static void RightClickItem(PlayerInteractEvent.RightClickItem event)
  {
      ItemStack stack = event.getItemStack();
      if (!event.getEntityLiving().isSneaking())
      {
          if (stack.hasTagCompound())
          {
              if (event.getWorld() instanceof WorldServer)
              {
                  WorldServer worldServer = (WorldServer) event.getWorld();
                  NBTTagCompound nbt = stack.getTagCompound();
                  if (nbt != null)
                  {
                      UUID uuid = nbt.getUniqueId("entity");
                      if (uuid != null)
                      {
                          if (!(worldServer.getEntityFromUuid(uuid) instanceof EntityPlayer))
                          {
                              if (worldServer.getEntityFromUuid(uuid) != null)
                              {
                                  Effect(worldServer.getEntityFromUuid(uuid), event.getEntityLiving());
                              }
                              else
                              {
                                  return;
                              }
                          }
                          else
                          {
                              if (worldServer.getPlayerEntityByUUID(uuid) != null)
                              {
                                  Effect(worldServer.getPlayerEntityByUUID(uuid), event.getEntityLiving());
                              }
                              else
                              {
                                  return;
                              }
                          }
                      }
                  }
              }
              stack.damageItem(1, event.getEntityLiving());
          }
      }
  }
  @SubscribeEvent
  public static void RightClickEntity(PlayerInteractEvent.EntityInteract event)
  {
      if (event.getEntityLiving().isSneaking())
      {
          ItemStack stack = event.getItemStack();
          Entity entity = event.getTarget();
          if (!(stack.getItem() == ModItems.voodoo_doll_divine_sight))
          {
              if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer))
              {
                  if (!stack.hasTagCompound())
                  {
                      stack.setTagCompound(new NBTTagCompound());
                      NBTTagCompound nbt = stack.getTagCompound();
                      assert nbt != null;
                      nbt.setUniqueId("entity", entity.getUniqueID());
                      entity.addTag("cursed");
                  }
                  if (stack.hasTagCompound())
                  {
                      NBTTagCompound nbt = stack.getTagCompound();
                      assert nbt != null;
                      if (event.getWorld() instanceof WorldServer)
                      {
                          WorldServer worldServer = (WorldServer) event.getWorld();
                          UUID uuid = nbt.getUniqueId("entity");
                          if (uuid != null)
                          {
                              if (!(worldServer.getEntityFromUuid(uuid) instanceof EntityPlayer))
                              {
                                  if (worldServer.getEntityFromUuid(uuid) != null)
                                  {
                                      Objects.requireNonNull(worldServer.getEntityFromUuid(uuid)).removeTag("cursed");
                                  }
                              }
                          }
                      }
                      entity.addTag("cursed");
                      nbt.setUniqueId("entity", entity.getUniqueID());
                  }
              }
          }
          if (entity instanceof EntityPlayer)
          {
              if (!stack.hasTagCompound())
              {
                  stack.setTagCompound(new NBTTagCompound());
                  NBTTagCompound nbt = stack.getTagCompound();
                  assert nbt != null;
                  nbt.setUniqueId("entity", entity.getUniqueID());
                  entity.addTag("cursed");
              }
              if (stack.hasTagCompound())
              {
                  NBTTagCompound nbt = stack.getTagCompound();
                  assert nbt != null;
                  if (event.getWorld() instanceof WorldServer)
                  {
                      WorldServer worldServer = (WorldServer) event.getWorld();
                      UUID uuid = nbt.getUniqueId("entity");
                      if (uuid != null)
                      {
                          if (!(worldServer.getEntityFromUuid(uuid) instanceof EntityPlayer))
                          {
                              if (worldServer.getEntityFromUuid(uuid) != null)
                              {
                                  Objects.requireNonNull(worldServer.getEntityFromUuid(uuid)).removeTag("cursed");
                              }
                          }
                      }
                  }
                  entity.addTag("cursed");
                  nbt.setUniqueId("entity", entity.getUniqueID());
              }
          }
      }
  }
}