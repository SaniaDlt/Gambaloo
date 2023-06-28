package ir.gambaloo.module;
/**
 * Desert class extends Food class and contains name price description imageaddress and
 * the food type which is enum
 * */

public class Desert extends Food {

    public Desert(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.DESERT;
    }
}
