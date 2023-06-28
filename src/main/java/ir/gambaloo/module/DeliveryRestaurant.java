package ir.gambaloo.module;
/**
 * This class extend Restaurant that define delivery restaurants and contains number of deliveries
 * and restaurant type
 * */

public class DeliveryRestaurant extends Restaurant{
    private final int deliverys;

    public DeliveryRestaurant(int startHour, int endHour, String address,int delivery,Country country,String name,String imageAddress) {
        super(startHour, endHour, address,country,name,imageAddress);
        deliverys=delivery;
        type=RestaurantType.DELIVERY;
    }



    public int getDeliverys() {
        return deliverys;
    }
}
