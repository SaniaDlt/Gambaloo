package ir.gambaloo.module;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
    private final ArrayList<Appetizer> appetizers = new ArrayList<>();
    private final ArrayList<MainFood> mainFoods = new ArrayList<>();
    private final ArrayList<Desert> deserts = new ArrayList<>();
    private final ArrayList<Drink> drinks = new ArrayList<>();

}
