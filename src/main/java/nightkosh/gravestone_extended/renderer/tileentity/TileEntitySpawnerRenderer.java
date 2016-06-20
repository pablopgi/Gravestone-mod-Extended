package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.renderer.tileentity.TileEntityRenderer;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.models.block.ModelSpawnerPentagram;
import nightkosh.gravestone_extended.tileentity.TileEntityGSSpawner;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class TileEntitySpawnerRenderer extends TileEntityRenderer {

    private static ModelSpawnerPentagram witherSpawnerModel = new ModelSpawnerPentagram(Resources.WITHER_SKULL_CANDLE);
    private static ModelSpawnerPentagram skeletonSpawnerModel = new ModelSpawnerPentagram(Resources.SKELETON_SKULL_CANDLE);
    private static ModelSpawnerPentagram zombieSpawnerModel = new ModelSpawnerPentagram(Resources.ZOMBIE_SKULL_CANDLE);

    public static TileEntitySpawnerRenderer instance;

    private static final TileEntityGSSpawner SPAWNER_TE = new TileEntityGSSpawner();//TODO temporal hack

    public TileEntitySpawnerRenderer() {
        instance = this;
    }

    /**
     * Render a skull tile entity.
     */
    public void renderSpawnerPentagramAt(TileEntityGSSpawner tileEntity, float x, float y, float z, float par8) {
        this.bindTexture(Resources.PENTAGRAM);

        if (tileEntity == null) {//TODO temporal hack
            tileEntity = SPAWNER_TE;
        }
        GL11.glPushMatrix();
        if (tileEntity.getWorld() != null) {
            GL11.glTranslatef(x + 0.5F, y + 1.5F, z + 0.5F);
            GL11.glScalef(1, -1, -1);
        } else {
            GL11.glTranslatef(x + 0.5F, y + 1, z + 0.5F);
            GL11.glScalef(0.6F, -0.6F, -0.6F);
        }
        GL11.glTranslated(0, -0.01, 0);
        byte type = 0;//(byte) tileEntity.getBlockMetadata();//TODO ???
        EnumSpawner spawnerType = EnumSpawner.getById(type);
        ModelSpawnerPentagram spawner = getSpawnerModel(spawnerType);
        spawner.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par8, int par9) {
        this.renderSpawnerPentagramAt((TileEntityGSSpawner) tileEntity, (float) x, (float) y, (float) z, par8);
    }

    private static ModelSpawnerPentagram getSpawnerModel(EnumSpawner spawnerType) {
        switch (spawnerType) {
            case WITHER_SPAWNER:
                return witherSpawnerModel;
            case SKELETON_SPAWNER:
                return skeletonSpawnerModel;
            case ZOMBIE_SPAWNER:
            default:
                return zombieSpawnerModel;
        }
    }
}