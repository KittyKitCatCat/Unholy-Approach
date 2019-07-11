package holymod.items.gear.tools;

import holymod.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemShardDagger extends ItemSword
{
    public ItemShardDagger(ToolMaterial material)
    {
        super(material);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if (target.getHealth() <= 0f)
        {
            target.world.spawnEntity(new EntityItem(target.world, target.posX, target.posY, target.posZ, new ItemStack(ModItems.shard_cursed)));
        }
        return super.hitEntity(stack, target, attacker);
    }
}