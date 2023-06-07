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
    protected static ArrayList<User> users=new ArrayList<>();
    protected static ArrayList<DeliveryRestaurant> deliveryRestaurants=new ArrayList<>();
    protected static ArrayList<NotDeliveryRestaurant>notDeliveryRestaurants=new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }


    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8283);
        deliveryRestaurants.add(new DeliveryRestaurant(2,3,"ASDAS",12, Country.IRAN,"SaniaKasif"));
        User user=new User("ali@sania.noob","admin","admin","0902","Paradise");
        users.add(user);
        while (true){
        Socket socket = server.accept();
        new ClientServer(socket).start();
        }

    }


}
