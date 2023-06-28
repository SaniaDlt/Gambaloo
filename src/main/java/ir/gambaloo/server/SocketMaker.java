package ir.gambaloo.server;
/**
 * Makes thread for every client
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketMaker extends Thread {

    public SocketMaker(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private final ServerSocket serverSocket;

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                Socket socket = serverSocket.accept();
                new ClientServer(socket).start();

            } catch (SocketException socketException) {
                if (serverSocket.isClosed()) {
                    System.out.println("Server went offline");
                    run = false;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
