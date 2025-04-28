package necessecompanions.utils;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.registries.*;
import necesse.inventory.item.Item.Rarity;
import necesse.inventory.item.ItemCategory;
import necessecompanions.ModEntryPoint;
import necessecompanions.buffs.*;
import necessecompanions.items.PetCraftItem;
import necessecompanions.items.PetSummoningItem;
import necessecompanions.mobs.*;
import necessecompanions.objects.PetAltarObject;

public class InitRegistry {

    public static void registerObjects() {
        ObjectRegistry.registerObject("stone_pet_altar", new PetAltarObject("stone"), 20, true);
        ObjectRegistry.registerObject("demonic_pet_altar", new PetAltarObject("demonic"), 45, true);
        ObjectRegistry.registerObject("tungsten_pet_altar", new PetAltarObject("tungsten"), 250, true);
    }

    public static void registerBuffs() {
        ModEntryPoint.ALL_DAMAGE_BUFF = BuffRegistry.registerBuff("all_damage_buff", new AllDamageBuff());
        ModEntryPoint.ARMOR_BUFF = BuffRegistry.registerBuff("armor_buff", new ArmorBuff());
        ModEntryPoint.ARMOR_PENETRATION_BUFF = BuffRegistry.registerBuff("armor_penetration_buff", new ArmorPenetrationBuff());
        ModEntryPoint.ATTACK_SPEED_BUFF = BuffRegistry.registerBuff("attack_speed_buff", new AttackSpeedBuff());
        ModEntryPoint.CRITICAL_CHANCE_BUFF = BuffRegistry.registerBuff("critical_chance_buff", new CriticalChanceBuff());
        ModEntryPoint.CRITICAL_DAMAGE_BUFF = BuffRegistry.registerBuff("critical_damage_buff", new CriticalDamageBuff());
        ModEntryPoint.MAX_HEALTH_BUFF = BuffRegistry.registerBuff("max_health_buff", new MaxHealthBuff());
        ModEntryPoint.MAX_MANA_BUFF = BuffRegistry.registerBuff("max_mana_buff", new MaxManaBuff());
        ModEntryPoint.MAX_RESILIENCE_BUFF = BuffRegistry.registerBuff("max_resilience_buff", new MaxResilienceBuff());
        ModEntryPoint.SPEED_BUFF = BuffRegistry.registerBuff("speed_buff", new SpeedBuff());
        ModEntryPoint.SWIM_SPEED_BUFF = BuffRegistry.registerBuff("swim_speed_buff", new SwimSpeedBuff());
    }

    public static void registerIngredients() {
        ItemRegistry.registerItem("pet_certificate", new PetCraftItem("pet_certificate_tip"), 90.0F, true);
        ItemRegistry.registerItem("pet_food", new PetCraftItem("pet_food_tip"), 40.0F, true);
        ItemRegistry.registerItem("pet_food_meat", new PetCraftItem("pet_food_tip"), 40.0F, true);
        ItemRegistry.registerItem("pet_food_fruits", new PetCraftItem("pet_food_tip"), 40.0F, true);
    }

    public static void registerTechs() {
        ModEntryPoint.PET_ALTAR_STONE = RecipeTechRegistry.registerTech("stone_pet_tech", "stone_pet_altar");
        ModEntryPoint.PET_ALTAR_DEMONIC = RecipeTechRegistry.registerTech("demonic_pet_tech", "demonic_pet_altar");
        ModEntryPoint.PET_ALTAR_TUNGSTEN = RecipeTechRegistry.registerTech("tungsten_pet_tech", "tungsten_pet_altar");
    }

    public static void registerCustomCategories() {
        ItemCategory.createCategory("A-A-A", CustomCategories.Ingredients);
        ItemCategory.createCategory("A-A-A", CustomCategories.baseCategory);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.allDamage);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.armor);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.arpen);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.attackspeed);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.critchance);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.critdamage);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.maxhealth);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.maxmana);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.maxresilience);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.speed);
        ItemCategory.createCategory("A-B-A", CustomCategories.baseCategory, CustomCategories.swimspeed);

        ItemCategory.craftingManager.createCategory("A-A-A", InitRegistry.getCategory(0), CustomCategories.Ingredients);
        ItemCategory.craftingManager.createCategory("A-B-A", InitRegistry.getCategory(1), CustomCategories.AllDamage);
        ItemCategory.craftingManager.createCategory("A-B-B", InitRegistry.getCategory(2), CustomCategories.Armor);
        ItemCategory.craftingManager.createCategory("A-B-C", InitRegistry.getCategory(3), CustomCategories.ArmorPenetration);
        ItemCategory.craftingManager.createCategory("A-B-D", InitRegistry.getCategory(4), CustomCategories.AttackSpeed);
        ItemCategory.craftingManager.createCategory("A-B-E", InitRegistry.getCategory(5), CustomCategories.CriticalChance);
        ItemCategory.craftingManager.createCategory("A-B-F", InitRegistry.getCategory(6), CustomCategories.CriticalDamage);
        ItemCategory.craftingManager.createCategory("A-B-G", InitRegistry.getCategory(7), CustomCategories.MaxHealth);
        ItemCategory.craftingManager.createCategory("A-B-H", InitRegistry.getCategory(8), CustomCategories.MaxMana);
        ItemCategory.craftingManager.createCategory("A-B-I", InitRegistry.getCategory(9), CustomCategories.MaxResilience);
        ItemCategory.craftingManager.createCategory("A-B-J", InitRegistry.getCategory(10), CustomCategories.Speed);
        ItemCategory.craftingManager.createCategory("A-B-K", InitRegistry.getCategory(11), CustomCategories.SwimSpeed);
    }

    public static void registerItems() {

        final float VENDOR_PRICE = 35.0F;

        ItemRegistry.registerItem("axolotl_pet", new PetSummoningItem("axolotl_pet", CustomCategories.SwimSpeed), VENDOR_PRICE, true);
        ItemRegistry.registerItem("beaver_pet", new PetSummoningItem("beaver_pet", CustomCategories.MaxResilience), VENDOR_PRICE, true);
        ItemRegistry.registerItem("beet_pet", new PetSummoningItem("beet_pet", CustomCategories.MaxHealth), VENDOR_PRICE, true);
        ItemRegistry.registerItem("calf_pet", new PetSummoningItem("calf_pet", CustomCategories.Armor), VENDOR_PRICE, true);
        ItemRegistry.registerItem("capybara_pet", new PetSummoningItem("capybara_pet", CustomCategories.MaxMana), VENDOR_PRICE, true);
        ItemRegistry.registerItem("chameleon_pet", new PetSummoningItem("chameleon_pet", CustomCategories.critdamage), VENDOR_PRICE, true);
        ItemRegistry.registerItem("chick_pet", new PetSummoningItem("chick_pet", CustomCategories.Armor), VENDOR_PRICE, true);
        ItemRegistry.registerItem("dinosaur_pet", new PetSummoningItem("dinosaur_pet", CustomCategories.maxresilience), VENDOR_PRICE, true);
        ItemRegistry.registerItem("ferret_pet", new PetSummoningItem("ferret_pet", CustomCategories.AttackSpeed), VENDOR_PRICE, true);
        ItemRegistry.registerItem("honey_bee_pet", new PetSummoningItem("honey_bee_pet", CustomCategories.AttackSpeed), VENDOR_PRICE, true);
        ItemRegistry.registerItem("lamb_pet", new PetSummoningItem("lamb_pet", CustomCategories.Armor), VENDOR_PRICE, true);
        ItemRegistry.registerItem("octopus_pet", new PetSummoningItem("octopus_pet", CustomCategories.SwimSpeed), VENDOR_PRICE, true);
        ItemRegistry.registerItem("peacock_pet", new PetSummoningItem("peacock_pet", CustomCategories.AllDamage), VENDOR_PRICE, true);
        ItemRegistry.registerItem("phoenix_pet", new PetSummoningItem("phoenix_pet", CustomCategories.CriticalDamage), VENDOR_PRICE, true);
        ItemRegistry.registerItem("piglet_pet", new PetSummoningItem("piglet_pet", CustomCategories.Armor), VENDOR_PRICE, true);
        ItemRegistry.registerItem("polar_bear_pet", new PetSummoningItem("polar_bear_pet", CustomCategories.MaxResilience), VENDOR_PRICE, true);
        ItemRegistry.registerItem("porcupine_pet", new PetSummoningItem("porcupine_pet", CustomCategories.ArmorPenetration), VENDOR_PRICE, true);
        ItemRegistry.registerItem("radioactive_cat_pet", new PetSummoningItem("radioactive_cat_pet", CustomCategories.ArmorPenetration), VENDOR_PRICE, true);
        ItemRegistry.registerItem("raccoon_pet", new PetSummoningItem("raccoon_pet", CustomCategories.AttackSpeed), VENDOR_PRICE, true);
        ItemRegistry.registerItem("red_panda_pet", new PetSummoningItem("red_panda_pet", CustomCategories.CriticalChance), VENDOR_PRICE, true);
        ItemRegistry.registerItem("stabby_bush_pet", new PetSummoningItem("stabby_bush_pet", CustomCategories.CriticalChance), VENDOR_PRICE, true);
        ItemRegistry.registerItem("turkey_pet", new PetSummoningItem("turkey_pet", CustomCategories.MaxHealth), VENDOR_PRICE, true);
        ItemRegistry.registerItem("turtle_pet", new PetSummoningItem("turtle_pet", CustomCategories.MaxMana), VENDOR_PRICE, true);
        ItemRegistry.registerItem("wolf_cub_pet", new PetSummoningItem("wolf_cub_pet", CustomCategories.AllDamage), VENDOR_PRICE, true);
    }

    public static void registerMobs() {

        //All Damage
        MobRegistry.registerMob("peacock_pet", PeacockPetMob.class, false);
        MobRegistry.registerMob("wolf_cub_pet", WolfCubPetMob.class, false);
        //Armor
        MobRegistry.registerMob("calf_pet", CalfPetMob.class, false);
        MobRegistry.registerMob("chick_pet", ChickPetMob.class, false);
        MobRegistry.registerMob("lamb_pet", LambPetMob.class, false);
        MobRegistry.registerMob("piglet_pet", PigletPetMob.class, false);
        //Armor Penetration
        MobRegistry.registerMob("porcupine_pet", PorcupinePetMob.class, false);
        MobRegistry.registerMob("radioactive_cat_pet", RadioactiveCatPetMob.class, false);
        //Attack Speed
        MobRegistry.registerMob("ferret_pet", FerretPetMob.class, false);
        MobRegistry.registerMob("honey_bee_pet", HoneyBeePetMob.class, false);
        MobRegistry.registerMob("raccoon_pet", RaccoonPetMob.class, false);
        //Critical Chance
        MobRegistry.registerMob("red_panda_pet", RedPandaPetMob.class, false);
        MobRegistry.registerMob("stabby_bush_pet", StabbyBushPetMob.class, false);
        //Critical Damage
        MobRegistry.registerMob("chameleon_pet", ChameleonPetMob.class, false);
        MobRegistry.registerMob("phoenix_pet", PhoenixPetMob.class, false);
        //Max Health
        MobRegistry.registerMob("beet_pet", BeetPetMob.class, false);
        MobRegistry.registerMob("turkey_pet", TurkeyPetMob.class, false);
        //Max Mana
        MobRegistry.registerMob("capybara_pet", CapybaraPetMob.class, false);
        MobRegistry.registerMob("turtle_pet", TurtlePetMob.class, false);
        //Max Resilience
        MobRegistry.registerMob("beaver_pet", BeaverPetMob.class, false);
        MobRegistry.registerMob("dinosaur_pet", DinosaurPetMob.class, false);
        MobRegistry.registerMob("polar_bear_pet", PolarBearPetMob.class, false);
        //Speed
        //Swim Speed
        MobRegistry.registerMob("axolotl_pet", AxolotlPetMob.class, false);
        MobRegistry.registerMob("octopus_pet", OctopusPetMob.class, false);

    }

    public static GameMessage getCategory(int number) {
        return new LocalMessage("global", "category" + number);
    }
}
