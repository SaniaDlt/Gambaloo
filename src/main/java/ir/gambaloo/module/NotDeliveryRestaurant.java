package ir.gambaloo.module;

public class NotDeliveryRestaurant extends Restaurant{

    private int chairs=0;
    public NotDeliveryRestaurant(int startHour, int endHour, String address,int chairs,Country country,String name) {
        super(startHour, endHour, address,country,name);
        this.chairs=chairs;
        type=RestaurantType.NOTDELIVERY;
    }


    public int getChairs() {
        return chairs;
    }
}
