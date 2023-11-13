package shop_online.entity;

public class Buyer {

    private final String name;
    private final String phone;

    public Buyer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
