package nightkosh.gravestone_extended.core.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import nightkosh.gravestone.core.proxy.ProxyHelper;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.block.enums.*;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.core.ResourcesModels;
import nightkosh.gravestone_extended.core.event.RenderEventHandler;
import nightkosh.gravestone_extended.entity.EntityRaven;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.entity.monster.*;
import nightkosh.gravestone_extended.entity.monster.EntitySkullCrawler.SkullCrawlerType;
import nightkosh.gravestone_extended.gui.GSGraveTextGui;
import nightkosh.gravestone_extended.item.ItemGSMonsterPlacer;
import nightkosh.gravestone_extended.models.entity.ModelUndeadCat;
import nightkosh.gravestone_extended.models.entity.ModelUndeadDog;
import nightkosh.gravestone_extended.renderer.entity.*;
import nightkosh.gravestone_extended.renderer.tileentity.*;
import nightkosh.gravestone_extended.tileentity.*;
import org.apache.commons.lang3.StringUtils;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        // blocks renderers
        registerBlocksRenderers();

        // Mobs renderers
        registerMobsRenderers();
    }

    //TODO ???
    private void registerBlocksRenderers() {
        // register GraveStone renderer
        ClientRegistry.registerTileEntity(TileEntityMemorial.class, "GSMemorial", new TileEntityMemorialRenderer());
        ClientRegistry.registerTileEntity(TileEntityMemorial.Obelisk.class, "GSMemorialObelisk", new TileEntityMemorialRenderer.Obelisk());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CelticCross.class, "GSMemorialCelticCross", new TileEntityMemorialRenderer.CelticCross());
        ClientRegistry.registerTileEntity(TileEntityMemorial.SteveStatue.class, "GSMemorialSteveStatue", new TileEntityMemorialRenderer.SteveStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.VillagerStatue.class, "GSMemorialVillagerStatue", new TileEntityMemorialRenderer.VillagerStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.AngelStatue.class, "GSMemorialAngelStatue", new TileEntityMemorialRenderer.AngelStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.DogStatue.class, "GSMemorialDogStatue", new TileEntityMemorialRenderer.DogStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CatStatue.class, "GSMemorialCatStatue", new TileEntityMemorialRenderer.CatStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CreeperStatue.class, "GSMemorialCreeperStatue", new TileEntityMemorialRenderer.CreeperStatue());

        // spawner renderer
        ClientRegistry.registerTileEntity(TileEntitySpawner.class, "GSSpawner", new TileEntitySpawnerRenderer());
        ClientRegistry.registerTileEntity(TileEntitySpawner.Skeleton.class, "GSSpawnerSkeleton", new TileEntitySpawnerRenderer.Skeleton());
        ClientRegistry.registerTileEntity(TileEntitySpawner.Zombie.class, "GSSpawnerZombie", new TileEntitySpawnerRenderer.Zombie());

        // register HauntedChest renderer
        ClientRegistry.registerTileEntity(TileEntityHauntedChest.class, "GSHauntedChest", new TileEntityHauntedChestRenderer());

        // register SkullCandle renderer
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.class, "GSSkullCandle", new TileEntitySkullCandleRenderer());
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.Zombie.class, "GSSkullCandleZombie", new TileEntitySkullCandleRenderer.Zombie());
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.Wither.class, "GSSkullCandleWither", new TileEntitySkullCandleRenderer.Wither());

        // candle
        ClientRegistry.registerTileEntity(TileEntityCandle.class, "GSCandle", new TileEntityCandleRenderer());

        // pile of bones
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.class, "GSPileOfBones", new TileEntityPileOfBonesRenderer());
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.Skull.class, "GSPileOfBonesSkull", new TileEntityPileOfBonesRenderer.Skull());
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.Crawler.class, "GSPileOfBonesCrawler", new TileEntityPileOfBonesRenderer.Crawler());

        // corpses
//        MinecraftForgeClient.registerItemRenderer(Item.corpse, new ItemGSCorpseRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TileEntityRenderAltar());
    }

    private void registerMobsRenderers() {
        // zombie dog
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieDog.class, new RenderUndeadDog(Minecraft.getMinecraft().getRenderManager(), new ModelUndeadDog(), new ModelUndeadDog()));

        // zombie cat
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieCat.class, new RenderUndeadCat(Minecraft.getMinecraft().getRenderManager(), new ModelUndeadCat(), 0));

        // skeleton dog
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonDog.class, new RenderUndeadDog(Minecraft.getMinecraft().getRenderManager(), new ModelUndeadDog(), new ModelUndeadDog()));

        // zombie cat
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonCat.class, new RenderUndeadCat(Minecraft.getMinecraft().getRenderManager(), new ModelUndeadCat(), 0));

        // skull crawler
        RenderingRegistry.registerEntityRenderingHandler(EntitySkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.skeleton, Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.wither, Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.zombie, Minecraft.getMinecraft().getRenderManager()));

        // Skeleton
        RenderingRegistry.registerEntityRenderingHandler(EntityGSSkeleton.class, new RenderGSSkeleton(Minecraft.getMinecraft().getRenderManager()));
        // Horses
        RenderingRegistry.registerEntityRenderingHandler(EntityUndeadHorse.class, new RenderUndeadHorse(Minecraft.getMinecraft().getRenderManager(), new ModelHorse(), 0));

        // raven
        RenderingRegistry.registerEntityRenderingHandler(EntityRaven.class, new RenderRaven(Minecraft.getMinecraft().getRenderManager()));

        // Spawner Helper
        RenderingRegistry.registerEntityRenderingHandler(EntityGroupOfGravesMobSpawnerHelper.class, new RenderSpawnerHelper(Minecraft.getMinecraft().getRenderManager()));
    }

    @Override
    public String getLocalizedString(String str) {
        String localizedString = null;
        try {
            localizedString = LanguageRegistry.instance().getStringLocalization(str);
        } catch (Exception e) {
        }
        if (StringUtils.isBlank(localizedString)) {
            return LanguageRegistry.instance().getStringLocalization(str, "en_US");
        } else {
            return localizedString;
        }
    }

    @Override
    public String getLocalizedEntityName(String name) {
        return StatCollector.translateToLocal(name);
    }

    @Override
    public void openGraveTextGui(TileEntityGrave tileEntity) {
        FMLClientHandler.instance().getClient().displayGuiScreen(new GSGraveTextGui(tileEntity));
    }

    @Override
    public void registerHandlers() {
        MinecraftForge.EVENT_BUS.register(new RenderEventHandler());
    }

    @Override
    public void registerBlocksModels() {
        //memorials
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_CROSS.ordinal(), EnumMemorials.ICE_CROSS.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_OBELISK.ordinal(), EnumMemorials.ICE_OBELISK.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.Obelisk.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_CELTIC_CROSS.ordinal(), EnumMemorials.ICE_CELTIC_CROSS.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.CelticCross.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_STEVE_STATUE.ordinal(), EnumMemorials.ICE_STEVE_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.SteveStatue.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_VILLAGER_STATUE.ordinal(), EnumMemorials.ICE_VILLAGER_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.VillagerStatue.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_ANGEL_STATUE.ordinal(), EnumMemorials.ICE_ANGEL_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.AngelStatue.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_DOG_STATUE.ordinal(), EnumMemorials.ICE_DOG_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.DogStatue.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_CAT_STATUE.ordinal(), EnumMemorials.ICE_CAT_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.CatStatue.class);
        ProxyHelper.registerModelsForTEBlocks(EnumMemorials.WOODEN_CREEPER_STATUE.ordinal(), EnumMemorials.ICE_CREEPER_STATUE.ordinal(), GSBlock.memorial, ResourcesModels.memorialModel, TileEntityMemorial.CreeperStatue.class);
        //spawners
        ProxyHelper.registerModelsForTEBlocks(EnumSpawner.WITHER_SPAWNER.ordinal(), GSBlock.spawner, ResourcesModels.spawnerModel, TileEntitySpawner.class);
        ProxyHelper.registerModelsForTEBlocks(EnumSpawner.SKELETON_SPAWNER.ordinal(), GSBlock.spawner, ResourcesModels.spawnerModel, TileEntitySpawner.Skeleton.class);
        ProxyHelper.registerModelsForTEBlocks(EnumSpawner.ZOMBIE_SPAWNER.ordinal(), GSBlock.spawner, ResourcesModels.spawnerModel, TileEntitySpawner.Zombie.class);
        //traps
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.trap), EnumTrap.NIGHT_STONE.ordinal(), ResourcesModels.nightStoneModel);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.trap), EnumTrap.THUNDER_STONE.ordinal(), ResourcesModels.thunderStoneModel);
        ModelBakery.addVariantName(Item.getItemFromBlock(GSBlock.trap), "gravestone:GSTrap_night_stone", "gravestone:GSTrap_thunder_stone");
        //piles of bones
        ProxyHelper.registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES.ordinal(), GSBlock.pileOfBones, ResourcesModels.pileOfBonesModel, TileEntityPileOfBones.class);
        ProxyHelper.registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES_WITH_SKULL.ordinal(), GSBlock.pileOfBones, ResourcesModels.pileOfBonesModel, TileEntityPileOfBones.Skull.class);
        ProxyHelper.registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER.ordinal(), GSBlock.pileOfBones, ResourcesModels.pileOfBonesModel, TileEntityPileOfBones.Crawler.class);
        //bone blocks
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneBlock), EnumBoneBlock.BONE_BLOCK.ordinal(), ResourcesModels.boneBlockModel);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneBlock), EnumBoneBlock.SKULL_BONE_BLOCK.ordinal(), ResourcesModels.boneBlockWithSkullModel);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneBlock), EnumBoneBlock.CRAWLER_BONE_BLOCK.ordinal(), ResourcesModels.boneBlockModel);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneBlock), EnumBoneBlock.CRAWLER_SKULL_BONE_BLOCK.ordinal(), ResourcesModels.boneBlockWithSkullModel);
        ModelBakery.addVariantName(Item.getItemFromBlock(GSBlock.boneBlock), "gravestone:GSBoneBlock", "gravestone:GSBoneBlock_with_skull",
                "gravestone:GSBoneBlock", "gravestone:GSBoneBlock_with_skull");

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneSlab), 0, ResourcesModels.boneSlabModel);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.boneStairs), 0, ResourcesModels.boneStairsModel);
        //haunted chest
        ProxyHelper.registerModelsForTEBlocks(0, EnumHauntedChest.values().length - 1, GSBlock.hauntedChest, ResourcesModels.hauntedChestModel, TileEntityHauntedChest.class);
        //altar
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.altar), 0, ResourcesModels.altarModel);

        //candle
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(GSBlock.candle), 0, ResourcesModels.candleModel);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(GSBlock.candle), 0, TileEntityCandle.class);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.candle), 0, ResourcesModels.candleModel);
        //skull candle
        ProxyHelper.registerModelsForTEBlocks(EnumSkullCandle.SKELETON_SKULL.ordinal(), GSBlock.skullCandle, ResourcesModels.skullCandleModel, TileEntitySkullCandle.class);
        ProxyHelper.registerModelsForTEBlocks(EnumSkullCandle.WITHER_SKULL.ordinal(), GSBlock.skullCandle, ResourcesModels.skullCandleModel, TileEntitySkullCandle.Wither.class);
        ProxyHelper.registerModelsForTEBlocks(EnumSkullCandle.ZOMBIE_SKULL.ordinal(), GSBlock.skullCandle, ResourcesModels.skullCandleModel, TileEntitySkullCandle.Zombie.class);
    }

    @Override
    public void registerItemsModels() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(GSItem.chisel, 0, ResourcesModels.chiselModel);

//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExtendedItem.corpse, EnumCorpse.VILLAGER.ordinal(), ResourcesModels.CORPSE_VILLAGER);
//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExtendedItem.corpse, EnumCorpse.DOG.ordinal(), ResourcesModels.CORPSE_DOG);
//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExtendedItem.corpse, EnumCorpse.CAT.ordinal(), ResourcesModels.CORPSE_CAT);
//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExtendedItem.corpse, EnumCorpse.HORSE.ordinal(), ResourcesModels.CORPSE_HORSE);
//        ModelBakery.addVariantName(ExtendedItem.corpse, "nightkosh.gravestone-extended:GSCorpseVillager", "nightkosh.gravestone-extended:GSCorpseDog", "nightkosh.gravestone-extended:GSCorpseCat", "nightkosh.gravestone-extended:GSCorpseHorse");

        for (ItemGSMonsterPlacer.EnumEggs egg : ItemGSMonsterPlacer.EnumEggs.values()) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(GSItem.spawnEgg, egg.ordinal(), ResourcesModels.spawnEggModel);
        }
    }
}
