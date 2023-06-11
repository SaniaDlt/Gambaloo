package ir.gambaloo.controller;

import ir.gambaloo.module.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantPageController implements Initializable {
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
    private VBox vBox;
    private VBox appetizer;
    private VBox mainFood;
    private VBox drinks;
    private VBox desert;

    public void load(){
        nameLBL.setText ( restaurant.getName () );
        adressLBL.setText ( restaurant.getAddress () );
        startHLBL.setText (restaurant.getStartHour ()+"" );
        endHLBL.setText ( restaurant.getEndHour ()+"" );
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vBox=new VBox();
        scrollPane.setContent(vBox);
        vBox.setAlignment(Pos.CENTER);
        Label appLbl=new Label("Appetizer");
        Label mainLbl=new Label("MainFood");
        Label drinkLBL=new Label("Drinks");
        Label desertLbl=new Label("Deserts");
        appLbl.setUnderline(true);
        mainLbl.setUnderline(true);
        drinkLBL.setUnderline(true);
        desertLbl.setUnderline(true);
        appetizer=new VBox(appLbl);
        mainFood=new VBox(mainLbl);
        drinks=new VBox(drinkLBL);
        desert=new VBox(desertLbl);
        vBox.getChildren().addAll(appetizer,mainFood,desert,drinks);


    }
}
