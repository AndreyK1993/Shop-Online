package shop_online;

import shop_online.controller.OrderController;

public class App {

    public static void main(String[] args) {
        OrderController controller = new OrderController();
        controller.getPayment();
    }
}
