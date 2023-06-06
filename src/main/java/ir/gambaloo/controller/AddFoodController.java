package ir.gambaloo.controller;

import ir.gambaloo.module.FoodType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddFoodController {

    @FXML
    private TextArea DescribFLD;

    @FXML
    private TextField PriceFld;

    @FXML
    private TextField imgFLDs;

    @FXML
    private ChoiceBox<FoodType> typeFld;

    @FXML
    void add(ActionEvent event) {

    }

}
