package ir.gambaloo.server;

import java.io.*;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientServer extends Thread {
    private Socket socket;
    private Scanner reciver;
    private PrintWriter printWriter;
    public  ClientServer(Socket socket) throws IOException {
        this.socket=socket;
        reciver=new Scanner(socket.getInputStream());
        printWriter=new PrintWriter(socket.getOutputStream(),true);
    }

    @Override
    public void run() {
        try {
            while (true) {

                int code = reciver.nextInt();
                if (code == 2) {
                    String username = reciver.next();
                    int i = 0;
                    for (i = 0; i < Server.users.size(); i++) {
                        if (Server.users.get(i).getUsername().equals(username)) {
                            break;
                        }
                    }
                    if (i == Server.users.size()) {
                        printWriter.println(-1);//Username doesnot exist
                        printWriter.flush();
                    } else {
                        printWriter.println(1);
                        printWriter.flush();
                        String password = reciver.next();
                        if (Server.users.get(i).getPassword().equals(password)) {
                            printWriter.println(0);
                            printWriter.flush();
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeObject(Server.users.get(i));
                            objectOutputStream.flush();
                            objectOutputStream.close();
                            break;
                        } else {
                            printWriter.println(-1);
                            printWriter.flush();
                        }
                    }

                } else {

                }


            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

