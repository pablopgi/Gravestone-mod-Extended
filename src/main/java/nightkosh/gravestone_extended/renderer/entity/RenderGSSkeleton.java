package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import nightkosh.gravestone.models.entity.ModelGSSkeleton;

import java.util.Iterator;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderGSSkeleton extends RenderSkeleton {
    public RenderGSSkeleton(RenderManager renderManager) {
        super(renderManager);

        ModelGSSkeleton skeletonModel = new ModelGSSkeleton();
        this.mainModel = skeletonModel;
        Iterator it = this.layerRenderers.iterator();
        while (it.hasNext()) {
            Object layer = it.next();
            if (layer instanceof LayerCustomHead) {
                it.remove();
            }
        }
        this.addLayer(new LayerCustomHead(skeletonModel.bipedHead));
    }
}
