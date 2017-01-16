package nightkosh.gravestone_extended.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.Tabs;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;
import nightkosh.gravestone_extended.tileentity.TileEntityCorpse;

import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCorpse extends BlockContainer {

    public BlockCorpse() {
        super(Material.carpet);
        this.setUnlocalizedName("Corpse");
        this.setHardness(0);
        this.setCreativeTab(Tabs.otherItemsTab);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityCorpse();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        Minecraft.getMinecraft().theWorld.playerEntities.forEach(player -> {
            list.add(CorpseHelper.getDefaultPlayerCorpse(player.getGameProfile()));
        });
        for (int damage = 0; damage < EnumCorpse.values().length; damage++) {
            list.addAll(CorpseHelper.getDefaultCorpse(damage));
        }
    }
}