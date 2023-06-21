package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class AddRestaurantController implements Initializable {

    public void setTable ( TableView table ) {
        this.table = table;
    }

    private TableView table;
    private TableView table1;

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
    private TextField ImageAddressFLD;

    @FXML
    void addBTN(ActionEvent event) throws IOException {
        String name=nameFLD.getText ();
        int startHour=Integer.parseInt(startHourFLD.getText ());
        int endHour=Integer.parseInt(endHourFLD.getText ());
        String address=addressFLD.getText ();
        Country country=countryCHCB.getValue ();
        RestaurantType type=typeCHCB.getValue ();
        String imageAdress=ImageAddressFLD.getText();
        if(type==RestaurantType.DELIVERY){
            int delivery=Integer.parseInt ( tableOrDeliveryFLD.getText () );
            DeliveryRestaurant deliveryRestaurant=new DeliveryRestaurant ( startHour,endHour,address,delivery,country,name );
            Main.adminRestaurantsD.add(deliveryRestaurant);
            table.getItems ().add ( deliveryRestaurant );
        }else {
            int tables=Integer.parseInt ( tableOrDeliveryFLD.getText () );
            NotDeliveryRestaurant notDeliveryRestaurant=new NotDeliveryRestaurant ( startHour,endHour,address,tables,country,name );
            Main.adminRestaurantsND.add(notDeliveryRestaurant);
            table.getItems ().add ( notDeliveryRestaurant );
        }

    }


    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {
        countryCHCB.getItems ().setAll (Country.values ());
        typeCHCB.getItems ().setAll ( RestaurantType.values () );
    }
}

