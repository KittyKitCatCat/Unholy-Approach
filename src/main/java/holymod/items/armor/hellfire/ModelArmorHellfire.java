//Made with Blockbench
//Paste this code into your mod.

package holymod.items.armor.hellfire;

import holymod.items.armor.ModelArmor;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelArmorHellfire extends ModelArmor {
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightboot;
	private final ModelRenderer leftboot;
	private final ModelRenderer stalactiteL1;
	private final ModelRenderer stalactiteL2;
	private final ModelRenderer stalactiteL3;
	private final ModelRenderer stalactiteR1;
	private final ModelRenderer stalactiteR2;
	private final ModelRenderer stalactiteR3;
	private final ModelRenderer horn;

	public ModelArmorHellfire(EntityEquipmentSlot slot)
	{
		super(slot, 128, 128);
		textureWidth = 128;
		textureHeight = 128;

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-0F, 0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.02F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 0, 40, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.4F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0F, 0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.02F, true));
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 40, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.4F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.02F, false));
		body.cubeList.add(new ModelBox(body, 16, 32, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.5F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.3F, false));
		head.cubeList.add(new ModelBox(head, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.4F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-1F, 0F, 0.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 40, 16, 0.0F, -2.0F, -2.0F, 4, 12, 4, 0.08F, true));
		leftarm.cubeList.add(new ModelBox(leftarm, 40, 32, 0.0F, -2.0F, -2.0F, 4, 8, 4, 0.4F, true));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(1F, 0F, 0.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 40, 16, -4.0F, -2.0F, -2.0F, 4, 12, 4, 0.08F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 56, 32, -4.0F, -2.0F, -2.0F, 4, 8, 4, 0.4F, true));

		rightboot = new ModelRenderer(this);
		rightboot.setRotationPoint(-0F, 5.5F, 0.0F);
		rightboot.cubeList.add(new ModelBox(rightboot, 0, 32, -2.0F, 2.0F, -2.0F, 4, 4, 4, 0.55F, false));

		leftboot = new ModelRenderer(this);
		leftboot.setRotationPoint(0F, 5.5F, 0.0F);
		leftboot.cubeList.add(new ModelBox(leftboot, 0, 32, -2.0F, 2.0F, -2.0F, 4, 4, 4, 0.55F, true));

		stalactiteL1 = new ModelRenderer(this);
		stalactiteL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteL1, -0.6109F, 0.5236F, 0.3491F);
		stalactiteL1.cubeList.add(new ModelBox(stalactiteL1, 16, 48, -2.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));

		stalactiteL2 = new ModelRenderer(this);
		stalactiteL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteL2, -0.6109F, 0.5236F, 0.6981F);
		stalactiteL2.cubeList.add(new ModelBox(stalactiteL2, 16, 48, -2.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));

		stalactiteL3 = new ModelRenderer(this);
		stalactiteL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteL3, -0.6109F, 0.5236F, 1.0472F);
		stalactiteL3.cubeList.add(new ModelBox(stalactiteL3, 16, 48, -2.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));


		stalactiteR1 = new ModelRenderer(this);
		stalactiteR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteR1, -0.6109F, -0.5236F, -0.3491F);
		stalactiteR1.cubeList.add(new ModelBox(stalactiteR1, 24, 48, 0.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));

		stalactiteR2 = new ModelRenderer(this);
		stalactiteR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteR2, -0.6109F, -0.5236F, -1.0472F);
		stalactiteR2.cubeList.add(new ModelBox(stalactiteR2, 24, 48, 0.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));

		stalactiteR3 = new ModelRenderer(this);
		stalactiteR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(stalactiteR3, -0.6109F, -0.5236F, -0.6981F);
		stalactiteR3.cubeList.add(new ModelBox(stalactiteR3, 24, 48, 0.0F, -11.0F, -1.0F, 2, 9, 2, -0.3F, false));

		horn = new ModelRenderer(this);
		horn.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(horn, 0.3491F, 0.0F, 0.0F);
		horn.cubeList.add(new ModelBox(horn, 32, 48, -1.0F, -9.0F, -1.0F, 2, 4, 6, 0.02F, false));

		bipedHead.addChild(head);
		head.addChild(horn);
		body.addChild(stalactiteL1);
		body.addChild(stalactiteL2);
		body.addChild(stalactiteL3);
		body.addChild(stalactiteR1);
		body.addChild(stalactiteR2);
		body.addChild(stalactiteR3);
		bipedBody.addChild(body);
		bipedLeftArm.addChild(leftarm);
		bipedRightArm.addChild(rightarm);
		bipedLeftLeg.addChild(leftleg);
		bipedRightLeg.addChild(rightleg);
		bipedLeftLeg.addChild(leftboot);
		bipedRightLeg.addChild(rightboot);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		head.showModel = slot == EntityEquipmentSlot.HEAD;
		body.showModel = slot == EntityEquipmentSlot.CHEST;
		rightarm.showModel = slot == EntityEquipmentSlot.CHEST;
		leftarm.showModel = slot == EntityEquipmentSlot.CHEST;
		rightleg.showModel = slot == EntityEquipmentSlot.LEGS;
		leftleg.showModel = slot == EntityEquipmentSlot.LEGS;
		rightboot.showModel = slot == EntityEquipmentSlot.FEET;
		leftboot.showModel = slot == EntityEquipmentSlot.FEET;
		bipedHeadwear.showModel = false;
		super.render(entity, f, f1, f2, f3, f4, f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}