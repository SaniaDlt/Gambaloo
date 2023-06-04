package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class LoginPageController{

    @FXML
    void initialize() {
        try {
            Main.socket = new Socket("localhost",8382);
        } catch (SocketException e){
            error.setText("Server not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
    void login(ActionEvent event) {
        String username=usernameFLD.getText();
        String password=passwordFLD.getText();
        try(
        BufferedReader reciver=new BufferedReader(new InputStreamReader(Main.socket.getInputStream()));
        PrintWriter printWriter=new PrintWriter(Main.socket.getOutputStream(),true);) {
            printWriter.println(2);
            printWriter.println(username);
            if(reciver.read()==-1){
                error.setText("Username not found");
            }else{
                printWriter.println(password);
                if(reciver.read()==0){
                    ObjectInputStream recive = new ObjectInputStream(Main.socket.getInputStream());
                    Main.client=(User) recive.readObject();
                    //Fxml loader Mainpage load mishe
                }else{
                    error.setText("Password is wrong");
                }
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void signup(MouseEvent event) {

    }

}
