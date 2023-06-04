package ir.gambaloo.server;

import java.io.*;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientServer extends Thread {
    private Socket socket;
    private BufferedReader reciver;
    private PrintWriter printWriter;
    public  ClientServer(Socket socket) throws IOException {
        this.socket=socket;
        reciver=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter=new PrintWriter(socket.getOutputStream(),true);
    }

    @Override
    public void run() {
        while (true){
            try {
                int code=reciver.read();
                if(code==2){
                    String username=reciver.readLine();
                    int i=0;
                    for (i=0;i<Server.users.size();i++){
                        if(Server.users.get(i).getUsername().equals(username)){
                            break;
                        }}
                    if(i==Server.users.size()){
                        printWriter.println(-1);//Username doesnot exist
                    }else{
                        printWriter.println(1);
                        String password=reciver.readLine();
                        if(Server.users.get(i).getPassword().equals(password)){
                            printWriter.println(0);
                            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeObject(Server.users.get(i));
                            objectOutputStream.flush();
                            objectOutputStream.close();
                            break;
                        }else{
                            printWriter.println(-1);
                        }
                    }

                }else{

                }





            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

