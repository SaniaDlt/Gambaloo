package ir.gambaloo.module;

public class Desert extends Food {
    public Desert(String name, double price) {
        super(name, price);
        foodType = FoodType.DESERT;
    }
}
