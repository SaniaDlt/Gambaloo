package ir.gambaloo.module;

public class MainFood extends Food {

    public MainFood(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.MAINFOOD;
    }
}
