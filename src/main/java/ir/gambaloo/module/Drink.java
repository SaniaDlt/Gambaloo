package ir.gambaloo.module;

public class Drink extends Food {

    public Drink(String name, double price) {
        super(name, price);
        foodType = FoodType.DRINKS;
    }
}
