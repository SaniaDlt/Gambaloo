package ir.gambaloo;

import ir.gambaloo.module.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Main extends Application {
    public static Socket socket;
    public static User client;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/WelcomePage.fxml"));
        fxmlLoader.load();
        stage.setTitle("Gambaloo");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.show();
        stage.setResizable(false);


    }

    public static void main(String[] args) throws IOException {
        Main.socket = new Socket("localhost",8382);
        launch();
    }
}