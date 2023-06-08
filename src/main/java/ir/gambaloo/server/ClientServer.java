package ir.gambaloo.server;

import ir.gambaloo.Main;
import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientServer extends Thread {
    private  Socket socket;
    private  Scanner reciver;
    private  PrintWriter printWriter;

    public ClientServer ( Socket socket ) throws IOException {
        this.socket = socket;
        reciver = new Scanner ( socket.getInputStream ( ) );
        printWriter = new PrintWriter ( socket.getOutputStream ( ) , true );
    }

    @Override
    public void run ( ) {
        boolean isAdmin=false;
        try {
            while ( true ) {
                if ( reciver.hasNext ( ) ) {
                    int code = reciver.nextInt ( );
                    if ( code == 2 ) {
                        String username = reciver.next ( );
                        int i = 0;
                        for ( i = 0; i < Server.users.size ( ) ; i++ ) {
                            if ( Server.users.get ( i ).getUsername ( ).equals ( username ) ) {
                                break;
                            }
                        }
                        if ( i == Server.users.size ( ) ) {
                            printWriter.println ( - 1 );//Username doesnot exist
                            printWriter.flush ( );
                        } else {
                            printWriter.println ( 1 );
                            printWriter.flush ( );
                            String password = reciver.next ( );
                            if ( Server.users.get ( i ).getPassword ( ).equals ( password ) ) {
                                if(username.equals("admin")){
                                    printWriter.println(3);
                                    printWriter.flush();
                                    isAdmin=true;
                                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                                    objectOutputStream.writeObject(Server.deliveryRestaurants);
                                    objectOutputStream.flush();
                                    objectOutputStream.writeObject(Server.notDeliveryRestaurants);
                                    objectOutputStream.flush();
                                    break;
                                }else{
                                printWriter.println ( 0 );
                                printWriter.flush ( );
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream ( socket.getOutputStream ( ) );
                                objectOutputStream.writeObject ( Server.users.get ( i ) );
                                objectOutputStream.flush ( );
                                objectOutputStream.close ( );
                                break;
                                }
                            } else {
                                printWriter.println ( - 1 );
                                printWriter.flush ( );
                            }
                        }
                    } else if ( code == - 2 ) {
                        String username = reciver.next ( );
                        int i = 0;
                        for ( i = 0; i < Server.users.size ( ) ; i++ ) {
                            if ( Server.users.get ( i ).getUsername ( ).equals ( username ) ) {
                                printWriter.println ( - 1 );
                                printWriter.flush ( );
                                break;
                            }
                        }
                        if ( i == Server.users.size ( ) ) {
                            printWriter.println ( 1 );
                            printWriter.flush ( );
                            String phonenumber = reciver.next ( );
                            for ( i = 0; i < Server.users.size ( ) ; i++ ) {
                                if ( Server.users.get ( i ).getPhoneNumber ( ).equals ( phonenumber ) ) {
                                    printWriter.println ( - 1 );
                                    printWriter.flush ( );
                                    break;
                                }
                            }
                            if ( i == Server.users.size ( ) ) {
                                printWriter.println ( 1 );
                                printWriter.flush ( );
                                String email = reciver.next ( );
                                for ( i = 0; i < Server.users.size ( ) ; i++ ) {
                                    if ( Server.users.get ( i ).getEmailAddress ( ).equals ( email ) ) {
                                        printWriter.println ( - 1 );
                                        printWriter.flush ( );
                                        break;
                                    }
                                }
                                if ( i == Server.users.size ( ) ) {
                                    printWriter.println ( 0 );
                                    printWriter.flush ( );
                                    ObjectInputStream objectInputStream = new ObjectInputStream ( socket.getInputStream ( ) );
                                    Server.users.add ( ( User ) objectInputStream.readObject ( ) );
                                }


                            }


                        }


                    }
                }
            }
            if(isAdmin){
                int end=reciver.nextInt();
                if(end==0){
                    ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                    Server.deliveryRestaurants=(ArrayList<DeliveryRestaurant>) objectInputStream.readObject();
                    Server.notDeliveryRestaurants=(ArrayList<NotDeliveryRestaurant>) objectInputStream.readObject();
                }
            }
        } catch ( IOException e ) {
            System.out.println ( e );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException ( e );
        }
    }
}



