package ir.gambaloo.module;

public class TaxGateway extends Gateway{
    public static final double taxRate=0.05;

    public TaxGateway(int price) {
        super(price+price*taxRate);
    }

}
