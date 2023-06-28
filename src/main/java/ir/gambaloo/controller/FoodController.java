package ir.gambaloo.controller;
/**
 * This controller shows food features like image price name type and add this page to the
 * RestaurantPageController
 */

import ir.gambaloo.module.ButtonSkin;
import ir.gambaloo.module.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static ir.gambaloo.Main.client;

public class FoodController implements Initializable {

    @FXML
    private Label description;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label price;

    private Food food;
    @FXML
    private Button orderBTN;

    public Food getFood ( ) {
        return food;
    }

    public void setFood ( Food food ) {
        this.food = food;
    }

    public Label getDescription ( ) {
        return description;
    }

    public void setDescription ( Label description ) {
        this.description = description;
    }

    public ImageView getImage ( ) {
        return image;
    }

    public void setImage ( ImageView image ) {
        this.image = image;
    }

    public Label getName ( ) {
        return name;
    }

    public void setName ( Label name ) {
        this.name = name;
    }

    public Label getPrice ( ) {
        return price;
    }

    public void setPrice ( Label price ) {
        this.price = price;
    }

    //Order and add food to cart
    @FXML
    void orderBTN ( ActionEvent event ) {
        client.getCart ( ).addToCart ( getFood ( ) );
    }

    @Override
    public void initialize ( URL location , ResourceBundle resources ) {
        orderBTN.setSkin ( new ButtonSkin ( orderBTN ) );
    }

    //Load food scene
    public void load ( ) {
        name.setText ( food.getName ( ) );
        price.setText ( String.valueOf ( food.getPrice ( ) ) );
        description.setText ( food.getDescription ( ) );
    }
}
