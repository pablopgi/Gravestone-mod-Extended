package nightkosh.gravestone_extended.core;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.item.ItemFish;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ResourcesModels extends Resources {

    public static final String MOD_NAME = ModInfo.ID.toLowerCase();

    // MODEL RESOURCES
    public static final ModelResourceLocation chiselModel = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.CHISEL.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_SWORD = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_IRON = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_DIAMOND.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SHIELD = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SHIELD.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_FISHING_POLE = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_FISHING_POLE.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_HOE = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_HOE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_HOE_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_HOE_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_HOE_DIAMOND.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation CORPSE = new ModelResourceLocation(MOD_NAME + ":gscorpse", "inventory");

    public static final ModelResourceLocation SPAWN_EGG_MODEL = new ModelResourceLocation(GSItem.SPAWN_EGG.getRegistryName(), "inventory");

    public static final ModelResourceLocation TOXIC_SLIME = new ModelResourceLocation(GSItem.TOXIC_SLIME.getRegistryName(), "inventory");

    public static final ModelResourceLocation BLUE_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.BLUE_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation GREEN_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.GREEN_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation MAGMA_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.MAGMA_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation BONE_FISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.BONE_FISH.getName(), "inventory");

    public static final ModelResourceLocation MEMORIAL = new ModelResourceLocation(MOD_NAME + ":gsmemorial", "inventory");
    public static final ModelResourceLocation EXECUTION = new ModelResourceLocation(MOD_NAME + ":gsexecution", "inventory");
    public static final ModelResourceLocation SPAWNER = new ModelResourceLocation(MOD_NAME + ":gsspawner", "inventory");
    //trap
    public static final ModelResourceLocation NIGHT_STONE = new ModelResourceLocation(MOD_NAME + ":gstrap_night_stone", "inventory");
    public static final ModelResourceLocation THUNDER_STONE = new ModelResourceLocation(MOD_NAME + ":gstrap_thunder_stone", "inventory");

    public static final ModelResourceLocation PILE_OF_BONES = new ModelResourceLocation(MOD_NAME + ":gspileofbones", "inventory");
    //bone blocks
    public static final ModelResourceLocation BONE_BLOCK = new ModelResourceLocation(MOD_NAME + ":gsboneblock", "inventory");
    public static final ModelResourceLocation BONE_BLOCK_WITH_SKULL = new ModelResourceLocation(MOD_NAME + ":gsboneblock_with_skull", "inventory");

    public static final ModelResourceLocation BONE_SLAB = new ModelResourceLocation(MOD_NAME + ":gsboneslab", "inventory");
    public static final ModelResourceLocation BONE_STAIRS = new ModelResourceLocation(MOD_NAME + ":gsbonestairs", "inventory");

    public static final ModelResourceLocation HAUNTED_CHEST = new ModelResourceLocation(MOD_NAME + ":gshauntedchest", "inventory");
    public static final ModelResourceLocation CANDLE = new ModelResourceLocation(MOD_NAME + ":gscandle", "inventory");
    public static final ModelResourceLocation SKULL_CANDLE = new ModelResourceLocation(MOD_NAME + ":gsskullcandle", "inventory");
    public static final ModelResourceLocation ALTAR = new ModelResourceLocation(MOD_NAME + ":gsaltar", "inventory");
}
