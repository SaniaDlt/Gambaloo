package ir.gambaloo.module;

/**
 * Gateway is way to charge your balance :D
 */

public abstract class Gateway {
    protected double price;

    public Gateway ( double price ) {
        this.price = price;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

}
