package ir.gambaloo.controller;

import ir.gambaloo.module.Appetizer;
import ir.gambaloo.module.Desert;
import ir.gambaloo.module.Drink;
import ir.gambaloo.module.MainFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class AdminFoodController {

    @FXML
    private TableColumn<Appetizer,String> appetizer;

    @FXML
    private TableColumn<Desert, String> desert;

    @FXML
    private TableColumn<Drink, String> drinks;

    @FXML
    private TableColumn<MainFood, String> mainFood;

    @FXML
    private Label restaurantName;

    @FXML
    void addFood(ActionEvent event) {

    }

    @FXML
    void removeFood(ActionEvent event) {

    }

}
