package ir.gambaloo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
    try{

        Socket client=server.accept();
        System.out.println("Connected");
        Scanner scan=new Scanner(client.getInputStream());

        String str;
        do{
            str=scan.nextLine();
            System.out.println(str);

        }while (!str.equals("END"));
    }catch (IOException e){
        System.out.println(e);
    }finally {
        server.close();
    }
    }
}
