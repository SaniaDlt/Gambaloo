package ir.gambaloo.module;
/**
 * Restaurant contains menu address country name imageAddress(address that is near server) and
 * Restaurant type
 * Also it save two parameter as int for start hour and end hour
 */

import java.io.Serializable;

public class Restaurant implements Serializable {
    protected int startHour, endHour;
    protected Menu menu = new Menu ( );
    protected String address;
    protected Country country;
    protected String name;
    protected RestaurantType type;
    protected String imageAddress;
    protected boolean enable=true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Restaurant (int startHour , int endHour , String address , Country country , String name , String imageAddress ) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.address = address;
        this.country = country;
        this.name = name;
        this.imageAddress = imageAddress;
    }

    public String getImageAddress ( ) {
        return imageAddress;
    }

    public String getCountry ( ) {
        return String.valueOf ( country );
    }

    public String getName ( ) {
        return name;
    }

    public String getType ( ) {
        return String.valueOf ( type );
    }

    public int getStartHour ( ) {
        return startHour;
    }

    public int getEndHour ( ) {
        return endHour;
    }

    public Menu getMenu ( ) {
        return menu;
    }

    public String getAddress ( ) {
        return address;
    }



}
