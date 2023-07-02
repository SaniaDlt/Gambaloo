package ir.gambaloo.controller;
/**
 * This Controller add wanted restaurant by admin and that restaurant appears to the tableview
 */

import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class AddRestaurantController implements Initializable {

    private TableView table;
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
    private TextField tableOrDeliveryFLD;
    @FXML
    private ChoiceBox<RestaurantType> typeCHCB;
    @FXML
    private TextField imageAddressFLD;

    public void setTable ( TableView table ) {
        this.table = table;
    }

    //Add foods
    @FXML
    void addBTN ( ActionEvent event ) {
        String name = nameFLD.getText ( );
        int startHour = Integer.parseInt ( startHourFLD.getText ( ) );
        int endHour = Integer.parseInt ( endHourFLD.getText ( ) );
        String address = addressFLD.getText ( );
        Country country = countryCHCB.getValue ( );
        RestaurantType type = typeCHCB.getValue ( );
        String imageAddress = imageAddressFLD.getText ( );
        if(type!=null) {
            if (type == RestaurantType.DELIVERY) {
                int delivery = Integer.parseInt(tableOrDeliveryFLD.getText());
                DeliveryRestaurant deliveryRestaurant = new DeliveryRestaurant(startHour, endHour, address, delivery, country, name, imageAddress);
                Main.adminRestaurantsD.add(deliveryRestaurant);
                table.getItems().add(deliveryRestaurant);
            } else {
                int tables = Integer.parseInt(tableOrDeliveryFLD.getText());
                NotDeliveryRestaurant notDeliveryRestaurant = new NotDeliveryRestaurant(startHour, endHour, address, tables, country, name, imageAddress);
                Main.adminRestaurantsND.add(notDeliveryRestaurant);
                table.getItems().add(notDeliveryRestaurant);
            }
        }
    }


    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {
        countryCHCB.getItems ( ).setAll ( Country.values ( ) );
        typeCHCB.getItems ( ).setAll ( RestaurantType.values ( ) );
    }
}

