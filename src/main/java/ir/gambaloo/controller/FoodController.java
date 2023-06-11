package ir.gambaloo.controller;

import ir.gambaloo.module.ButtonSkin;
import ir.gambaloo.module.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    @FXML
    private Label descript;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label price;

    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Label getDescript() {
        return descript;
    }

    public void setDescript(Label descript) {
        this.descript = descript;
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
    private Button orderBTN;

    @FXML
    void orderBTN(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderBTN.setSkin(new ButtonSkin(orderBTN));
    }
    public void load(){
        name.setText(food.getName());
        price.setText(""+food.getPrice());
        System.out.println(food.getDescrib());
        descript.setText(food.getDescrib());
    }
}
