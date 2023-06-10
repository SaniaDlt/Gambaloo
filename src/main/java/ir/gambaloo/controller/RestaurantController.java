package ir.gambaloo.controller;

import ir.gambaloo.module.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantController implements Initializable {

    public ImageView getImage() {
        return image;
    }

    public Label getName() {
        return name;
    }

    public AnchorPane getRoot() {
        return root;
    }

    @FXML
    private transient ImageView image;

    @FXML
    private transient Label name;

    @FXML
    private transient AnchorPane root;

    public Restaurant getRestaurant ( ) {
        return restaurant;
    }

    public void setRestaurant ( Restaurant restaurant ) {
        this.restaurant = restaurant;
    }

    private Restaurant restaurant;
    @FXML
    void restaurantAdd( MouseEvent event) {

    }
    public void load(){
        name.setText ( restaurant.getName ( ) );
    }


    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {

    }

}
