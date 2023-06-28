package ir.gambaloo.module;
/**
 * This class is for food ordering that add and remove food from cart and get and set cost
 */


import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private final ArrayList<Food> items = new ArrayList<> ( );
    private double cost = 0;

    //Add food to cart
    public void addToCart ( Food food ) {
        items.add ( food );
        cost += food.getPrice ( );
    }

    //Remove food from cart
    public void removeFromCart ( Food food ) {
        items.remove ( food );
        cost -= food.getPrice ( );
    }

    public ArrayList<Food> getItems ( ) {
        return items;
    }

    public double getCost ( ) {
        return cost;
    }

    public void setCost ( double cost ) {
        this.cost = cost;
    }
}
