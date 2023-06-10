package ir.gambaloo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class RestaurantController implements Serializable {

    public ImageView getImage() {
        return image;
    }

    public Label getName() {
        return name;
    }

    public AnchorPane getRoot() {
        return root;
    }

    @FXML
    private transient ImageView image;

    @FXML
    private transient Label name;

    @FXML
    private transient AnchorPane root;
    @FXML
    void restaurantAdd( MouseEvent event) {

    }

}
