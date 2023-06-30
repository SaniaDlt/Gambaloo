package ir.gambaloo.controller;
/**
 * This controller shows the foods that ordered by client with their price and balance
 * It has order and gateway button
 */


import ir.gambaloo.Main;
import ir.gambaloo.module.LimitGateway;
import ir.gambaloo.module.TaxGateway;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private Label balanceLBL;

    @FXML
    private Label errorLBL;

    @FXML
    private Label priceLBL;

    @FXML
    private ScrollPane scrollPane;
    private VBox root;

    public VBox getRoot ( ) {
        return root;
    }

    //Links clients to tax gateway
    @FXML
    void gateway1BTN ( ActionEvent event ) throws IOException {
        TaxGateway Gateway = new TaxGateway ( Main.client.getCart ( ).getCost ( ) );
        FXMLLoader gateWay1 = new FXMLLoader ( Main.class.getResource ( "view/Gateway.fxml" ) );
        gateWay1.load ( );
        GatewayController gatewayController = gateWay1.getController ( );
        gatewayController.getPrice ( ).setText ( String.valueOf ( Gateway.getPrice ( ) ) );
        gatewayController.setCartController ( this );
        Stage stage = new Stage ( );
        stage.setScene ( new Scene ( gateWay1.getRoot ( ) ) );
        stage.setTitle ( "Tax Gateway" );
        gatewayController.getNameLbl ( ).setText ( "Tax Gateway" );
        stage.show ( );
    }

    //Links client to limited gateway
    @FXML
    void gateway2BTN ( ActionEvent event ) throws IOException {
        LimitGateway limitGateway = new LimitGateway ( Main.client.getCart ( ).getCost ( ) );
        FXMLLoader gateWay2 = new FXMLLoader ( Main.class.getResource ( "view/Gateway.fxml" ) );
        gateWay2.load ( );
        GatewayController gatewayController = gateWay2.getController ( );
        gatewayController.getPrice ( ).setText ( String.valueOf ( limitGateway.getPrice ( ) ) );
        Stage stage = new Stage ( );
        stage.setScene ( new Scene ( gateWay2.getRoot ( ) ) );
        stage.setTitle ( "Limited gateway" );
        gatewayController.getNameLbl ( ).setText ( "Limit Gateway" );
        if ( Main.client.getCart ( ).getCost ( ) < 15 ) {
            errorLBL.setText ( "Must be out at leat 15 dollor" );
        } else {
            stage.show ( );
        }


    }

    //Finish the ordering
    @FXML
    void orderBTN ( ActionEvent event ) throws IOException {
        if ( Main.client.getBalance ( ) < Main.client.getCart ( ).getCost ( ) ) {
            errorLBL.setText ( "Not enough balance" );
        } else {
            Main.client.setBalance ( Main.client.getBalance ( ) - Main.client.getCart ( ).getCost ( ) );
            Main.client.getCart ( ).setCost ( 0 );
            Main.client.getCart ( ).getItems ( ).clear ( );
            Node source = ( Node ) event.getSource ( );
            source.getScene ( ).getWindow ( ).hide ( );
            FXMLLoader endPage = new FXMLLoader ( Main.class.getResource ( "view/EndPage.fxml" ) );
            endPage.load ( );
            Stage stage = new Stage ( );
            stage.setScene ( new Scene ( endPage.getRoot ( ) ) );
            stage.show ( );
            stage.setResizable ( false );
            stage.setTitle ("Order is commiiiiiiiiiiiiiiing");
        }


    }

    @Override
    public void initialize ( URL location , ResourceBundle resources ) {
        root = new VBox ( );
        scrollPane.setContent ( root );
        root.setAlignment ( Pos.CENTER );
        for ( int i = 0 ; i < Main.client.getCart ( ).getItems ( ).size ( ) ; i++ ) {
            FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( "view/FoodCart.fxml" ) );
            try {
                fxmlLoader.load ( );
            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }
            FoodCartController controller = fxmlLoader.getController ( );
            controller.setFood ( Main.client.getCart ( ).getItems ( ).get ( i ) );
            controller.load ( );
            controller.setCart ( this );
            root.getChildren ( ).add ( fxmlLoader.getRoot ( ) );
        }
        balanceLBL.setText ( String.valueOf ( Main.client.getBalance ( ) ) );
        priceLBL.setText ( String.valueOf ( Main.client.getCart ( ).getCost ( ) ) );
    }

    public void refresh ( ) {
        balanceLBL.setText ( String.valueOf ( Main.client.getBalance ( ) ) );
        priceLBL.setText ( String.valueOf ( Main.client.getCart ( ).getCost ( ) ) );
    }
}


