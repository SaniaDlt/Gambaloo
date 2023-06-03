package ir.gambaloo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/Welcome Page.fxml"));
        fxmlLoader.load();
        stage.setTitle("Gambaloo");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}