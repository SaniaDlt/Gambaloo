package ir.gambaloo.module;

public class Appetizer extends Food {


    public Appetizer(String name, double price, String describ, String imageAdress) {
        super(name, price, describ, imageAdress);
        foodType=FoodType.APPETIZER;
    }
}
