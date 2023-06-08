package ir.gambaloo.controller;

import ir.gambaloo.Main;
import ir.gambaloo.module.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFoodController implements Initializable {

    @FXML
    private TextArea DescribFLD;

    @FXML
    private TextField PriceFld;

    @FXML
    private TextField imgFLDs;

    @FXML
    private ChoiceBox<FoodType> typeFld;

    @FXML
    private Label errorLBL;

    @FXML
    private TextField nameFLD;

    private TableView desertTBL,mainFoodTBL,appetizerTBL,drinksTBL;
    private Restaurant chosen;

    public Restaurant getChosen() {
        return chosen;
    }

    public void setChosen(Restaurant chosen) {
        this.chosen = chosen;
    }

    public TableView getDesertTBL() {
        return desertTBL;
    }

    public void setDesertTBL(TableView desertTBL) {
        this.desertTBL = desertTBL;
    }

    public TableView getMainFoodTBL() {
        return mainFoodTBL;
    }

    public void setMainFoodTBL(TableView mainFoodTBL) {
        this.mainFoodTBL = mainFoodTBL;
    }

    public TableView getAppetizerTBL() {
        return appetizerTBL;
    }

    public void setAppetizerTBL(TableView appetizerTBL) {
        this.appetizerTBL = appetizerTBL;
    }

    public TableView getDrinksTBL() {
        return drinksTBL;
    }

    public void setDrinksTBL(TableView drinksTBL) {
        this.drinksTBL = drinksTBL;
    }

    @FXML
    void add(ActionEvent event) {
        int price=Integer.parseInt(PriceFld.getText());
        String name=nameFLD.getText();
        String imgAdress=imgFLDs.getText();
        FoodType foodType=typeFld.getValue();
        String describ=DescribFLD.getText();
        if(!(price==0) && !name.equals("") &&!imgAdress.equals("") &&
                !(foodType==null) &&!describ.equals("")){
            if(exist(name)) {
                if (foodType == FoodType.APPETIZER) {
                    Appetizer food = new Appetizer(name, price, describ, imgAdress);
                    chosen.getMenu().getAppetizers().add(food);
                    appetizerTBL.getItems().add(food);
                } else if (foodType == FoodType.DESERT) {
                    Desert food = new Desert(name, price, describ, imgAdress);
                    chosen.getMenu().getDeserts().add(food);
                    desertTBL.getItems().add(food);
                } else if (foodType == FoodType.DRINKS) {
                    Drink food = new Drink(name, price, describ, imgAdress);
                    chosen.getMenu().getDrinks().add(food);
                    drinksTBL.getItems().add(food);
                } else {
                    MainFood food = new MainFood(name, price, describ, imgAdress);
                    chosen.getMenu().getMainFoods().add(food);
                    mainFoodTBL.getItems().add(food);
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeFld.getItems().setAll ( FoodType.values () );

    }
    private boolean exist(String name){
        for(int i=0;i<chosen.getMenu().getAppetizers().size();i++)
            if(name.equals(chosen.getMenu().getAppetizers().get(i).getName())){
                return false;
            }
        for(int i=0;i<chosen.getMenu().getDeserts().size();i++)
            if(name.equals(chosen.getMenu().getDeserts().get(i).getName())){
                return false;
            }
        for(int i=0;i<chosen.getMenu().getMainFoods().size();i++)
            if(name.equals(chosen.getMenu().getMainFoods().get(i).getName())){
                return false;
            }
        for(int i=0;i<chosen.getMenu().getDrinks().size();i++)
            if(name.equals(chosen.getMenu().getDrinks().get(i).getName())){
                return false;
            }
        return true;
    }
}
