package ir.gambaloo.module;

import java.io.Serializable;

public abstract class  Food implements Serializable {
    protected String name;
    protected double price;
    protected FoodType foodType;
    //image2B

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
