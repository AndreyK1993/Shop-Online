package shop_online.entity;

public class Purchase {

    private final double quantity;
    private final double price;
    private final boolean wantDelivery;

    public Purchase(double quantity, double price, boolean wantDelivery) {
        this.quantity = quantity;
        this.price = price;
        this.wantDelivery = wantDelivery;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean wantDelivery() {
        return wantDelivery;
    }
}
