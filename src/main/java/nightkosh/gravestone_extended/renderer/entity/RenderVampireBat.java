package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.bat.EntityVampireBat;
import nightkosh.gravestone_extended.models.entity.ModelHostileBat;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderVampireBat extends RenderLiving<EntityVampireBat> {

    public RenderVampireBat(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelHostileBat(), 0.25F);
    }

    @Override
    protected void preRenderCallback(EntityVampireBat entity, float partialTickTime) {
        GlStateManager.scale(0.35F, 0.35F, 0.35F);
    }

    @Override
    protected void applyRotations(EntityVampireBat entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        if (entityLiving.getIsBatHanging()) {
            GlStateManager.translate(0, -0.1F, 0);
        } else {
            GlStateManager.translate(0, MathHelper.cos(p_77043_2_ * 0.3F) * 0.1F, 0);
        }

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityVampireBat entity) {
        return Resources.VAMPIRE_BAT;
    }
}
