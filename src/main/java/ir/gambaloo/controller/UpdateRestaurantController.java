package ir.gambaloo.controller;


import ir.gambaloo.module.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class UpdateRestaurantController {
    @FXML
    private TextField addressFLD;

    @FXML
    private ChoiceBox<Country> countryCHCB;

    @FXML
    private TextField endHourFLD;

    @FXML
    private TextField imageAddressFLD;

    @FXML
    private TextField nameFLD;

    @FXML
    private TextField startHourFLD;

    @FXML
    private ChoiceBox<RestaurantType> typeCHCB;

    public Restaurant getChosen ( ) {
        return chosen;
    }

    public void setChosen ( Restaurant chosen ) {
        this.chosen = chosen;
    }

    Restaurant chosen;

    @FXML
    void updateBTN( ActionEvent event) {
        String name = nameFLD.getText ( );
        String startHour = startHourFLD.getText ( );
        String endHour = endHourFLD.getText ( ) ;
        String address = addressFLD.getText ( );
        Country country = countryCHCB.getValue ( );
        RestaurantType type = typeCHCB.getValue ( );
        String imageAddress = imageAddressFLD.getText ( );
        if(!name.equals ("") ) {
            chosen.setName ( name );
        }
        if(!startHour.equals ("")){
            int start=Integer.parseInt (startHourFLD.getText ());
            chosen.setStartHour (start);
        }
        if(!endHour.equals ("")){
            int end=Integer.parseInt (endHourFLD.getText ());
            chosen.setStartHour (end);
        }
        if(!address.equals ("") ) {
            chosen.setName ( name );
        }
        if(!imageAddress.equals ("") ) {
            chosen.setName ( name );
        }
        if(!country.equals ("")){
            chosen.setCountry (country);
        }
        if(!type.equals ("")) {
            chosen.setType ( type );
        }

    }

}
