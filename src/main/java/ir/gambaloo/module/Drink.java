package ir.gambaloo.module;
/**
 *Drink class extends Food class and contains name price description imageaddress and
 * the food type which is enum
 * */

public class Drink extends Food {


    public Drink(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.DRINKS;

    }
}
