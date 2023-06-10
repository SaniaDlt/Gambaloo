package ir.gambaloo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantListController implements Initializable {

    public VBox getRoot ( ) {
        return root;
    }

    @FXML
    private VBox root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setAlignment(Pos.CENTER);
    }
}
