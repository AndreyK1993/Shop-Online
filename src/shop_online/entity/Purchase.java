// Purchase.java
package shop_online.entity;

public class Purchase {

    private final double quantity;
    private final boolean wantDelivery;

    public Purchase(double quantity, boolean wantDelivery) {
        this.quantity = quantity;
        this.wantDelivery = wantDelivery;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean wantDelivery() {
        return wantDelivery;
    }
}
