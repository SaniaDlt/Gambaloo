package ir.gambaloo.controller;
/**
 * This controller shows all the restaurantTV that added by admin in the tableview
 * Admin can add remove edit other restaurants by clicking in their button
 */


import ir.gambaloo.Main;
import ir.gambaloo.module.Restaurant;
import javafx.beans.property.SimpleStringProperty;
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

public class AdminMainController implements Initializable {

    protected static int chosen = - 1;
    protected static String address = null;
    @FXML
    private TableColumn<Restaurant, String> addressCL;
    @FXML
    private TableColumn<Restaurant, String> restaurantCL;

    @FXML
    private TableView<Restaurant> tabelTV;

    @FXML
    private TableColumn<Restaurant, String> type;


    //Links admin to the AddRestaurantController
    @FXML
    void add ( ActionEvent event ) throws IOException {
        FXMLLoader addRestaurant = new FXMLLoader ( Main.class.getResource ( "view/AddRestaurant.fxml" ) );
        addRestaurant.load ( );
        AddRestaurantController addRestaurantController = addRestaurant.getController ( );
        addRestaurantController.setTable ( tabelTV );
        Stage stage = new Stage ( );
        stage.setTitle ( "Add restaurantTV" );
        stage.setScene ( new Scene ( addRestaurant.getRoot ( ) ) );
        stage.show ( );

    }

    //Remove restaurant from tableview
    @FXML
    void delete ( ActionEvent event ) {

        chosen = tabelTV.getSelectionModel ( ).getSelectedIndex ( );
        if ( chosen >= 0 ) {
            String addressCellData = addressCL.getCellData ( chosen );
            tabelTV.getItems ( ).remove ( chosen );
            Restaurant restaurant = detect ( addressCellData );
            if ( ! Main.adminRestaurantsD.remove ( restaurant ) ) {
                Main.adminRestaurantsND.remove ( restaurant );
            }


        }


    }

    //Edit restaurant and links admin to the AdminFoodController
    @FXML
    void edit ( ActionEvent event ) throws IOException {
        chosen = tabelTV.getSelectionModel ( ).getSelectedIndex ( );
        if ( chosen >= 0 ) {
            address = addressCL.getCellData ( chosen );
            Restaurant restaurant = detect ( address );
            FXMLLoader foodPage = new FXMLLoader ( Main.class.getResource ( "view/AdminFood.fxml" ) );
            foodPage.load ( );
            AdminFoodController adminFoodController = foodPage.getController ( );
            adminFoodController.setChosen ( restaurant );
            adminFoodController.add ( );
            Stage stage = new Stage ( );
            stage.setScene ( new Scene ( foodPage.getRoot ( ) ) );
            stage.setTitle ( "AdminFood" );
            stage.show ( );
        }
    }




    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {
        type.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getType ( ) ) );
        restaurantCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getName ( ) ) );
        addressCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getAddress ( ) ) );
        add ( );
        tabelTV.setPlaceholder ( new Label ( "No restaurantTV" ) );

    }

    //Add restaurant to the tableview
    public void add ( ) {
        for ( int i = 0 ; i < Main.adminRestaurantsD.size ( ) ; i++ )
            tabelTV.getItems ( ).add ( Main.adminRestaurantsD.get ( i ) );
        for ( int i = 0 ; i < Main.adminRestaurantsND.size ( ) ; i++ )
            tabelTV.getItems ( ).add ( Main.adminRestaurantsND.get ( i ) );

    }

    //Check if restaurant exist
    public Restaurant detect ( String addressS ) {
        for ( int i = 0 ; i < Main.adminRestaurantsD.size ( ) ; i++ ) {
            if ( addressS.equals ( Main.adminRestaurantsD.get ( i ).getAddress ( ) ) ) {
                return Main.adminRestaurantsD.get ( i );
            }
        }
        for ( int i = 0 ; i < Main.adminRestaurantsND.size ( ) ; i++ ) {
            if ( addressS.equals ( Main.adminRestaurantsND.get ( i ).getAddress ( ) ) ) {

                return Main.adminRestaurantsND.get ( i );
            }
        }
        return null;
    }
}
