package ir.gambaloo.controller;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {

    @FXML
    private TableColumn<Restaurant, String> address;
    protected static int chosen=-1;

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

    chosen=  tabel.getSelectionModel().getSelectedIndex();
    if(chosen>=0) {
        String addressCellData=address.getCellData(chosen);
        tabel.getItems().remove(chosen);
        for(int i=0;i<Main.adminRestaurantsD.size();i++){
            if(addressCellData.equals(Main.adminRestaurantsD.get(i).getAddress())){
                Main.adminRestaurantsD.remove(i);
                return;
            }
        }
        for(int i=0;i<Main.adminRestaurantsND.size();i++){
            if(addressCellData.equals(Main.adminRestaurantsND.get(i).getAddress())){
                Main.adminRestaurantsND.remove(i);
                return;
            }
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
}
