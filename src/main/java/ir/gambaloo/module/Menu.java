package ir.gambaloo.module;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *Menu contains 4 arraylist of appetizers main food deserts and drinks
 * */
public class Menu implements Serializable {
    private  ArrayList<Appetizer> appetizers = new ArrayList<>();
    private  ArrayList<MainFood> mainFoods = new ArrayList<>();
    private ArrayList<Desert> deserts = new ArrayList<>();
    private  ArrayList<Drink> drinks = new ArrayList<>();

    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

    public void setAppetizers(ArrayList<Appetizer> appetizers) {
        this.appetizers = appetizers;
    }

    public ArrayList<MainFood> getMainFoods() {
        return mainFoods;
    }

    public void setMainFoods(ArrayList<MainFood> mainFoods) {
        this.mainFoods = mainFoods;
    }

    public ArrayList<Desert> getDeserts() {
        return deserts;
    }

    public void setDeserts(ArrayList<Desert> deserts) {
        this.deserts = deserts;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }
}
