package ir.gambaloo;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientServer {
    public static void main(String[] args){
        try (
                Socket client=new Socket("localhost",8080);
                Scanner scan=new Scanner(client.getInputStream());
                Scanner sc=new Scanner(System.in);
                Formatter f=new Formatter(client.getOutputStream());
                ){
                String str;
                while(true){
                    str=sc.nextLine();
                    if(str.equals("Exit")){
                        f.format("\nEND");
                        break;
                    }
                    f.format("%s\n",str);
                    f.flush();


                }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
