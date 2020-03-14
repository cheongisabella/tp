package seedu.kitchenhelper.storage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    public static final String OUTPUT_INGREDIENT = "./src/test/data/StorageTest/outputIngredient.txt";
    public static final String OUTPUT_RECIPE = "./src/test/data/StorageTest/outputRecipe.txt";
    public static final String OUTPUT_CHORE = "./src/test/data/StorageTest/outputChore.txt";
    public static final String NEW_OUTPUT_INGREDIENT = "./src/test/data/NewStorageTest/outputIngredient.txt";
    public static final String NEW_OUTPUT_RECIPE = "./src/test/data/NewStorageTest/outputRecipe.txt";
    public static final String NEW_OUTPUT_CHORE = "./src/test/data/NewStorageTest/outputChore.txt";

    public Storage storage = new Storage(OUTPUT_INGREDIENT, OUTPUT_RECIPE, OUTPUT_CHORE);;

    @Test
    void getIngredientDataTest() {
        try {
            Storage newStorage = new StubStorage();

            List<Ingredient> ingredients = storage.getIngredientData();
            List<Ingredient> stubIngredients = newStorage.getIngredientData();
            assertEquals(ingredients, stubIngredients);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    void getRecipeData() {
    }

    @Test
    void getChoreData() {
    }

    @Test
    void saveIngredientData() {
    }

    @Test
    void saveRecipeData() {
    }

    @Test
    void saveChoreData() {
    }

    private class StubStorage extends Storage {
        public StubStorage () {
            super(NEW_OUTPUT_INGREDIENT, NEW_OUTPUT_RECIPE, NEW_OUTPUT_CHORE);
        }

        @Override
        public ArrayList<Ingredient> getIngredientData() throws FileNotFoundException {
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            loadingIngredients("Beef", "meat", 3, 20.0, "2020-03-18",ingredients);
            loadingIngredients("Chicken", "meat", 3, 20.0, "2020-03-18", ingredients);
            return ingredients;
        }
    }
}