package ir.gambaloo.module;

public class TaxGateway extends Gateway{
    private static final double taxRate=0.05;

    public TaxGateway(double price) {
        super(price+price*taxRate);
    }

}
