package ir.gambaloo.controller;

import ir.gambaloo.module.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class RestaurantPageController {
    public Restaurant getRestaurant ( ) {
        return restaurant;
    }

    public void setRestaurant ( Restaurant restaurant ) {
        this.restaurant = restaurant;
    }

    private Restaurant restaurant;

    @FXML
    private Label adressLBL;

    @FXML
    private Label endHLBL;

    @FXML
    private ImageView image;

    @FXML
    private Label nameLBL;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label startHLBL;

    public void load(){
        nameLBL.setText ( restaurant.getName () );
        adressLBL.setText ( restaurant.getAddress () );
        startHLBL.setText (restaurant.getStartHour ()+"" );
        endHLBL.setText ( restaurant.getEndHour ()+"" );
    }


}
