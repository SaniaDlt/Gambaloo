package ir.gambaloo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class RestaurantController {

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
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private AnchorPane root;

}
