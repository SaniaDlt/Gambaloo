package ir.gambaloo.module;

/**
 * Drink class extends Food class and contains name price description imageaddress and
 * the food type which is enum
 */

public class Drink extends Food {


    public Drink ( String name , double price , String description , String imageAddress ) {
        super ( name , price , description , imageAddress );
        foodType = FoodType.DRINKS;

    }
}
