package ir.gambaloo.server;

import ir.gambaloo.Main;
import ir.gambaloo.module.DeliveryRestaurant;
import ir.gambaloo.module.NotDeliveryRestaurant;
import ir.gambaloo.module.Restaurant;
import ir.gambaloo.module.User;

import java.io.*;
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
        boolean isClient=false;
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
                                }else{
                                    isClient=true;
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
            if(isAdmin){
                int end=reciver.nextInt();
                if(end==0){
                    ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                    Server.deliveryRestaurants=(ArrayList<DeliveryRestaurant>) objectInputStream.readObject();
                    Server.notDeliveryRestaurants=(ArrayList<NotDeliveryRestaurant>) objectInputStream.readObject();
                }
            }if(isClient){//Client
                while (true) {
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
                                        write.writeObject ( seprator ( "LEBENON" ) );
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
                                }else if(code==-1){
                                    ObjectInputStream objectInputStream=new ObjectInputStream (socket.getInputStream ());
                                    User user=(User)objectInputStream.readObject ();
                                    for(int i=0;i<Server.users.size ();i++){
                                        if(Server.users.get (i ).getUsername ().equals (user.getUsername ())){
                                            Server.users.get (i).setBalance (user.getBalance ());
                                            Server.users.get(i).setCart (user.getCart ());
                                        }

                                    }

                                }
                            }

                    }catch ( EOFException e ){
                        System.out.println ("Dali darling");
                    }
                }
            }

        } catch ( IOException e ) {
            System.out.println ( e );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException ( e );
        }
    }
    public ArrayList<Restaurant> seprator(String Country){
        ArrayList<Restaurant> restaurants=new ArrayList<>();
        for(int i=0;i<Server.deliveryRestaurants.size();i++)
            if(Server.deliveryRestaurants.get(i).getCountry().equalsIgnoreCase(Country)){
                restaurants.add(Server.deliveryRestaurants.get(i));
            }
        for(int i=0;i<Server.notDeliveryRestaurants.size();i++)
            if(Server.notDeliveryRestaurants.get(i).getCountry().equalsIgnoreCase(Country)){
                restaurants.add(Server.notDeliveryRestaurants.get(i));
            }
        return restaurants;
    }
    public void imagesender(String address) throws IOException {
        int i;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(address);
        } catch (FileNotFoundException e) {
            fis=null;
        }
        if(fis==null){
            fis=new FileInputStream("/pics/default.png");
        }
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        while ((i = fis.read()) > -1)
            os.write(i);

        fis.close();
    }
}



