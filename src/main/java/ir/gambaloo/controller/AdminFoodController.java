package ir.gambaloo.controller;


import ir.gambaloo.module.Appetizer;
import ir.gambaloo.module.Desert;
import ir.gambaloo.module.Drink;
import ir.gambaloo.module.MainFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminFoodController implements Initializable {

    @FXML
    private TableView<Appetizer> appetizerTBL;

    @FXML
    private TableColumn<Appetizer, String> appetizerTV;

    @FXML
    private TableColumn<Desert, String> desertTV;

    @FXML
    private TableView<Desert> desertsTBL;

    @FXML
    private TableView<Drink> drinksTBL;

    @FXML
    private TableColumn<Drink,String> drinksTV;

    @FXML
    private TableColumn<MainFood,String> mainFoodTV;

    @FXML
    private TableView<MainFood> mainfoodTBL;

    @FXML
    private Label restaurantName;

    @FXML
    void addFood(ActionEvent event) {

    }

    @FXML
    void removeFood(ActionEvent event) {

    }
    public void add(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
