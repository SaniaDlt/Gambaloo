package ir.gambaloo.module;

public class Desert extends Food {

    public Desert(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType = FoodType.DESERT;
    }
}
