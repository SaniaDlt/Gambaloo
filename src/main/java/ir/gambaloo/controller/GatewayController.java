package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.TaxGateway;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    @FXML
    private Label errorLbl;
    private int captchaCode;
    @FXML
    void payBTN( ActionEvent event) {
        String cardnumber = cardNumberFLD.getText().replaceAll("[^0-9]", "");
        if(captchaCode!=Integer.parseInt(captcha.getText())){
            captchaMaker();
        }else if(cardnumber.length()!=16){
        errorLbl.setText("Wrong card");
        } else if (passwordFLD.getText().length()!=4) {
            errorLbl.setText("Wrong Password");
        }else{
            Node source= (Node) event.getSource();
            source.getScene().getWindow().hide();
            if(nameLbl.getText().toLowerCase().contains("tax")){
                double money=Double.parseDouble(price.getText());
                Main.client.addBalance(money/(1+TaxGateway.taxRate));
            }else{
                Main.client.addBalance(Double.parseDouble((price.getText())));
            }
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        captchaMaker();
    }
    public void captchaMaker(){
        Random random=new Random();
        captchaCode=random.nextInt(9000)+1000;
        code.setText(""+captchaCode);
    }
}

