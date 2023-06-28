package ir.gambaloo.module;
/**
 *LimitGateway is Gateway with a condition : User should at least buy minprice to make a purchase
 * */
public class LimitGateway extends Gateway{
    private static double minPrice=15;
    public LimitGateway(double price) {
        super(price);
    }

    public static double getMinPrice() {
        return minPrice;
    }
}
