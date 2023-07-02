package ir.gambaloo.module;

/**
 * This class extend Restaurant that define delivery restaurants and contains number of deliveries
 * and restaurant type
 */

public class DeliveryRestaurant extends Restaurant {
    private int deliveries;

    public void setDeliveries(int deliveries) {
        this.deliveries = deliveries;
    }

    public DeliveryRestaurant(int startHour, int endHour, String address, int delivery, Country country, String name, String imageAddress) {
        super(startHour, endHour, address, country, name, imageAddress);
        deliveries = delivery;
        type = RestaurantType.DELIVERY;
    }


    public int getDeliveries() {
        return deliveries;
    }
}
