package ir.gambaloo.controller;

import ir.gambaloo.module.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class UpdateRestaurantController {
    @FXML
    private TextField addressFLD;

    @FXML
    private ChoiceBox<?> countryCHCB;

    @FXML
    private TextField endHourFLD;

    @FXML
    private TextField imageAddressFLD;

    @FXML
    private TextField nameFLD;

    @FXML
    private TextField startHourFLD;

    @FXML
    private TextField tableOrDeliveryFLD;

    @FXML
    private ChoiceBox<?> typeCHCB;


    @FXML
    void updateBTN( ActionEvent event) {

    }

   public void load(){
        addressFLD.setPromptText(chosen.getAddress());
        endHourFLD.setPromptText(chosen.getEndHour() + "");
        imageAddressFLD.setPromptText(chosen.getImageAddress());
        nameFLD.setPromptText(chosen.getName());
        startHourFLD.setPromptText(chosen.getStartHour()+"");
   }
}
