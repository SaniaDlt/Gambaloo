package ir.gambaloo.controller;


import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFoodController implements Initializable {
    private Restaurant chosen;

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
    void addFood(ActionEvent event) throws IOException {
        FXMLLoader addFood=new FXMLLoader(Main.class.getResource("view/AddFood.fxml"));
        addFood.load();
        AddFoodController addFoodController=addFood.getController();
        addFoodController.setChosen(chosen);
        addFoodController.setMainFoodTBL(mainfoodTBL);
        addFoodController.setAppetizerTBL(appetizerTBL);
        addFoodController.setDesertTBL(desertsTBL);
        addFoodController.setDrinksTBL(drinksTBL);
        Stage stage=new Stage();
        stage.setScene(new Scene(addFood.getRoot()));
        stage.setTitle("Add a food YUMMY!");
        stage.show();
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
