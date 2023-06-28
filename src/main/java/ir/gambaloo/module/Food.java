package ir.gambaloo.module;
/**
 * Food class contains name price description imageaddress and the food type which is enum
 * */

import ir.gambaloo.Main;
import ir.gambaloo.controller.FoodController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.io.Serializable;
public abstract class  Food implements Serializable {
    protected String name;
    protected double price;
    protected FoodType foodType;

    protected String imageAdress;
    protected String describ;


    public Food(String name, double price,String describ,String imageAdress) {
        this.name = name;
        this.price = price;
        this.describ=describ;
        this.imageAdress=imageAdress;

    }

    public FoodType getFoodType() {
        return foodType;
    }

    public String getImageAdress() {
        return imageAdress;
    }

    public String getDescrib() {
        return describ;
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
