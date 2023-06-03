package ir.gambaloo.module;

public class DeliveryRestaurant extends Restaurant{
    private RestaurantType type=RestaurantType.DELIVERY;
    private int deliverys;

    public DeliveryRestaurant(int startHour, int endHour, String address,int delivery) {
        super(startHour, endHour, address);
        deliverys=delivery;
    }

    public RestaurantType getType() {
        return type;
    }

    public int getDeliverys() {
        return deliverys;
    }
}
