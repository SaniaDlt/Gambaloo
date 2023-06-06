package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class LoginPageController{

    @FXML
    void initialize() {


    }

    @FXML
    private Label error;

    @FXML
    private Button loginBTn;

    @FXML
    private PasswordField passwordFLD;

    @FXML
    private TextField usernameFLD;



    @FXML
    void login(ActionEvent event) throws IOException, ClassNotFoundException {
        String username=usernameFLD.getText();
        String password=passwordFLD.getText();
        if( username.equals ("")&&password.equals ( "" )){
            error.setText ( "Fill in the blanks." );
        }
        else {
            Main.printWriter.println ( 2 );
            Main.printWriter.flush ( );
            Main.printWriter.println ( username );
            Main.printWriter.flush ( );
            if ( Main.reciver.nextInt ( ) == - 1 ) {
                error.setText ( "Username not found" );
            } else {
                Main.printWriter.println ( password );
                Main.printWriter.flush ( );
                if (Main.reciver.nextInt ( ) == 0 ) {
                    ObjectInputStream recive = new ObjectInputStream ( Main.socket.getInputStream ( ) );
                    Main.client = ( User ) recive.readObject ( );
                    error.setText ( "Login anghezi" );
                    //Fxml loader Mainpage load mishe
                } else {
                    error.setText ( "Password is wrong" );
                }
            }
        }


    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        FXMLLoader signUpPage = new FXMLLoader(Main.class.getResource("view/SignupPage.fxml"));
        signUpPage.load();
        Stage stage=new Stage();
        stage.setTitle("Signup page");
        stage.setScene(new Scene(signUpPage.getRoot()));
        stage.show();
        stage.setResizable(false);
    }

}
