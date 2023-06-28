package ir.gambaloo.module;

/**
 * Desert class extends Food class and contains name price description imageaddress and
 * the food type which is enum
 */

public class Desert extends Food {

    public Desert ( String name , double price , String description , String imageAddress ) {
        super ( name , price , description , imageAddress );
        foodType = FoodType.DESERT;
    }
}
