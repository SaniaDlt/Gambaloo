package ir.gambaloo.module;

/**
 * Appetizer class extends Food class and contains name price description imageaddress and
 * the food type which is enum
 */

public class Appetizer extends Food {


    public Appetizer ( String name , double price , String description , String imageAddress ) {
        super ( name , price , description , imageAddress );
        foodType = FoodType.APPETIZER;
    }
}
