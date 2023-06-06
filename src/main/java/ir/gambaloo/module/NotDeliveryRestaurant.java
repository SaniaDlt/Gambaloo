package ir.gambaloo.module;

public class NotDeliveryRestaurant extends Restaurant{
    private final RestaurantType type=RestaurantType.NOTDELIVERY;
    private int chairs=0;
    public NotDeliveryRestaurant(int startHour, int endHour, String address,int chairs,Country country) {
        super(startHour, endHour, address,country);
        this.chairs=chairs;
    }

    public RestaurantType getType() {
        return type;
    }

    public int getChairs() {
        return chairs;
    }
}
