package ir.gambaloo;

import ir.gambaloo.module.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Main extends Application {
    public static Socket socket;
    public static User client;
    public static Scanner reciver;
    public static PrintWriter printWriter;


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
<<<<<<< HEAD
        Main.socket = new Socket("localhost",9090);
        Main.reciver=new Scanner ( Main.socket.getInputStream ( ) );
        Main.printWriter= new PrintWriter ( Main.socket.getOutputStream ( ) , true );
=======
        Main.socket = new Socket("localhost",8283);
>>>>>>> 1bae914d4a55b1acddb541f791f9fe3fd0b6ebac
        launch();
    }
}