package ir.gambaloo.module;

public class Appetizer extends Food {

    public Appetizer(String name, double price) {
        super(name, price);
        foodType = FoodType.APPETIZER;
    }
}
