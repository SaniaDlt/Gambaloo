package ir.gambaloo.controller;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.Main;
import ir.gambaloo.module.Country;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.module.RestaurantType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {

    @FXML
    private TableColumn<Restaurant, String> country;

    @FXML
    private TableColumn<Restaurant, String> restaurant;

    @FXML
    private TableView<Restaurant> tabel;

    @FXML
    private TableColumn<Restaurant,String> type;


    @FXML
    void add(ActionEvent event) {


    }

    @FXML
    void delete(ActionEvent event) {
    int i=  tabel.getSelectionModel().getSelectedIndex();
    if(i>=0){
        tabel.getItems().remove(i);

        if(Main.adminRestaurantsD.size()<i){
            Main.adminRestaurantsND.remove(i);
        }else{
            Main.adminRestaurantsD.remove(i);
        }
    }


    }

    @FXML
    void edit(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getType()));
        restaurant.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
        country.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCountry()));
        add();

    }
    public void add(){
        for(int i=0;i<Main.adminRestaurantsD.size();i++)
                tabel.getItems().add(Main.adminRestaurantsD.get(i));
        for(int i=0;i<Main.adminRestaurantsND.size();i++)
            tabel.getItems().add(Main.adminRestaurantsND.get(i));

    }
}
