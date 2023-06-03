package ir.gambaloo.module;

public class NotDeliveryRestaurant extends Restaurant{
    private RestaurantType type=RestaurantType.NOTDELIVERY;
    private int chairs=0;
    public NotDeliveryRestaurant(int startHour, int endHour, String address,int chairs) {
        super(startHour, endHour, address);
        this.chairs=chairs;
    }

    public RestaurantType getType() {
        return type;
    }

    public int getChairs() {
        return chairs;
    }
}
