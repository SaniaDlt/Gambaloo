package ir.gambaloo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketMaker extends Thread {

    public SocketMaker ( ServerSocket serverSocket ) {
        this.serverSocket = serverSocket;
    }

    private ServerSocket serverSocket;

    @Override
    public void run ( ) {
        while(true){
            try {
                Socket socket =serverSocket.accept();
                new ClientServer(socket).start ();

            } catch ( SocketException socketException ){
                if(serverSocket.isClosed ()){
                    System.out.println ("Server went offline");
                }

            } catch ( IOException e ) {
                throw new RuntimeException ( e );
            }

        }

    }
}
