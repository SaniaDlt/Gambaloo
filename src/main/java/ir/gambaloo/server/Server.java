package ir.gambaloo.server;

import ir.gambaloo.module.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    protected static ArrayList<User> users=new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9090);
        User user=new User("Mamad@gmail.com","admin","admin","0902","asde");
        users.add(user);
        while (true){
        Socket socket = server.accept();
        new ClientServer(socket).start();
        }

    }


}
