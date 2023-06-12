package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class FoodCartController  {
    @FXML
    private Label nameLBL;

    @FXML
    private Label priceLBL;

    @FXML
    private HBox root;
    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @FXML
    void remove(MouseEvent event) {
        Main.client.getCart().getItems().remove(food);
    }
    public void load(){
        nameLBL.setText(food.getName());
        priceLBL.setText(food.getPrice()+"");
    }
}
