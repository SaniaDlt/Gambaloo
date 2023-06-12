package ir.gambaloo.module;

public class LimitGateway extends Gateway{
    private static double minPrice=15;
    public LimitGateway(double price) {
        super(price);
    }

    public static double getMinPrice() {
        return minPrice;
    }
}
