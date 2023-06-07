package ir.gambaloo.module;

public class Drink extends Food {


    public Drink(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.DRINKS;

    }
}
