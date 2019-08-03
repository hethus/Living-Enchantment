package net.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.platform.GlStateManager;
import java.util.Calendar;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.tileentity.model.ChestModel;
import net.minecraft.client.renderer.tileentity.model.LargeChestModel;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.EnderChestTileEntity;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TrappedChestTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
   private static final ResourceLocation TEXTURE_TRAPPED_DOUBLE = new ResourceLocation("textures/entity/chest/trapped_double.png");
   private static final ResourceLocation TEXTURE_CHRISTMAS_DOUBLE = new ResourceLocation("textures/entity/chest/christmas_double.png");
   private static final ResourceLocation TEXTURE_NORMAL_DOUBLE = new ResourceLocation("textures/entity/chest/normal_double.png");
   private static final ResourceLocation TEXTURE_TRAPPED = new ResourceLocation("textures/entity/chest/trapped.png");
   private static final ResourceLocation TEXTURE_CHRISTMAS = new ResourceLocation("textures/entity/chest/christmas.png");
   private static final ResourceLocation TEXTURE_NORMAL = new ResourceLocation("textures/entity/chest/normal.png");
   private static final ResourceLocation field_199348_i = new ResourceLocation("textures/entity/chest/ender.png");
   private final ChestModel simpleChest = new ChestModel();
   private final ChestModel largeChest = new LargeChestModel();
   private boolean isChristmas;

   public ChestTileEntityRenderer() {
      Calendar calendar = Calendar.getInstance();
      if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
         this.isChristmas = true;
      }

   }

   public void render(T tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
      GlStateManager.enableDepthTest();
      GlStateManager.depthFunc(515);
      GlStateManager.depthMask(true);
      BlockState blockstate = tileEntityIn.hasWorld() ? tileEntityIn.getBlockState() : Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
      ChestType chesttype = blockstate.has(ChestBlock.TYPE) ? blockstate.get(ChestBlock.TYPE) : ChestType.SINGLE;
      if (chesttype != ChestType.LEFT) {
         boolean flag = chesttype != ChestType.SINGLE;
         ChestModel chestmodel = this.func_199347_a(tileEntityIn, destroyStage, flag);
         if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(flag ? 8.0F : 4.0F, 4.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
         } else {
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         GlStateManager.pushMatrix();
         GlStateManager.enableRescaleNormal();
         GlStateManager.translatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
         GlStateManager.scalef(1.0F, -1.0F, -1.0F);
         float f = blockstate.get(ChestBlock.FACING).getHorizontalAngle();
         if ((double)Math.abs(f) > 1.0E-5D) {
            GlStateManager.translatef(0.5F, 0.5F, 0.5F);
            GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
            GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
         }

         this.applyLidRotation(tileEntityIn, partialTicks, chestmodel);
         chestmodel.renderAll();
         GlStateManager.disableRescaleNormal();
         GlStateManager.popMatrix();
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
         }

      }
   }

   private ChestModel func_199347_a(T p_199347_1_, int p_199347_2_, boolean p_199347_3_) {
      ResourceLocation resourcelocation;
      if (p_199347_2_ >= 0) {
         resourcelocation = DESTROY_STAGES[p_199347_2_];
      } else if (this.isChristmas) {
         resourcelocation = p_199347_3_ ? TEXTURE_CHRISTMAS_DOUBLE : TEXTURE_CHRISTMAS;
      } else if (p_199347_1_ instanceof TrappedChestTileEntity) {
         resourcelocation = p_199347_3_ ? TEXTURE_TRAPPED_DOUBLE : TEXTURE_TRAPPED;
      } else if (p_199347_1_ instanceof EnderChestTileEntity) {
         resourcelocation = field_199348_i;
      } else {
         resourcelocation = p_199347_3_ ? TEXTURE_NORMAL_DOUBLE : TEXTURE_NORMAL;
      }

      this.bindTexture(resourcelocation);
      return p_199347_3_ ? this.largeChest : this.simpleChest;
   }

   private void applyLidRotation(T p_199346_1_, float p_199346_2_, ChestModel p_199346_3_) {
      float f = ((IChestLid)p_199346_1_).getLidAngle(p_199346_2_);
      f = 1.0F - f;
      f = 1.0F - f * f * f;
      p_199346_3_.getLid().rotateAngleX = -(f * ((float)Math.PI / 2F));
   }
}