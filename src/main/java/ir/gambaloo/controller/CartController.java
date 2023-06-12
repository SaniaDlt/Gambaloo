package ir.gambaloo.controller;

import ir.gambaloo.module.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class CartController {

    public Food getFood ( ) {
        return food;
    }

    public void setFood ( Food food ) {
        this.food = food;
    }

    private Food food;

    @FXML
    private Label balanceLBL;

    @FXML
    private Label errorLBL;

    @FXML
    private Label priceLBL;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void gateway1BTN(ActionEvent event) {

    }

    @FXML
    void gateway2BTN(ActionEvent event) {

    }

    @FXML
    void orderBTN(ActionEvent event) {

    }

}


