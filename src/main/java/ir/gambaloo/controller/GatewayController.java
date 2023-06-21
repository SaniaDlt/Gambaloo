package ir.gambaloo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class GatewayController {

    @FXML
    private TextField captcha;

    @FXML
    private TextField cardNumberFLD;

    @FXML
    private Label code;

    public void setNameLbl ( Label nameLbl ) {
        this.nameLbl = nameLbl;
    }

    public Label getNameLbl ( ) {
        return nameLbl;
    }

    @FXML
    private Label nameLbl;

    @FXML
    private PasswordField passwordFLD;

    public void setPrice ( Label price ) {
        this.price = price;
    }

    public Label getPrice ( ) {
        return price;
    }

    @FXML
    private Label price;
    @FXML
    void payBTN( ActionEvent event) {

    }
    
}

