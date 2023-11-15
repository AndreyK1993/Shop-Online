package shop_online.entity;


public class Purchase {

    private final double order;
    private final double price;

    public Purchase(double order, double price) {

        this.order = order;
        this.price = price;

    }

    public double getOrder() { return order;}

    public double getPrice() { return price;}
}
