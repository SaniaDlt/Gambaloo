package ir.gambaloo.controller;
/**
 * Restaurant page that contains foods of restaurant and fields of a restaurant
 */

import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantPageController implements Initializable {
    private Restaurant restaurant;
    @FXML
    private Label addressLBL;
    @FXML
    private Label endHLBL;
    @FXML
    private ImageView imageV;
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

    public Restaurant getRestaurant ( ) {
        return restaurant;
    }

    public void setRestaurant ( Restaurant restaurant ) {
        this.restaurant = restaurant;
    }

    //Load foods
    public void load ( ) throws IOException, ClassNotFoundException {
        nameLBL.setText ( restaurant.getName ( ) );
        addressLBL.setText ( restaurant.getAddress ( ) );
        startHLBL.setText ( String.valueOf ( restaurant.getStartHour ( ) ) );
        endHLBL.setText ( String.valueOf ( restaurant.getEndHour ( ) ) );
        Main.printWriter.println ( 11 );
        Main.printWriter.flush ( );
        Main.printWriter.println ( restaurant.getImageAddress ( ) );
        Main.getImage ( imageV );
        for ( int i = 0 ; i < restaurant.getMenu ( ).getAppetizers ( ).size ( ) ; i++ ) {
            FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/FoodScene.fxml" ) );
            try {
                fxmlLoader.load ( );
            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }
            FoodController foodController = fxmlLoader.getController ( );
            Main.printWriter.println ( 11 );
            Main.printWriter.println ( restaurant.getMenu ( ).getAppetizers ( ).get ( i ).getImageAddress ( ) );
            Main.printWriter.flush ( );
            Main.getImage ( foodController.getImage ( ) );
            foodController.setFood ( restaurant.getMenu ( ).getAppetizers ( ).get ( i ) );
            foodController.load ( );
            appetizer.getChildren ( ).add ( fxmlLoader.getRoot ( ) );
        }
        for ( int i = 0 ; i < restaurant.getMenu ( ).getMainFoods ( ).size ( ) ; i++ ) {
            FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/FoodScene.fxml" ) );
            try {
                fxmlLoader.load ( );
            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }
            FoodController foodController = fxmlLoader.getController ( );
            Main.printWriter.println ( 11 );
            Main.printWriter.println ( restaurant.getMenu ( ).getMainFoods ( ).get ( i ).getImageAddress ( ) );
            Main.printWriter.flush ( );
            Main.getImage ( foodController.getImage ( ) );
            foodController.setFood ( restaurant.getMenu ( ).getMainFoods ( ).get ( i ) );
            foodController.load ( );
            mainFood.getChildren ( ).add ( fxmlLoader.getRoot ( ) );
        }
        for ( int i = 0 ; i < restaurant.getMenu ( ).getDeserts ( ).size ( ) ; i++ ) {
            FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/FoodScene.fxml" ) );
            try {
                fxmlLoader.load ( );
            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }
            FoodController foodController = fxmlLoader.getController ( );
            Main.printWriter.println ( 11 );
            Main.printWriter.println ( restaurant.getMenu ( ).getDeserts ( ).get ( i ).getImageAddress ( ) );
            Main.printWriter.flush ( );
            Main.getImage ( foodController.getImage ( ) );
            foodController.setFood ( restaurant.getMenu ( ).getDeserts ( ).get ( i ) );
            foodController.load ( );
            desert.getChildren ( ).add ( fxmlLoader.getRoot ( ) );
        }
        for ( int i = 0 ; i < restaurant.getMenu ( ).getDrinks ( ).size ( ) ; i++ ) {
            FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/FoodScene.fxml" ) );
            try {
                fxmlLoader.load ( );
            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }
            FoodController foodController = fxmlLoader.getController ( );
            Main.printWriter.println ( 11 );
            Main.printWriter.println ( restaurant.getMenu ( ).getDrinks ( ).get ( i ).getImageAddress ( ) );
            Main.printWriter.flush ( );
            Main.getImage ( foodController.getImage ( ) );
            foodController.setFood ( restaurant.getMenu ( ).getDrinks ( ).get ( i ) );
            foodController.load ( );
            drinks.getChildren ( ).add ( fxmlLoader.getRoot ( ) );
        }
    }

    //links you to cart page
    @FXML
    void Cart ( MouseEvent event ) throws IOException {
        FXMLLoader cart = new FXMLLoader ( Main.class.getResource ( "view/Cart.fxml" ) );
        cart.load ( );
        Stage stage = new Stage ( );
        stage.setTitle ( "Cart" );
        stage.setResizable ( false );
        stage.setScene ( new Scene ( cart.getRoot ( ) ) );
        stage.show ( );

    }


    @Override
    public void initialize ( URL location , ResourceBundle resources ) {
        vBox = new VBox ( );
        scrollPane.setContent ( vBox );
        vBox.setAlignment ( Pos.CENTER );
        Label appLbl = new Label ( "Appetizer :" );
        Label mainLbl = new Label ( "MainFood :" );
        Label drinkLBL = new Label ( "Drinks :" );
        Label desertLbl = new Label ( "Deserts :" );
        appLbl.setFont ( Font.font ( 20 ) );
        mainLbl.setFont ( Font.font ( 20 ) );
        drinkLBL.setFont ( Font.font ( 20 ) );
        desertLbl.setFont ( Font.font ( 20 ) );
        appetizer = new VBox ( appLbl );
        mainFood = new VBox ( mainLbl );
        drinks = new VBox ( drinkLBL );
        desert = new VBox ( desertLbl );
        vBox.getChildren ( ).addAll ( appetizer , mainFood , desert , drinks );

    }

}
