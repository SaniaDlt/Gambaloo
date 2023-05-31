package ir.gambaloo;

public class Drink extends Food{

    public Drinks(String name, double price) {
        super(name, price);
        foodType = FoodType.DRINKS;
    }
}
