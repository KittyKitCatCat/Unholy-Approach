
package holymod.items.armor;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelArmorDruid extends ModelArmor
{
    private final ModelRenderer bb_main;
    private final ModelRenderer head;
    private final ModelRenderer helmN;
    private final ModelRenderer helmS;
    private final ModelRenderer helmE;
    private final ModelRenderer helmW;
    private final ModelRenderer antlerL1;
    private final ModelRenderer antlerL2;
    private final ModelRenderer antlerL3;
    private final ModelRenderer antlerL4;
    private final ModelRenderer antlerL5;
    private final ModelRenderer antlerR1;
    private final ModelRenderer antlerR2;
    private final ModelRenderer antlerR3;
    private final ModelRenderer antlerR4;
    private final ModelRenderer antlerR5;
    private final ModelRenderer body;
    private final ModelRenderer cape;
    private final ModelRenderer armleft;
    private final ModelRenderer armright;
    private final ModelRenderer legleft;
    private final ModelRenderer legright;

    public ModelArmorDruid(EntityEquipmentSlot slot)
    {
        super(slot);
        textureWidth = 96;
        textureHeight = 96;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 52, 32, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.4F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 36, 32, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.8F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 64, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.5F, false));

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -4.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.2F, false));

        helmN = new ModelRenderer(this);
        helmN.setRotationPoint(0.0F, -2.0F, -4.2F);
        setRotationAngle(helmN, 0.2618F, 0.0F, 0.0F);
        head.addChild(helmN);
        helmN.cubeList.add(new ModelBox(helmN, 48, 64, -5.0F, -4.0F, 0.0F, 10, 4, 0, 0.0F, false));

        helmS = new ModelRenderer(this);
        helmS.setRotationPoint(-0.0F, -2.0F, 4.2F);
        setRotationAngle(helmS, -0.2618F, 0.0F, 0.0F);
        head.addChild(helmS);
        helmS.cubeList.add(new ModelBox(helmS, 0, 80, -5.0F, -4.0F, 0.0F, 10, 4, 0, 0.0F, false));

        helmE = new ModelRenderer(this);
        helmE.setRotationPoint(-4.2F, -2.0F, 0.0F);
        setRotationAngle(helmE, 0.0F, 0.0F, -0.2618F);
        head.addChild(helmE);
        helmE.cubeList.add(new ModelBox(helmE, 0, 32, 0.0F, -4.0F, -5.0F, 0, 4, 10, 0.0F, false));

        helmW = new ModelRenderer(this);
        helmW.setRotationPoint(4.2F, -2.0F, 0.0F);
        setRotationAngle(helmW, 0.0F, 0.0F, 0.2618F);
        head.addChild(helmW);
        helmW.cubeList.add(new ModelBox(helmW, 44, 16, 0.0F, -4.0F, -5.0F, 0, 4, 10, 0.0F, false));

        antlerL1 = new ModelRenderer(this);
        antlerL1.setRotationPoint(-2.0F, -3.0F, 0.0F);
        setRotationAngle(antlerL1, -0.0873F, 0.0F, -0.1745F);
        head.addChild(antlerL1);
        antlerL1.cubeList.add(new ModelBox(antlerL1, 8, 87, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));

        antlerL2 = new ModelRenderer(this);
        antlerL2.setRotationPoint(1.0F, -3.0F, 0.0F);
        setRotationAngle(antlerL2, 0.0F, 0.0F, 0.4363F);
        antlerL1.addChild(antlerL2);
        antlerL2.cubeList.add(new ModelBox(antlerL2, 20, 80, -8.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F, false));

        antlerL3 = new ModelRenderer(this);
        antlerL3.setRotationPoint(-1.5F, 0.0F, -1.0F);
        setRotationAngle(antlerL3, -0.1745F, 0.0F, 0.0F);
        antlerL2.addChild(antlerL3);
        antlerL3.cubeList.add(new ModelBox(antlerL3, 32, 87, -1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));

        antlerL4 = new ModelRenderer(this);
        antlerL4.setRotationPoint(-3.5F, 0.0F, -1.0F);
        setRotationAngle(antlerL4, -0.1745F, 0.0F, -0.1745F);
        antlerL2.addChild(antlerL4);
        antlerL4.cubeList.add(new ModelBox(antlerL4, 76, 80, -2.0F, -4.0F, 0.0F, 2, 4, 2, 0.0F, false));

        antlerL5 = new ModelRenderer(this);
        antlerL5.setRotationPoint(-8.0F, 2.0F, 1.0F);
        setRotationAngle(antlerL5, -0.1745F, -0.0873F, -0.3491F);
        antlerL2.addChild(antlerL5);
        antlerL5.cubeList.add(new ModelBox(antlerL5, 60, 80, 0.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, false));

        antlerR1 = new ModelRenderer(this);
        antlerR1.setRotationPoint(2.0F, -3.0F, 0.0F);
        setRotationAngle(antlerR1, -0.0873F, 0.0F, 0.1745F);
        head.addChild(antlerR1);
        antlerR1.cubeList.add(new ModelBox(antlerR1, 16, 87, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));

        antlerR2 = new ModelRenderer(this);
        antlerR2.setRotationPoint(-1.0F, -3.0F, 0.0F);
        setRotationAngle(antlerR2, 0.0F, 0.0F, -0.4363F);
        antlerR1.addChild(antlerR2);
        antlerR2.cubeList.add(new ModelBox(antlerR2, 40, 80, 0.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F, false));

        antlerR3 = new ModelRenderer(this);
        antlerR3.setRotationPoint(1.5F, 0.0F, -1.0F);
        setRotationAngle(antlerR3, -0.1745F, 0.0F, 0.0F);
        antlerR2.addChild(antlerR3);
        antlerR3.cubeList.add(new ModelBox(antlerR3, 24, 87, -1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));

        antlerR4 = new ModelRenderer(this);
        antlerR4.setRotationPoint(3.5F, 0.0F, -1.0F);
        setRotationAngle(antlerR4, -0.1745F, 0.0F, 0.1745F);
        antlerR2.addChild(antlerR4);
        antlerR4.cubeList.add(new ModelBox(antlerR4, 0, 87, 0.0F, -4.0F, 0.0F, 2, 4, 2, 0.0F, false));

        antlerR5 = new ModelRenderer(this);
        antlerR5.setRotationPoint(8.0F, 2.0F, 1.0F);
        setRotationAngle(antlerR5, -0.1745F, 0.0873F, 0.3491F);
        antlerR2.addChild(antlerR5);
        antlerR5.cubeList.add(new ModelBox(antlerR5, 68, 80, -2.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, false));

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 6.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.8F, false));
        body.cubeList.add(new ModelBox(body, 32, 0, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.3F, false));
        body.cubeList.add(new ModelBox(body, 56, 0, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.2F, false));

        cape = new ModelRenderer(this);
        cape.setRotationPoint(0.0F, -6.0F, 2.8F);
        setRotationAngle(cape, 0.0873F, 0.0F, 0.0F);
        body.addChild(cape);
        cape.cubeList.add(new ModelBox(cape, 24, 16, -5.0F, 0.0F, 0.0F, 10, 14, 0, 0.0F, false));

        armleft = new ModelRenderer(this);
        armleft.setRotationPoint(0.0F, 24.0F, 0.0F);
        armleft.cubeList.add(new ModelBox(armleft, 16, 48, -8.0F, -24.0F, -2.0F, 4, 12, 4, 0.4F, false));
        armleft.cubeList.add(new ModelBox(armleft, 48, 48, -8.0F, -24.0F, -2.0F, 4, 12, 4, 0.7F, false));

        armright = new ModelRenderer(this);
        armright.setRotationPoint(0.0F, 24.0F, 0.0F);
        armright.cubeList.add(new ModelBox(armright, 32, 48, 4.0F, -24.0F, -2.0F, 4, 12, 4, 0.4F, false));
        armright.cubeList.add(new ModelBox(armright, 16, 64, 4.0F, -24.0F, -2.0F, 4, 12, 4, 0.7F, false));

        legleft = new ModelRenderer(this);
        legleft.setRotationPoint(0.0F, 24.0F, 0.0F);
        legleft.cubeList.add(new ModelBox(legleft, 32, 64, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.5F, false));
        legleft.cubeList.add(new ModelBox(legleft, 0, 48, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.8F, false));
        legleft.cubeList.add(new ModelBox(legleft, 20, 32, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.4F, false));

        legright = new ModelRenderer(this);
        legright.setRotationPoint(0.0F, 24.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        head.showModel = slot == EntityEquipmentSlot.HEAD;
        helmE.showModel = slot == EntityEquipmentSlot.HEAD;
        helmN.showModel = slot == EntityEquipmentSlot.HEAD;
        helmS.showModel = slot == EntityEquipmentSlot.HEAD;
        helmW.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerL1.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerL2.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerL3.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerL4.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerL5.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerR1.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerR2.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerR3.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerR4.showModel = slot == EntityEquipmentSlot.HEAD;
        antlerR5.showModel = slot == EntityEquipmentSlot.HEAD;
        body.showModel = slot == EntityEquipmentSlot.CHEST;
        cape.showModel = slot == EntityEquipmentSlot.CHEST;
        bb_main.showModel = slot == EntityEquipmentSlot.LEGS;
        armleft.showModel = slot == EntityEquipmentSlot.LEGS;
        bb_main.render(f5);
        head.render(f5);
        body.render(f5);
        armleft.render(f5);
        armright.render(f5);
        legleft.render(f5);
        legright.render(f5);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}