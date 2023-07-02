package ir.gambaloo.controller;


import ir.gambaloo.module.*;
import ir.gambaloo.module.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class UpdateRestaurantController implements Initializable {
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
    private TextField numTableOrDelivery;

    private TableView<Restaurant> tableViewAdminMain;

    public void setTableViewAdminMain(TableView<Restaurant> tableViewAdminMain) {
        this.tableViewAdminMain = tableViewAdminMain;
    }

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
        String tableOrDelivery =numTableOrDelivery.getText();
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
            chosen.setAddress ( address );
        }
        if(!imageAddress.equals ("") ) {
            chosen.setImageAddress(imageAddress);
        }
        if(country!=null){
            chosen.setCountry (country);
        }
        if(!tableOrDelivery.equals("")) {
            if(chosen.getType().equals("DELIVERY")){
                ((DeliveryRestaurant) chosen).setDeliveries(Integer.parseInt(tableOrDelivery));
            }else{
                ((NotDeliveryRestaurant) chosen).setChairs(Integer.parseInt(tableOrDelivery));
            }
        }
        tableViewAdminMain.refresh();
        Node source = ( Node ) event.getSource ( );
        source.getScene ( ).getWindow ( ).hide ( );

    }

   public void load(){
        addressFLD.setPromptText(chosen.getAddress());
        endHourFLD.setPromptText(chosen.getEndHour() + "");
        imageAddressFLD.setPromptText(chosen.getImageAddress());
        nameFLD.setPromptText(chosen.getName());
        startHourFLD.setPromptText(chosen.getStartHour()+"");
       if(chosen.getType().equals("DELIVERY")){
           numTableOrDelivery.setPromptText(String.valueOf(((DeliveryRestaurant) chosen).getDeliveries()));
       }else{
           numTableOrDelivery.setPromptText(String.valueOf(((NotDeliveryRestaurant) chosen).getChairs()));
       }
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryCHCB.getItems ( ).setAll ( Country.values ( ) );
    }
}
