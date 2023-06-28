package ir.gambaloo.module;
/**
 * This class gives animation to button in the RestaurantPageController that change
 * the order button when client click on it
 * */

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class ButtonSkin extends javafx.scene.control.skin.ButtonSkin {

    public ButtonSkin(Button control) {
        super(control);
        final FadeTransition fadeOut=new FadeTransition(Duration.millis(1000));

        fadeOut.setNode(control);
        fadeOut.setToValue(0.1);

       final FadeTransition fadeIn = new FadeTransition(Duration.millis(500));
        fadeIn.setNode(control);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1);
        control.setOnMouseClicked(event -> {
            control.setText("Ordered ✔");
            fadeIn.playFromStart();


            control.setStyle("-fx-background-color:#00FF00");
        });
        control.setOnMouseEntered(e->{
            control.setStyle("-fx-background-color:#FFD000");
        });
        control.setOnMouseExited(event ->{
            control.setText("Order me :)");

            control.setStyle("-fx-background-color:#fce158");
        });
    }
}
