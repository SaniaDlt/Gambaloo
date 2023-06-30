package ir.gambaloo.controller;
/**
 * Users login to their account via this page
 */

import ir.gambaloo.Main;
import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LoginPageController {


    @FXML
    private Label error;

    @FXML
    private Button loginBTn;

    @FXML
    private PasswordField passwordFLD;

    @FXML
    private TextField usernameFLD;


    // checks if the username exist then it will log in
    @FXML
    void login ( ActionEvent event ) throws IOException, ClassNotFoundException {
        String username = usernameFLD.getText ( );
        String password = passwordFLD.getText ( );
        if ( username.equals ( "" ) && password.equals ( "" ) ) {
            error.setText ( "Fill in the blanks." );
        } else {
            Main.printWriter.println ( 2 );
            Main.printWriter.flush ( );
            Main.printWriter.println ( username.toLowerCase (  ) );
            Main.printWriter.flush ( );
            if ( Main.reciver.nextInt ( ) == - 1 ) {
                error.setText ( "Username not found" );
            } else {
                Main.printWriter.println ( password );
                Main.printWriter.flush ( );
                int code = Main.reciver.nextInt ( );
                if ( code == 0 ) {
                    ObjectInputStream recive = new ObjectInputStream ( Main.socket.getInputStream ( ) );
                    Main.client = ( User ) recive.readObject ( );
                    error.setText ( "Login anghezi" );
                    FXMLLoader mainPage = new FXMLLoader ( Main.class.getResource ( "view/MainPage.fxml" ) );
                    mainPage.load ( );
                    Stage stage = new Stage ( );
                    stage.setTitle ( "Main Page" );
                    stage.setScene ( new Scene ( mainPage.getRoot ( ) ) );
                    stage.show ( );
                    stage.setResizable ( false );
                    Node source = ( Node ) event.getSource ( );
                    source.getScene ( ).getWindow ( ).hide ( );


                } else if ( code == - 1 ) {
                    error.setText ( "Password is wrong" );
                } else {
                    ObjectInputStream recive = new ObjectInputStream ( Main.socket.getInputStream ( ) );
                    Main.adminRestaurantsD = ( ArrayList<DeliveryRestaurant> ) recive.readObject ( );
                    Main.adminRestaurantsND = ( ArrayList<NotDeliveryRestaurant> ) recive.readObject ( );
                    FXMLLoader adminPage = new FXMLLoader ( Main.class.getResource ( "view/AdminMain.fxml" ) );
                    adminPage.load ( );
                    Main.isAdmin = true;
                    Stage stage = new Stage ( );
                    stage.setScene ( new Scene ( adminPage.getRoot ( ) ) );
                    Node source = ( Node ) event.getSource ( );
                    source.getScene ( ).getWindow ( ).hide ( );
                    stage.show ( );
                }
            }
        }


    }

    //Links you to signup page
    @FXML
    void signup ( MouseEvent event ) throws IOException {
        FXMLLoader signUpPage = new FXMLLoader ( Main.class.getResource ( "view/SignupPage.fxml" ) );
        signUpPage.load ( );
        Stage stage = new Stage ( );
        stage.setTitle ( "Signup page" );
        stage.setScene ( new Scene ( signUpPage.getRoot ( ) ) );
        stage.show ( );
        stage.setResizable ( false );
    }

}
