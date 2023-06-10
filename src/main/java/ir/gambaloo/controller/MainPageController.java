package ir.gambaloo.controller;

    import ir.gambaloo.Main;
    import ir.gambaloo.module.Restaurant;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Node;
    import javafx.scene.Scene;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.ArrayList;

public class MainPageController {
        ArrayList<Restaurant> restaurant;

        @FXML
        void USAClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (9);
            Main.printWriter.flush ();

            ObjectInputStream USARestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) USARestaurant.readObject();
            addRoot (restaurant);
            USARestaurant.close ();


        }

        @FXML
        void iranClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (7);
            Main.printWriter.flush ();
            ObjectInputStream iranRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) iranRestaurant.readObject();
            addRoot (restaurant);
            iranRestaurant.close ();
        }

        @FXML
        void italyClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (5);
            Main.printWriter.flush ();
            ObjectInputStream italyRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) italyRestaurant.readObject();
            addRoot (restaurant);
            italyRestaurant.close ();
        }

        @FXML
        void japanClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (4);
            Main.printWriter.flush ();
            ObjectInputStream japanRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) japanRestaurant.readObject();
            addRoot (restaurant);
            japanRestaurant.close ();

        }

        @FXML
        void lebenonClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (6);
            Main.printWriter.flush ();
            ObjectInputStream lebenonRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) lebenonRestaurant.readObject();
            addRoot (restaurant);
            lebenonRestaurant.close ();
        }

        @FXML
        void mexicoClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (8);
            Main.printWriter.flush ();
            ObjectInputStream mexicoRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) mexicoRestaurant.readObject();
            addRoot (restaurant);
            mexicoRestaurant.close ();
        }

        @FXML
        void turkeyClick(MouseEvent event) throws IOException, ClassNotFoundException {
            Main.printWriter.println (10);
            Main.printWriter.flush ();
            ObjectInputStream turkeyRestaurant=new ObjectInputStream ( Main.socket.getInputStream () );
            restaurant= ( ArrayList<Restaurant> ) turkeyRestaurant.readObject();
            addRoot (restaurant);
            turkeyRestaurant.close ();

        }

        public void addRoot(ArrayList<Restaurant> restaurant) throws IOException {
            FXMLLoader restaurantList=new FXMLLoader ( Main.class.getResource ("view/RestaurantList.fxml") );
            restaurantList.load ();
            RestaurantListController restaurantListController=restaurantList.getController ();
            for(int i=0;i<restaurant.size ();i++){
                restaurant.get(i).load();
                restaurantListController.getRoot ().getChildren ().add (restaurant.get (i).getPage ().getRoot ());
            }
            Stage stage=new Stage ();
            stage.setTitle ("Restaurant list");
            stage.setScene (new Scene ( restaurantList.getRoot ()));
            stage.show ();
        }
    }

