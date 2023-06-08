package ir.gambaloo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FoodController {

    @FXML
    private Label Descript;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label price;

    public Label getDescript() {
        return Descript;
    }

    public void setDescript(Label descript) {
        Descript = descript;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getPrice() {
        return price;
    }

    public void setPrice(Label price) {
        this.price = price;
    }

    @FXML
    void orderBTN(ActionEvent event) {

    }

}
