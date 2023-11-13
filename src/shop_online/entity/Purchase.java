package shop_online.entity;

public class Purchase {

    private final int quota;
    private final double price;

    public Purchase(int quota, double price) {
        this.quota = quota;
        this.price = price;
    }

    public int getQuota() {
        return quota;
    }

    public double getPrice() {
        return price;
    }
}
