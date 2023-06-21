package ir.gambaloo.module;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<Food> items=new ArrayList<>();
    private double cost=0;

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addToCart(Food food){
        items.add(food);
        cost+= food.getPrice();
    }
    public void removeFromCart(Food food){
        items.remove(food);
        cost-=food.getPrice();
    }

    public ArrayList<Food> getItems() {
        return items;
    }

    public double getCost() {
        return cost;
    }
}
