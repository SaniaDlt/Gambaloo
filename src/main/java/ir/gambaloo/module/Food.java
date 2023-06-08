package ir.gambaloo.module;

import ir.gambaloo.Main;
import ir.gambaloo.controller.FoodController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.io.Serializable;
public abstract class  Food implements Serializable {
    protected String name;
    protected double price;
    protected FoodType foodType;
    //image2B
    protected String imageAdress;
    protected String describ;
    protected FXMLLoader scene;
    protected FoodController controller;


    public Food(String name, double price,String describ,String imageAdress) {
        this.name = name;
        this.price = price;
        this.describ=describ;
        this.imageAdress=imageAdress;
        scene = new FXMLLoader(Main.class.getResource("view/FoodScene.fxml"));
        try {
            scene.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller=scene.getController();
        controller.getName().setText(name);
        controller.getDescript().setText(describ);
        controller.getPrice().setText(""+price);
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
