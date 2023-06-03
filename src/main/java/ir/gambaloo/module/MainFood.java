package ir.gambaloo.module;

public class MainFood extends Food {
    public MainFood(String name, double price) {
        super(name, price);
        foodType = FoodType.MAINFOOD;
    }
}
