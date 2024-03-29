package ir.gambaloo.server;

/**
 * Comms between server and client
 * 0 stands for success
 * 1 stands for waite to receive next element
 * -1 stands for not successful
 */

import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.module.User;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientServer extends Thread {
    private final Socket socket;
    private final Scanner reciver;
    private final String imagePath = "src/main/java/ir/gambaloo/server/pics/";
    private final PrintWriter printWriter;

    public ClientServer ( Socket socket ) throws IOException {
        this.socket = socket;
        reciver = new Scanner ( socket.getInputStream ( ) );
        printWriter = new PrintWriter ( socket.getOutputStream ( ) , true );
    }

    @Override
    public void run ( ) {
        boolean isAdmin = false;
        boolean isClient = false;
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
                                if ( username.equals ( "admin" ) ) {
                                    printWriter.println ( 3 );
                                    printWriter.flush ( );
                                    isAdmin = true;
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream ( socket.getOutputStream ( ) );
                                    objectOutputStream.writeObject ( Server.deliveryRestaurants );
                                    objectOutputStream.flush ( );
                                    objectOutputStream.writeObject ( Server.notDeliveryRestaurants );
                                    objectOutputStream.flush ( );
                                } else {
                                    isClient = true;
                                    printWriter.println ( 0 );
                                    printWriter.flush ( );
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream ( socket.getOutputStream ( ) );
                                    objectOutputStream.writeObject ( Server.users.get ( i ) );
                                    objectOutputStream.flush ( );

                                }
                                break;
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
            if ( isAdmin ) {
                int end = reciver.nextInt ( );
                if ( end == 0 ) {
                    ObjectInputStream objectInputStream = new ObjectInputStream ( socket.getInputStream ( ) );
                    Server.deliveryRestaurants = ( ArrayList<DeliveryRestaurant> ) objectInputStream.readObject ( );
                    Server.notDeliveryRestaurants = ( ArrayList<NotDeliveryRestaurant> ) objectInputStream.readObject ( );
                }
            }
            if ( isClient ) {//Client
                while ( true ) {
                    int code;
                    try {
                        if ( reciver.hasNext ( ) ) {
                            code = reciver.nextInt ( );

                            if ( code >= 4 && code <= 10 ) {
                                ObjectOutputStream write = new ObjectOutputStream ( socket.getOutputStream ( ) );
                                if ( code == 4 ) {//japan
                                    write.writeObject ( seprator ( "JAPAN" ) );
                                } else if ( code == 5 ) {//Italy
                                    write.writeObject ( seprator ( "ITALY" ) );
                                } else if ( code == 6 ) {//Lebnan
                                    write.writeObject ( seprator ( "LEBANON" ) );
                                } else if ( code == 7 ) {//Iran
                                    write.writeObject ( seprator ( "IRAN" ) );
                                } else if ( code == 8 ) {//Mexico
                                    write.writeObject ( seprator ( "MEXICO" ) );
                                } else if ( code == 9 ) {//America
                                    write.writeObject ( seprator ( "AMERICA" ) );
                                } else {//Turkey
                                    write.writeObject ( seprator ( "TURKEY" ) );
                                }
                                write.flush ( );
                            } else if ( code == - 1 ) {
                                ObjectInputStream objectInputStream = new ObjectInputStream ( socket.getInputStream ( ) );
                                User user = ( User ) objectInputStream.readObject ( );
                                for ( int i = 0 ; i < Server.users.size ( ) ; i++ ) {
                                    if ( Server.users.get ( i ).getUsername ( ).equals ( user.getUsername ( ) ) ) {
                                        Server.users.get ( i ).setBalance ( user.getBalance ( ) );
                                        Server.users.get ( i ).setCart ( user.getCart ( ) );
                                    }

                                }

                            } else if ( code == 11 ) {
                                String image = reciver.next ( );
                                imagesender ( image );
                            }
                        }

                    } catch ( EOFException e ) {
                        System.out.println ( "Dali darling" );
                    }
                }
            }

        } catch ( IOException e ) {
            System.out.println ( e );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException ( e );
        }
    }

    public ArrayList<Restaurant> seprator ( String Country ) {
        ArrayList<Restaurant> restaurants = new ArrayList<> ( );
        for ( int i = 0 ; i < Server.deliveryRestaurants.size ( ) ; i++ )
            if ( Server.deliveryRestaurants.get ( i ).getCountry ( ).equalsIgnoreCase ( Country ) && Server.deliveryRestaurants.get(i).isEnable() ) {
                restaurants.add ( Server.deliveryRestaurants.get ( i ) );
            }
        for ( int i = 0 ; i < Server.notDeliveryRestaurants.size ( ) ; i++ )
            if ( Server.notDeliveryRestaurants.get ( i ).getCountry ( ).equalsIgnoreCase ( Country ) && Server.notDeliveryRestaurants.get(i).isEnable() ) {
                restaurants.add ( Server.notDeliveryRestaurants.get ( i ) );
            }

        return restaurants;
    }

    public void imagesender ( String address ) throws IOException {
        Path imagePath = Paths.get ( this.imagePath + address );
        byte[] imageData;
        try {
            imageData = Files.readAllBytes ( imagePath );
        } catch ( IOException e ) {
            imagePath = Paths.get ( this.imagePath + "Default.jpg" );
            imageData = Files.readAllBytes ( imagePath );
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream ( socket.getOutputStream ( ) );
        objectOutputStream.writeObject ( imageData );
        objectOutputStream.flush ( );
    }
}



