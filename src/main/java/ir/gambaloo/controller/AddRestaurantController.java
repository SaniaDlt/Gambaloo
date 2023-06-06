package ir.gambaloo.controller;

import ir.gambaloo.module.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddRestaurantController {

    @FXML
    private TextField addressFLD;

    @FXML
    private ChoiceBox<Country> countryCHCB;

    @FXML
    private TextField endHourFLD;

    @FXML
    private TextField nameFLD;

    @FXML
    private TextField startHourFLD;

    @FXML
    void addBTN(ActionEvent event) {

    }

}

