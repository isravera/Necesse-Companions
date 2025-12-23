package necessecompanions;

import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.recipe.Tech;
import necessecompanions.mobs.*;
import necessecompanions.utils.CustomRecipes;
import necessecompanions.utils.InitRegistry;

@ModEntry
public class ModEntryPoint {
    public static Buff ALL_DAMAGE_BUFF;
    public static Buff ARMOR_BUFF;
    public static Buff ARMOR_PENETRATION_BUFF;
    public static Buff ATTACK_SPEED_BUFF;
    public static Buff CRITICAL_CHANCE_BUFF;
    public static Buff CRITICAL_DAMAGE_BUFF;
    public static Buff MAX_HEALTH_BUFF;
    public static Buff MAX_MANA_BUFF;
    public static Buff MAX_RESILIENCE_BUFF;
    public static Buff SPEED_BUFF;
    public static Buff SWIM_SPEED_BUFF;

    public static Tech PET_ALTAR_STONE;
    public static Tech PET_ALTAR_DEMONIC;
    public static Tech PET_ALTAR_TUNGSTEN;

    public void init() {
        InitRegistry.registerObjects();
        InitRegistry.registerBuffs();
        InitRegistry.registerTechs();
        InitRegistry.registerCustomCategories();
        InitRegistry.registerIngredients();
        InitRegistry.registerItems();
        InitRegistry.registerMobs();
    }

    public void initResources() {
        AxolotlPetMob.texture = GameTexture.fromFile("mobs/axolotl_pet");
        AxolotlPetMob.hasMultipleSprites = false;

        BeaverPetMob.texture = GameTexture.fromFile("mobs/beaver_pet");
        BeaverPetMob.hasMultipleSprites = false;

        BeetPetMob.texture = MobRegistry.Textures.beetCroppler.body;
        BeetPetMob.hasMultipleSprites = true;

        CalfPetMob.texture = MobRegistry.Textures.calf;
        CalfPetMob.hasMultipleSprites = true;

        CapybaraPetMob.texture = GameTexture.fromFile("mobs/capybara_pet");
        CapybaraPetMob.hasMultipleSprites = false;

        ChameleonPetMob.texture = GameTexture.fromFile("mobs/chameleon_pet");
        ChameleonPetMob.hasMultipleSprites = false;

        ChickPetMob.texture = MobRegistry.Textures.chick;
        ChickPetMob.hasMultipleSprites = true;

        DeerPetMob.texture = GameTexture.fromFile("mobs/deer_pet");
        DeerPetMob.hasMultipleSprites = false;

        DinosaurPetMob.texture = GameTexture.fromFile("mobs/dinosaur_pet");
        DinosaurPetMob.hasMultipleSprites = false;

        DoePetMob.texture = GameTexture.fromFile("mobs/doe_pet");
        DoePetMob.hasMultipleSprites = false;

        DuckPetMob.texture = MobRegistry.Textures.duck.body;
        DuckPetMob.hasMultipleSprites = true;

        FerretPetMob.texture = GameTexture.fromFile("mobs/ferret_pet");
        FerretPetMob.hasMultipleSprites = false;

        FoxCubPetMob.texture = GameTexture.fromFile("mobs/fox_cub_pet");
        FoxCubPetMob.hasMultipleSprites = false;

        GoatPetMob.texture = GameTexture.fromFile("mobs/goat_pet");
        GoatPetMob.hasMultipleSprites = true;

        HoneyBeePetMob.texture = MobRegistry.Textures.honeyBee.body;
        HoneyBeePetMob.hasMultipleSprites = true;

        LambPetMob.texture = MobRegistry.Textures.lamb;
        LambPetMob.hasMultipleSprites = true;

        OctopusPetMob.texture = GameTexture.fromFile("mobs/octopus_pet");
        OctopusPetMob.hasMultipleSprites = false;

        PeacockPetMob.texture = GameTexture.fromFile("mobs/peacock_pet");
        PeacockPetMob.hasMultipleSprites = true;

        PenguinPetMob.texture = MobRegistry.Textures.penguin;
        PenguinPetMob.hasMultipleSprites = true;

        PhoenixPetMob.texture = GameTexture.fromFile("mobs/phoenix_pet");
        PhoenixPetMob.hasMultipleSprites = false;

        PigletPetMob.texture = MobRegistry.Textures.piglet;
        PigletPetMob.hasMultipleSprites = true;

        PolarBearPetMob.texture = GameTexture.fromFile("mobs/polar_bear_pet");
        PolarBearPetMob.hasMultipleSprites = true;

        PorcupinePetMob.texture = GameTexture.fromFile("mobs/porcupine_pet");
        PorcupinePetMob.hasMultipleSprites = true;

        RaccoonPetMob.texture = GameTexture.fromFile("mobs/raccoon_pet");
        RaccoonPetMob.hasMultipleSprites = false;

        RadioactiveCatPetMob.texture = GameTexture.fromFile("mobs/radioactive_cat_pet");
        RadioactiveCatPetMob.hasMultipleSprites = true;

        RedPandaPetMob.texture = GameTexture.fromFile("mobs/red_panda_pet");
        RedPandaPetMob.hasMultipleSprites = false;

        SnowHarePetMob.texture = MobRegistry.Textures.snowHare;
        SnowHarePetMob.hasMultipleSprites = true;

        SquirrelPetMob.texture = MobRegistry.Textures.squirrel;
        SquirrelPetMob.hasMultipleSprites = true;

        StabbyBushPetMob.texture = MobRegistry.Textures.stabbyBush.body;
        StabbyBushPetMob.hasMultipleSprites = true;

        TurkeyPetMob.texture = GameTexture.fromFile("mobs/turkey_pet");
        TurkeyPetMob.hasMultipleSprites = true;

        TurtlePetMob.texture = MobRegistry.Textures.turtle.body;
        TurtlePetMob.hasMultipleSprites = true;

        WolfCubPetMob.texture = GameTexture.fromFile("mobs/wolf_cub_pet");
        WolfCubPetMob.hasMultipleSprites = false;
    }

    public void postInit() {
        CustomRecipes.registerIngredients();
        CustomRecipes.registerObjects();
        CustomRecipes.registerTier1Companions();
        CustomRecipes.registerTier2Companions();
        CustomRecipes.registerTier3Companions();
    }
}