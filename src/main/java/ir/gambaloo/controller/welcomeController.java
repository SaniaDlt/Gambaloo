package ir.gambaloo.controller;

import ir.gambaloo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class welcomeController {

    @FXML
    void getStarted(ActionEvent event) throws IOException {
        System.out.println(Main.class.getResource("view/LoginPage.fxml"));
       FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("view/LoginPage.fxml"));
        fxmlLoader.load();
        Stage stage= new Stage();
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.setTitle("Gambaloo");
        Node source= (Node) event.getSource();
        source.getScene().getWindow().hide();
       stage.show();

    }

}


