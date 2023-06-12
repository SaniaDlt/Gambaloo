package ir.gambaloo.controller;


import ir.gambaloo.module.Food;

import ir.gambaloo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private Label balanceLBL;

    @FXML
    private Label errorLBL;

    @FXML
    private Label priceLBL;

    @FXML
    private ScrollPane scrollPane;
    private VBox root;

    public VBox getRoot() {
        return root;
    }

    @FXML
    void gateway1BTN(ActionEvent event) {

    }

    @FXML
    void gateway2BTN(ActionEvent event) {

    }

    @FXML
    void orderBTN(ActionEvent event) {
        if(Main.client.getBalance()<Main.client.getCart().getCost()){
            errorLBL.setText("Not enough balance");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root=new VBox();
        scrollPane.setContent(root);
        root.setAlignment(Pos.CENTER);
        for(int i =0;i< Main.client.getCart().getItems().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("view/FoodCart.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            FoodCartController controller=fxmlLoader.getController();
            controller.setFood(Main.client.getCart().getItems().get(i));
            controller.load();
            controller.setCart(this);
            root.getChildren().add(fxmlLoader.getRoot());
        }
        balanceLBL.setText(Main.client.getBalance()+"");
        priceLBL.setText(Main.client.getCart().getCost()+"");
    }
    public void refresh(){
        balanceLBL.setText(Main.client.getBalance()+"");
        priceLBL.setText(Main.client.getCart().getCost()+"");
    }
}


