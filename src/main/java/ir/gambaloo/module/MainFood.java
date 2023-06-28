package ir.gambaloo.module;

/**
 * is a type of food
 */
public class MainFood extends Food {

    public MainFood ( String name , double price , String description , String imageAddress ) {
        super ( name , price , description , imageAddress );
        foodType = FoodType.MAINFOOD;
    }
}
