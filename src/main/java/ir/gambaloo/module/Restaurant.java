package ir.gambaloo.module;


import javafx.scene.image.Image;

import java.io.Serializable;
enum RestaurantType{
    DELIVERY,NOTDELIVERY
}

public abstract class Restaurant implements Serializable {
    protected int startHour,endHour;
    protected Menu menu=new Menu();
    protected String address;

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getAddress() {
        return address;
    }

    public Restaurant(int startHour, int endHour, String address) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.address = address;
    }
    public String workHour(){
        return "From "+startHour+"To "+endHour;
    }

}
