package ir.gambaloo.module;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private final ArrayList<Food> items=new ArrayList<>();
    private double cost=0;
    public void addToCart(Food food){
        items.add(food);
        cost+= food.getPrice();
    }
    public void removeFromCart(Food food){
        items.remove(food);
        cost-=food.getPrice();
    }
}
