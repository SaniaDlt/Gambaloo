package ir.gambaloo.server;

import ir.gambaloo.module.Country;
import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    private final static String saveFile="save";
    protected static ArrayList<User> users=new ArrayList<>();
    protected static ArrayList<DeliveryRestaurant> deliveryRestaurants=new ArrayList<>();
    protected static ArrayList<NotDeliveryRestaurant>notDeliveryRestaurants=new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }


    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(8283);
            FileInputStream file=new FileInputStream (saveFile);
            ObjectInputStream object=new ObjectInputStream (file);
            users= (ArrayList<User>)object.readObject();
            deliveryRestaurants= (ArrayList<DeliveryRestaurant>)object.readObject();
            notDeliveryRestaurants= (ArrayList<NotDeliveryRestaurant>)object.readObject();
            object.close ();
            file.close ();
            User user = new User("ali@sania.noob", "admin", "admin", "0902", "Paradise");
            users.add(user);
            Scanner scan=new Scanner (System.in);
            new SocketMaker(server).start();
            while (!scan.next ().equals ("Exit"));
            server.close ();
        }catch (IOException E){
            System.err.println(E);
        }catch ( ClassNotFoundException e ) {
            throw new RuntimeException ( e );
        }finally {
            FileOutputStream file=new FileOutputStream ( saveFile );
            ObjectOutputStream object=new ObjectOutputStream (file);
            object.writeObject (users);
            object.writeObject (deliveryRestaurants);
            object.writeObject (notDeliveryRestaurants);
            object.close ();
            file.close ();
            System.out.println ("Save successfully");
        }
    }
}
