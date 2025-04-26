package necessecompanions.utils;

import necesse.inventory.recipe.Ingredient;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class PetIngredients {

    public static Ingredient[] Meat(int quantity, String... ingredient) {
        return Stream.concat(
                Arrays.stream(ingredient).filter(Objects::nonNull).map(s -> new Ingredient(s, quantity)),
                Stream.of(new Ingredient("pet_food_meat", quantity), new Ingredient("pet_certificate", 1))
        ).toArray(Ingredient[]::new);
    }

    public static Ingredient[] Fruits(int quantity, String... ingredient) {
        return Stream.concat(
                Arrays.stream(ingredient).filter(Objects::nonNull).map(s -> new Ingredient(s, quantity)),
                Stream.of(new Ingredient("pet_food_fruits", quantity), new Ingredient("pet_certificate", 1))
        ).toArray(Ingredient[]::new);
    }

    public static Ingredient[] Default(int quantity, String... ingredient) {
        return Stream.concat(
                Arrays.stream(ingredient).filter(Objects::nonNull).map(s -> new Ingredient(s, quantity)),
                Stream.of(new Ingredient("pet_food", quantity), new Ingredient("pet_certificate", 1))
        ).toArray(Ingredient[]::new);
    }
}
