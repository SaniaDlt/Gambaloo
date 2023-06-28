package ir.gambaloo.controller;
/**
 * This page is just created by request of saniaDlt
 */

import ir.gambaloo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    void getStarted ( ActionEvent event ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/LoginPage.fxml" ) );
        fxmlLoader.load ( );
        Stage stage = new Stage ( );
        stage.setScene ( new Scene ( fxmlLoader.getRoot ( ) ) );
        stage.setTitle ( "Gambaloo" );
        Node source = ( Node ) event.getSource ( );
        source.getScene ( ).getWindow ( ).hide ( );
        stage.show ( );

    }

}


