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
    void login(ActionEvent event) {
        String username=usernameFLD.getText();
        String password=passwordFLD.getText();
        try(
                Scanner reciver=new Scanner(Main.socket.getInputStream());
                PrintWriter printWriter=new PrintWriter(Main.socket.getOutputStream(),true);) {
            printWriter.println(2);
            printWriter.flush();
            printWriter.println(username);
            printWriter.flush();
            if(reciver.nextInt()==-1){
                error.setText("Username not found");
            }else{
                printWriter.println(password);
                printWriter.flush();
                if(reciver.nextInt()==0){
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
