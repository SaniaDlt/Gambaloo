package ir.gambaloo.module;


import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Restaurant implements Serializable {
    protected int startHour,endHour;
    protected Menu menu=new Menu();
    protected String address;
    protected Country country;
    protected String name;
    protected RestaurantType type;

    public String getCountry() {
        return ""+country;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return ""+type;
    }

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

    public Restaurant(int startHour, int endHour, String address,Country country,String name) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.address = address;
        this.country=country;
        this.name=name;
    }
    public String workHour(){
        return "From "+startHour+"To "+endHour;
    }

}
