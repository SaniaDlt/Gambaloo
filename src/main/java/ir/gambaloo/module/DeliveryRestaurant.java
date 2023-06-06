package ir.gambaloo.module;

public class DeliveryRestaurant extends Restaurant{
    private final RestaurantType type=RestaurantType.DELIVERY;
    private final int deliverys;

    public DeliveryRestaurant(int startHour, int endHour, String address,int delivery,Country country) {
        super(startHour, endHour, address,country);
        deliverys=delivery;
    }

    public RestaurantType getType() {
        return type;
    }

    public int getDeliverys() {
        return deliverys;
    }
}
