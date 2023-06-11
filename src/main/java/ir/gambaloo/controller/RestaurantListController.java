package ir.gambaloo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantListController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
