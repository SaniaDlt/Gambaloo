package ir.gambaloo;
/**
 * Start of an amazing project
 * */
import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    public static Socket socket;
    public static User client;
    public static Scanner reciver;
    public static PrintWriter printWriter;
    public static ArrayList<DeliveryRestaurant> adminRestaurantsD;
    public static ArrayList<NotDeliveryRestaurant>adminRestaurantsND;
    public static boolean isAdmin=false;


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
        try {
            Main.socket = new Socket("localhost", 8283);
            Main.reciver = new Scanner(Main.socket.getInputStream());
            Main.printWriter = new PrintWriter(Main.socket.getOutputStream(), true);
        }catch (SocketException e){
            System.out.println("Server is offline");
            System.exit(1);
        }

        launch();
    }
    //Saves everything after shut down Client
    @Override
    public void stop() throws Exception {
        super.stop();
        if(Main.isAdmin) {
            Main.printWriter.println(0);
            Main.printWriter.flush();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(Main.adminRestaurantsD);
            objectOutputStream.flush();
            objectOutputStream.writeObject(Main.adminRestaurantsND);
            objectOutputStream.flush();

        }else{
            Main.printWriter.println (-1);
            printWriter.flush ();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream (socket.getOutputStream ());
            objectOutputStream.writeObject (Main.client);
            objectOutputStream.flush ();
        }
        Main.socket.close();
        System.out.println("Closing connection");
    }
    //Receive image as byte array
    public static void getImage(ImageView imageView) throws IOException, ClassNotFoundException {
      byte[] imageData;
      ObjectInputStream objectInputStream=new ObjectInputStream (socket.getInputStream ());
      imageData= ( byte[] ) objectInputStream.readObject ();
      ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream (imageData);
      imageView.setImage(new Image(byteArrayInputStream));
      imageView.setFitHeight (imageView.getFitHeight ());
      imageView.setFitWidth (imageView.getFitWidth ());
      imageView.setPreserveRatio (false);



    }

}