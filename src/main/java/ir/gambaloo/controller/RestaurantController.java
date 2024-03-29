package ir.gambaloo.controller;
/**
 * Restaurant scene that are in a Restaurant list
 */

import ir.gambaloo.Main;
import ir.gambaloo.module.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantController implements Initializable {

    @FXML
    private transient ImageView imageV;
    @FXML
    private transient Label nameLBL;
    @FXML
    private transient AnchorPane root;
    private Restaurant restaurant;

    public ImageView getImageV ( ) {
        return imageV;
    }

    public Label getNameLBL ( ) {
        return nameLBL;
    }

    public AnchorPane getRoot ( ) {
        return root;
    }

    public Restaurant getRestaurant ( ) {
        return restaurant;
    }

    public void setRestaurant ( Restaurant restaurant ) {
        this.restaurant = restaurant;
    }

    //Load restaurant that is clicked
    @FXML
    void restaurantLoad ( MouseEvent event ) throws IOException, ClassNotFoundException {
        FXMLLoader restaurantPage = new FXMLLoader ( Main.class.getResource ( "view/RestaurantPage.fxml" ) );
        restaurantPage.load ( );
        Stage stage = new Stage ( );
        stage.setScene ( new Scene ( restaurantPage.getRoot ( ) ) );
        stage.show ( );
        RestaurantPageController restaurantPageController = restaurantPage.getController ( );
        restaurantPageController.setRestaurant ( restaurant );
        restaurantPageController.load ( );
    }

    public void load ( ) {
        nameLBL.setText ( restaurant.getName ( ) );
    }


    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {

    }

}
