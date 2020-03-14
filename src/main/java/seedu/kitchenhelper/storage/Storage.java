package seedu.kitchenhelper.storage;

import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.ingredient.Dairy;
import seedu.kitchenhelper.object.ingredient.Drink;
import seedu.kitchenhelper.object.ingredient.Fruit;
import seedu.kitchenhelper.object.ingredient.Meat;
import seedu.kitchenhelper.object.ingredient.Staple;
import seedu.kitchenhelper.object.ingredient.Vegetable;
import seedu.kitchenhelper.object.ingredient.Miscellaneous;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Storage class to get/load and store data.
 */
public class Storage {

    private String filePath;

    /**
     * Constructor for Storage.
     * @param filePath String of filepath for stored data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets the saved Ingredient data from text file.
     * @return ArrayList Contains data from saved text file
     * @throws FileNotFoundException If file from file path does not exists.
     */
    public ArrayList<Ingredient> getIngredientData() throws FileNotFoundException {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {

            String userData = scanner.nextLine();
            String[] getName = userData.split("/n ");
            String[] getCat = getName[1].split(" /c ");
            String[] getQuantity = getCat[1].split(" /q ");
            String[] getPrice = getQuantity[1].split(" /p ");
            String[] getExpiry = getPrice[1].split(" /e ");

            String name = getCat[0];
            String category =  getQuantity[0];
            Integer quantity = Integer.parseInt(getPrice[0]);
            Double price = Double.parseDouble(getExpiry[0]);
            String expiry = getExpiry[1];

            loadingIngredients(name, category, quantity, price, expiry, ingredientList);
        }
        return ingredientList;
    }

    /**
     * Loads the ingredient into the ArrayList according to the category type.
     *
     * @param name name of the ingredient.
     * @param category category of the ingredient.
     * @param quantity number of serving of ingredient.
     * @param price cost of the ingredient.
     * @param expiry ingredient expiry date.
     * @param ingredientList the ArrayList to store ingredients.
     */
    private void loadingIngredients(String name, String category, Integer quantity, Double price, String expiry,
                                    ArrayList<Ingredient> ingredientList) {

        switch (category) {
        case "Dairy":
            Ingredient diary = new Dairy(name, category, quantity, price, expiry);
            ingredientList.add(diary);
            break;
        case "Drink": {
            Ingredient drink = new Drink(name, category, quantity, price, expiry);
            ingredientList.add(drink);
            break;
        }
        case "Fruit": {
            Ingredient fruit = new Fruit(name, category, quantity, price, expiry);
            ingredientList.add(fruit);
            ;
            break;
        }
        case "Meat": {
            Ingredient meat = new Meat(name, category, quantity, price, expiry);
            ingredientList.add(meat);
            break;
        }
        case "Miscellaneous": {
            Ingredient miscellaneous = new Miscellaneous(name, category, quantity, price, expiry);
            ingredientList.add(miscellaneous);
            break;
        }
        case "Staple": {
            Ingredient staple = new Staple(name, category, quantity, price, expiry);
            ingredientList.add(staple);
            break;
        }
        case "Vegetable": {
            Ingredient vegetable = new Vegetable(name, category, quantity, price, expiry);
            ingredientList.add(vegetable);
            break;
        }
        default:
            throw new IllegalStateException("Unexpected value: " + category);
        }
    }

    /**
     * Saves and stores the ingredients in ArrayList Ingredient into a text file.
     * @param ingredientList ArrayList.
     */
    public void saveIngredientData(ArrayList<Ingredient> ingredientList) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Ingredient ingredient : ingredientList) {
                fw.write(ingredient.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    /**
     * Saves the recipe in recipeList ArrayList and recipe ingredients in recipeItems ArrayList into a text file.
     * @param recipeList ArrayList.
     * @param recipeItems ArrayList.
     */
    public void saveRecipeData(ArrayList<Recipe> recipeList, ArrayList<Ingredient> recipeItems) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Recipe recipe : recipeList) {
                fw.write(recipe.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    /**
     * Saves the chores in recipeList choreList into a text file.
     * @param choreList ArrayList.
     */
    public void saveChoreData(ArrayList<Chore> choreList) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Chore chore : choreList) {
                fw.write(chore.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}