package ir.gambaloo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane loginpane;

    @FXML
    private PasswordField passFld;

    @FXML
    private Button signupBtn;

    @FXML
    private Label statusLbl;

    @FXML
    private TextField usernameFld;

    @FXML
    void login(ActionEvent event) {
        System.out.println("MARG");
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        FXMLLoader signup = new FXMLLoader(this.getClass().getResource("SignUpPage.fxml"));
        signup.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(signup.getRoot()));
        stage.show();
    }

}

