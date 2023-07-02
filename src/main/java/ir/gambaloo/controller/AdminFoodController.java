package ir.gambaloo.controller;
/**
 * This controller shows all the foods that added by admin in the tableview
 * Admin can add and remove other foods by clicking in those button
 */


import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFoodController implements Initializable {
    protected static int appetizerChosen = - 1;
    protected static int mainFoodChosen = - 1;
    protected static int desertChosen = - 1;
    protected static int drinksChosen = - 1;
    private Restaurant chosen;
    @FXML
    private TableView<Appetizer> appetizerTBL;
    @FXML
    private TableColumn<Appetizer, String> appetizerCL;
    @FXML
    private TableColumn<Desert, String> desertCL;
    @FXML
    private TableView<Desert> desertsTBL;
    @FXML
    private TableView<Drink> drinksTBL;
    @FXML
    private TableColumn<Drink, String> drinksCL;
    @FXML
    private TableColumn<MainFood, String> mainFoodCL;
    @FXML
    private TableView<MainFood> mainFoodTBL;
    @FXML
    private Label restaurantName;
    @FXML
    private Button disableBTN;

    public Restaurant getChosen ( ) {
        return chosen;
    }

    public void setChosen ( Restaurant chosen ) {
        this.chosen = chosen;
    }

    //Links admin to AddFoodController
    @FXML
    void addFood ( ActionEvent event ) throws IOException {
        FXMLLoader addFood = new FXMLLoader ( Main.class.getResource ( "view/AddFood.fxml" ) );
        addFood.load ( );
        AddFoodController addFoodController = addFood.getController ( );
        addFoodController.setChosen ( chosen );
        addFoodController.setMainFoodTBL ( mainFoodTBL );
        addFoodController.setAppetizerTBL ( appetizerTBL );
        addFoodController.setDesertTBL ( desertsTBL );
        addFoodController.setDrinksTBL ( drinksTBL );
        Stage stage = new Stage ( );
        stage.setScene ( new Scene ( addFood.getRoot ( ) ) );
        stage.setTitle ( "Add a food YUMMY!" );
        stage.show ( );
    }

    //Remove foods from tableview
    @FXML
    void removeFood ( ActionEvent event ) {
        appetizerChosen = appetizerTBL.getSelectionModel ( ).getSelectedIndex ( );
        mainFoodChosen = mainFoodTBL.getSelectionModel ( ).getSelectedIndex ( );
        desertChosen = desertsTBL.getSelectionModel ( ).getSelectedIndex ( );
        drinksChosen = drinksTBL.getSelectionModel ( ).getSelectedIndex ( );
        if ( appetizerChosen >= 0 ) {
            String name = appetizerCL.getCellData ( appetizerChosen );
            appetizerTBL.getItems ( ).remove ( appetizerChosen );
            for ( int i = 0 ; i < chosen.getMenu ( ).getAppetizers ( ).size ( ) ; i++ ) {
                if ( name.equals ( chosen.getMenu ( ).getAppetizers ( ).get ( i ).getName ( ) ) ) {
                    chosen.getMenu ( ).getAppetizers ( ).remove ( i );
                    break;
                }
            }
        } else if ( mainFoodChosen >= 0 ) {
            String name = mainFoodCL.getCellData ( mainFoodChosen );
            mainFoodTBL.getItems ( ).remove ( mainFoodChosen );
            for ( int i = 0 ; i < chosen.getMenu ( ).getMainFoods ( ).size ( ) ; i++ ) {
                if ( name.equals ( chosen.getMenu ( ).getMainFoods ( ).get ( i ).getName ( ) ) ) {
                    chosen.getMenu ( ).getMainFoods ( ).remove ( i );
                    break;
                }
            }
        } else if ( desertChosen >= 0 ) {
            String name = desertCL.getCellData ( desertChosen );
            desertsTBL.getItems ( ).remove ( desertChosen );
            for ( int i = 0 ; i < chosen.getMenu ( ).getDeserts ( ).size ( ) ; i++ ) {
                if ( name.equals ( chosen.getMenu ( ).getDeserts ( ).get ( i ).getName ( ) ) ) {
                    chosen.getMenu ( ).getDeserts ( ).remove ( i );
                    break;
                }
            }
        } else if ( drinksChosen >= 0 ) {
            String name = drinksCL.getCellData ( mainFoodChosen );
            drinksTBL.getItems ( ).remove ( drinksChosen );
            for ( int i = 0 ; i < chosen.getMenu ( ).getDrinks ( ).size ( ) ; i++ ) {
                if ( name.equals ( chosen.getMenu ( ).getDrinks ( ).get ( i ).getName ( ) ) ) {
                    chosen.getMenu ( ).getDrinks ( ).remove ( i );
                    break;
                }
            }
        }


    }

    //Add to table
    public void add ( ) {
        for ( int i = 0 ; i < chosen.getMenu ( ).getAppetizers ( ).size ( ) ; i++ ) {
            appetizerTBL.getItems ( ).add ( chosen.getMenu ( ).getAppetizers ( ).get ( i ) );
        }
        for ( int i = 0 ; i < chosen.getMenu ( ).getMainFoods ( ).size ( ) ; i++ ) {
            mainFoodTBL.getItems ( ).add ( chosen.getMenu ( ).getMainFoods ( ).get ( i ) );
        }
        for ( int i = 0 ; i < chosen.getMenu ( ).getDeserts ( ).size ( ) ; i++ ) {
            desertsTBL.getItems ( ).add ( chosen.getMenu ( ).getDeserts ( ).get ( i ) );
        }
        for ( int i = 0 ; i < chosen.getMenu ( ).getDrinks ( ).size ( ) ; i++ ) {
            drinksTBL.getItems ( ).add ( chosen.getMenu ( ).getDrinks ( ).get ( i ) );
        }

    }

    @Override
    public void initialize ( URL url , ResourceBundle resourceBundle ) {
        appetizerCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getName ( ) ) );
        mainFoodCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getName ( ) ) );
        desertCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getName ( ) ) );
        drinksCL.setCellValueFactory ( cellData -> new SimpleStringProperty ( cellData.getValue ( ).getName ( ) ) );

        appetizerTBL.setPlaceholder ( new Label ( "No food" ) );
        mainFoodTBL.setPlaceholder ( new Label ( "No food" ) );
        desertsTBL.setPlaceholder ( new Label ( "No food" ) );
        drinksTBL.setPlaceholder ( new Label ( "No food" ) );
    }
    @FXML
    void mode(ActionEvent event) {
        if(disableBTN.getText().equals(""));

    }

    @FXML
    void update(ActionEvent event) throws IOException {
        FXMLLoader update=new FXMLLoader (Main.class.getResource ("view/UpdateRestaurant.fxml"));
        update.load ();
        UpdateRestaurantController updateRestaurantController=update.getController ();
        updateRestaurantController.setChosen (chosen);
        Stage stage=new Stage ();
        stage.setScene (new Scene (update.getRoot ()));
        stage.show ();
    }
    public void load(){
        if(chosen.isEnable()){
            disableBTN.setText("Disable");
        }else {
            disableBTN.setText("Enable");
        }
    }
}
