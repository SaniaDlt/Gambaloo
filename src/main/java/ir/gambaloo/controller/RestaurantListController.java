package ir.gambaloo.controller;
/**
 * Restaurant list that contains all restaurant of a country
 * By clicking on a Restaurant it will link you to a Restaurant page controller
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantListController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    private VBox vBox;

    public ScrollPane getScrollPane ( ) {
        return scrollPane;
    }

    public VBox getvBox ( ) {
        return vBox;
    }

    @Override
    public void initialize ( URL location , ResourceBundle resources ) {
        vBox = new VBox ( );
        vBox.setStyle ( "-fx-background-color : #e9e6e6" );
        scrollPane.setContent ( vBox );
        scrollPane.pannableProperty ( ).set ( true );
        scrollPane.fitToWidthProperty ( ).set ( true );
        scrollPane.fitToHeightProperty ( ).set ( true );
        vBox.setAlignment ( Pos.CENTER );
        vBox.setSpacing ( 10 );

    }
}
