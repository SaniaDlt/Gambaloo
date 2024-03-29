package ir.gambaloo.controller;
/**
 * This controller shows all the foods that client orders
 * Client can remove food from cart
 */

import ir.gambaloo.Main;
import ir.gambaloo.module.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class FoodCartController {
    @FXML
    private Label nameLBL;

    @FXML
    private Label priceLBL;

    @FXML
    private HBox root;
    private Food food;
    private CartController cart;

    public Food getFood ( ) {
        return food;
    }

    public void setFood ( Food food ) {
        this.food = food;
    }

    public CartController getCart ( ) {
        return cart;
    }

    public void setCart ( CartController cart ) {
        this.cart = cart;
    }

    //Remove food from cart
    @FXML
    void remove ( MouseEvent event ) {
        Main.client.getCart ( ).removeFromCart ( food );
        cart.refresh ( );
        cart.getRoot ( ).getChildren ( ).remove ( root );
    }

    //Load and change the price and balance of client
    public void load ( ) {
        nameLBL.setText ( food.getName ( ) );
        priceLBL.setText ( String.valueOf ( food.getPrice ( ) ) );
    }
}
