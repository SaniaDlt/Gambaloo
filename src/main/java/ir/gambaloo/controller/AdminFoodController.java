package ir.gambaloo.controller;


import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFoodController implements Initializable {
    private Restaurant chosen;

    public Restaurant getChosen() {
        return chosen;
    }

    public void setChosen(Restaurant chosen) {
        this.chosen = chosen;
    }

    protected static int appetizerChosen=-1;
    protected static int mainFoodChosen=-1;
    protected static int desertChosen=-1;
    protected static int drinksChosen=-1;
    @FXML
    private TableView<Appetizer> appetizerTBL;

    @FXML
    private TableColumn<Appetizer, String> appetizerTV;

    @FXML
    private TableColumn<Desert, String> desertTV;

    @FXML
    private TableView<Desert> desertsTBL;

    @FXML
    private TableView<Drink> drinksTBL;

    @FXML
    private TableColumn<Drink,String> drinksTV;

    @FXML
    private TableColumn<MainFood,String> mainFoodTV;

    @FXML
    private TableView<MainFood> mainfoodTBL;

    @FXML
    private Label restaurantName;

    @FXML
    void addFood(ActionEvent event) throws IOException {
        FXMLLoader addFood=new FXMLLoader(Main.class.getResource("view/AddFood.fxml"));
        addFood.load();
        AddFoodController addFoodController=addFood.getController();
        addFoodController.setChosen(chosen);
        addFoodController.setMainFoodTBL(mainfoodTBL);
        addFoodController.setAppetizerTBL(appetizerTBL);
        addFoodController.setDesertTBL(desertsTBL);
        addFoodController.setDrinksTBL(drinksTBL);
        Stage stage=new Stage();
        stage.setScene(new Scene(addFood.getRoot()));
        stage.setTitle("Add a food YUMMY!");
        stage.show();
    }

    @FXML
    void removeFood(ActionEvent event) {
        appetizerChosen=appetizerTBL.getSelectionModel ().getSelectedIndex ();
        mainFoodChosen=mainfoodTBL.getSelectionModel ().getSelectedIndex ();
        desertChosen=desertsTBL.getSelectionModel ().getSelectedIndex ();
        drinksChosen=drinksTBL.getSelectionModel ().getSelectedIndex ();
        if(appetizerChosen>=0){
            String name= appetizerTV.getCellData ( appetizerChosen);
            appetizerTBL.getItems ().remove ( appetizerChosen );
            for(int i=0;i<chosen.getMenu ().getAppetizers ().size ();i++){
                if(name.equals ( chosen.getMenu ().getAppetizers ().get(i).getName () )){
                    chosen.getMenu ().getAppetizers ().remove ( i );
                    break;
                }
            }}
            else if(mainFoodChosen>=0){
                String name=mainFoodTV.getCellData ( mainFoodChosen );
                mainfoodTBL.getItems ().remove ( mainFoodChosen );
                for(int i=0;i<chosen.getMenu ().getMainFoods ().size ();i++){
                    if(name.equals ( chosen.getMenu ().getMainFoods ().get ( i ).getName () )) {
                        chosen.getMenu ().getMainFoods ().remove ( i );
                        break;
                    }
                }
            }
        else if(desertChosen>=0){
            String name=desertTV.getCellData ( desertChosen );
            desertsTBL.getItems ().remove ( desertChosen );
            for(int i=0;i<chosen.getMenu ().getDeserts ().size ();i++){
                if(name.equals ( chosen.getMenu ().getDeserts ().get ( i ).getName () )) {
                    chosen.getMenu ().getDeserts ().remove ( i );
                    break;
                }
            }
        }
        else if(drinksChosen>=0){
            String name=drinksTV.getCellData ( mainFoodChosen );
            drinksTBL.getItems ().remove ( drinksChosen );
            for(int i=0;i<chosen.getMenu ().getDrinks ().size ();i++){
                if(name.equals ( chosen.getMenu ().getDrinks ().get ( i ).getName () )) {
                    chosen.getMenu ().getDrinks ().remove ( i );
                    break;
                }
            }
        }


        }


    public void add(){
        for(int i=0;i<chosen.getMenu ().getAppetizers ().size ();i++){
            appetizerTBL.getItems ().add ( chosen.getMenu ().getAppetizers ().get ( i ) );
        }
        for(int i=0;i<chosen.getMenu ().getMainFoods ().size ();i++){
            mainfoodTBL.getItems ().add ( chosen.getMenu ().getMainFoods ().get ( i ) );
        }
        for(int i=0;i<chosen.getMenu ().getDeserts ().size ();i++){
            desertsTBL.getItems ().add ( chosen.getMenu ().getDeserts ().get ( i ) );
        }
        for(int i=0;i<chosen.getMenu ().getDrinks ().size ();i++){
            drinksTBL.getItems ().add ( chosen.getMenu ().getDrinks ().get ( i ) );
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appetizerTV.setCellValueFactory(cellData->new SimpleStringProperty (cellData.getValue().getName()));
        mainFoodTV.setCellValueFactory(cellData->new SimpleStringProperty (cellData.getValue().getName()));
        desertTV.setCellValueFactory(cellData->new SimpleStringProperty (cellData.getValue().getName()));
        drinksTV.setCellValueFactory(cellData->new SimpleStringProperty (cellData.getValue().getName()));
        add();
        appetizerTBL.setPlaceholder ( new Label ( "No food" ) );
        mainfoodTBL.setPlaceholder ( new Label ( "No food" ) );
        desertsTBL.setPlaceholder ( new Label ( "No food" ) );
        drinksTBL.setPlaceholder ( new Label ( "No food" ) );
    }
}
