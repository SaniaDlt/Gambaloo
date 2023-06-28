package ir.gambaloo.module;
/**
 * Food class contains name price description imageaddress and the food type which is enum
 */

import java.io.Serializable;

public abstract class Food implements Serializable {
    protected String name;
    protected double price;
    protected FoodType foodType;

    protected String imageAddress;
    protected String description;


    public Food ( String name , double price , String description , String imageAddress ) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageAddress = imageAddress;

    }

    public FoodType getFoodType ( ) {
        return foodType;
    }

    public String getImageAddress ( ) {
        return imageAddress;
    }

    public String getDescription ( ) {
        return description;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }
}
