package ir.gambaloo.controller;

import ir.gambaloo.module.Country;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.module.RestaurantType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminMainController {

    @FXML
    private TableColumn<Restaurant, Country> country;

    @FXML
    private TableColumn<Restaurant, String> restaurant;

    @FXML
    private TableView<Restaurant> tabel;

    @FXML
    private TableColumn<Restaurant,RestaurantType> type;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

}
