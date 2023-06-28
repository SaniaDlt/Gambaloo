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
    private Label errorLbl;
    private int captchaCode;
    private CartController cartController;

    public void setCartController(CartController cartController) {
        this.cartController = cartController;
    }

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
                Main.client.addBalance(money/(1+ TaxGateway.taxRate));
            }else{
                Main.client.addBalance(Double.parseDouble((price.getText())));
            }
            cartController.refresh();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        captchaMaker();
    }
    public void captchaMaker(){
        Random random=new Random();
        captchaCode=random.nextInt(9000)+1000;
        code.setText( String.valueOf ( captchaCode ) );
    }


}

