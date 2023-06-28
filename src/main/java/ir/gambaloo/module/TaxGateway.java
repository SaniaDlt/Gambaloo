package ir.gambaloo.module;
/**
 * TaxGateway is a Gateway that charges you with tax (5% taxrate)
 * */
public class TaxGateway extends Gateway{
    public static final double taxRate=0.05;

    public TaxGateway(double price) {
        super(price+price*taxRate);
    }

}
