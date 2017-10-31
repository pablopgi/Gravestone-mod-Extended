package nightkosh.gravestone_extended.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockBoneSlab extends ItemBlock {

    public ItemBlockBoneSlab(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(GSBlock.BONE_SLAB.getRegistryName());
    }
}
