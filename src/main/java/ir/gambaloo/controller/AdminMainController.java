package ir.gambaloo.controller;
/**
 * This controller shows all the restaurant that added by admin in the tableview
 * Admin can add remove edit other restaurants by clicking in their button
 * */



import ir.gambaloo.module.Restaurant;
import ir.gambaloo.Main;
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

    @FXML
    private TableColumn<Restaurant, String> address;
    protected static int chosen=-1;
    protected static String addressS=null;

    @FXML
    private TableColumn<Restaurant, String> restaurant;

    @FXML
    private TableView<Restaurant> tabel;

    @FXML
    private TableColumn<Restaurant,String> type;


    @FXML
    void add(ActionEvent event) throws IOException {
    FXMLLoader addRestaurant=new FXMLLoader(Main.class.getResource ( "view/AddRestaurant.fxml" ));
    addRestaurant.load ();
   AddRestaurantController addRestaurantController=addRestaurant.getController ();
   addRestaurantController.setTable (tabel );
    Stage stage=new Stage ();
    stage.setTitle ( "Add restaurant" );
    stage.setScene ( new Scene ( addRestaurant.getRoot () ) );
    stage.show ();

    }

    @FXML
    void delete(ActionEvent event) {

    chosen=  tabel.getSelectionModel().getSelectedIndex();
    if(chosen>=0) {
        String addressCellData=address.getCellData(chosen);
        tabel.getItems().remove(chosen);
        Restaurant restaurant=detect(addressCellData);
        if(!Main.adminRestaurantsD.remove(restaurant)){
            Main.adminRestaurantsND.remove(restaurant);
        }


    }


    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        chosen=tabel.getSelectionModel().getSelectedIndex();
        if(chosen>=0) {
            addressS=address.getCellData(chosen);
            Restaurant restaurant=detect(addressS);
            FXMLLoader foodPage = new FXMLLoader(Main.class.getResource("view/AdminFood.fxml"));
            foodPage.load();
            AdminFoodController adminFoodController=foodPage.getController();
            adminFoodController.setChosen(restaurant);
            adminFoodController.add();
            Stage stage = new Stage();
            stage.setScene(new Scene(foodPage.getRoot()));
            stage.setTitle("AdminFood");
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getType()));
        restaurant.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
        address.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress()));
        add();
        tabel.setPlaceholder(new Label("No restaurant"));

    }
    public void add(){
        for(int i=0;i<Main.adminRestaurantsD.size();i++)
                tabel.getItems().add(Main.adminRestaurantsD.get(i));
        for(int i=0;i<Main.adminRestaurantsND.size();i++)
            tabel.getItems().add(Main.adminRestaurantsND.get(i));

    }
    public Restaurant detect(String addressS){
        for(int i=0;i<Main.adminRestaurantsD.size();i++){
            if(addressS.equals(Main.adminRestaurantsD.get(i).getAddress())){
                return Main.adminRestaurantsD.get(i);
            }
        }
        for(int i=0;i<Main.adminRestaurantsND.size();i++){
            if(addressS.equals(Main.adminRestaurantsND.get(i).getAddress())){

                return Main.adminRestaurantsND.get(i);
            }
        }
        return null;
    }
}
