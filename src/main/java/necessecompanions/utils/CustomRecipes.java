package necessecompanions.utils;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necessecompanions.ModEntryPoint;

public class CustomRecipes {

    public static void registerIngredients() {
        Recipes.registerModRecipe(new Recipe(
            "pet_certificate",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            new Ingredient[]{
                new Ingredient("coin", 250)
            }
        ));

        Recipes.registerModRecipe(new Recipe(
            "pet_food",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            new Ingredient[]{
                new Ingredient("wheat", 5),
                new Ingredient("honey", 5)
            }
        ));

        Recipes.registerModRecipe(new Recipe(
            "pet_food_meat",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            new Ingredient[]{
                new Ingredient("wheat", 5),
                new Ingredient("anyrawmeat", 5)
            }
        ));

        Recipes.registerModRecipe(new Recipe(
            "pet_food_fruits",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            new Ingredient[]{
                new Ingredient("wheat", 5),
                new Ingredient("anyfruit", 5)
            }
        ));
    }

    public static void registerObjects() {
        Recipes.registerModRecipe(new Recipe(
            "stone_pet_altar", 1,
            RecipeTechRegistry.WORKSTATION,
            new Ingredient[]{
                new Ingredient("anystone", 10),
                new Ingredient("ironbar", 3)
            }
        ));

        Recipes.registerModRecipe(new Recipe(
            "demonic_pet_altar", 1,
            RecipeTechRegistry.DEMONIC_WORKSTATION,
            new Ingredient[]{
                new Ingredient("demonicbar", 5)
            }
        ));

        Recipes.registerModRecipe(new Recipe(
            "tungsten_pet_altar", 1,
            RecipeTechRegistry.TUNGSTEN_WORKSTATION,
            new Ingredient[]{
                new Ingredient("tungstenbar", 15)
            }
        ));
    }

    public static void registerTier1Companions() {
        Recipes.registerModRecipe(new Recipe(
            "axolotl_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "beet_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Fruits(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "calf_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "chick_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "octopus_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "lamb_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "piglet_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Default(2)
        ));

        Recipes.registerModRecipe(new Recipe(
            "turkey_pet",
            1,
            ModEntryPoint.PET_ALTAR_STONE,
            PetIngredients.Fruits(2)
        ));

    }

    public static void registerTier2Companions() {
        Recipes.registerModRecipe(new Recipe(
            "beaver_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "capybara_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "dinosaur_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Meat(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "ferret_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Default(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "honey_bee_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Default(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "polar_bear_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Meat(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "raccoon_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "red_panda_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "stabby_bush_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "turtle_pet",
            1,
            ModEntryPoint.PET_ALTAR_DEMONIC,
            PetIngredients.Fruits(3)
        ));

    }

    public static void registerTier3Companions() {
        Recipes.registerModRecipe(new Recipe(
            "chameleon_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Default(5)
        ));

        Recipes.registerModRecipe(new Recipe(
            "peacock_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Fruits(5)
        ));

        Recipes.registerModRecipe(new Recipe(
            "phoenix_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Default(5)
        ));

        Recipes.registerModRecipe(new Recipe(
            "porcupine_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Default(3)
        ));

        Recipes.registerModRecipe(new Recipe(
            "radioactive_cat_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Default(5)
        ));

        Recipes.registerModRecipe(new Recipe(
            "wolf_cub_pet",
            1,
            ModEntryPoint.PET_ALTAR_TUNGSTEN,
            PetIngredients.Meat(5)
        ));
    }
}
