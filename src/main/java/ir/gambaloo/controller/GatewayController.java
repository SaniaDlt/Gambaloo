package ir.gambaloo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GatewayController implements Initializable {

    @FXML
    private TextField captcha;

    @FXML
    private TextField cardNumberFLD;

    @FXML
    private Label code;

    @FXML
    private Label nameLbl;

    @FXML
    private PasswordField passwordFLD;

    @FXML
    private Label price;

    public Label getPrice() {
        return price;
    }

    public void setPrice(Label price) {
        this.price = price;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random random=new Random();
        int rand=random.nextInt(9000)+1000;
        code.setText(""+rand);
    }
}

