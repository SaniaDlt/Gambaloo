package ir.gambaloo.module;

public abstract class Gateway {
    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    protected double price;

    public Gateway(double price) {
        this.price = price;
    }

}
