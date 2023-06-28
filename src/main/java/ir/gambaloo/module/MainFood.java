package ir.gambaloo.module;
/**
 *is a type of food
 * */
public class MainFood extends Food {

    public MainFood(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.MAINFOOD;
    }
}
