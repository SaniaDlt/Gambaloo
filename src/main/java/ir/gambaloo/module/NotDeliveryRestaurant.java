package ir.gambaloo.module;

/**
 * is a Restaurant that has chairs instead of delivery
 */
public class NotDeliveryRestaurant extends Restaurant {


    private int chairs;

    public NotDeliveryRestaurant(int startHour, int endHour, String address, int chairs, Country country, String name, String imageAddress) {
        super(startHour, endHour, address, country, name, imageAddress);
        this.chairs = chairs;
        type = RestaurantType.NOTDELIVERY;
    }


    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }
}
