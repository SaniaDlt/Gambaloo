package ir.gambaloo;

public class MainFood extends Food{
    public MianFood(String name, double price) {
        super(name, price);
        foodType = FoodType.MAINFOOD;
    }
}
