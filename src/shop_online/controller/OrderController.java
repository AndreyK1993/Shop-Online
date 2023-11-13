package shop_online.controller;

import shop_online.entity.Buyer;
import shop_online.entity.Purchase;
import shop_online.model.impl.InStoreOrder;
import shop_online.model.impl.DeliveryOrder;
import shop_online.utils.Rounder;
import shop_online.view.OrderView;

public class OrderController {

    private final OrderView view = new OrderView();
    private final static String CURRENCY = "USD";

    public void getPayment() {
        String[] data = view.getData();
        Buyer buyer = getBuyer(data);
        Purchase purchase = getPurchase(data);
        String output;

        if (purchase.getOrder() <= 2) {
            InStoreOrder model = new InStoreOrder();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            view.getOutput(output);
        } else {
            DeliveryOrder model = new DeliveryOrder();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            view.getOutput(output);
        }
    }

//    private static void runOption(int option) {
//        switch (option) {
//            case 1 -> {
//                OrderController controller = new OrderController();
//                controller.getDeliveryOrder();
//            }
//            case 2 -> {
//                OrderController controller = new OrderController();
//                controller.getInStoreOrder();
//            }
//            default -> System.out.println("No such option.");
//        }
//    }

    private Buyer getBuyer(String[] data) {

        return new Buyer(data[0], data[1]);
    }

    private Purchase getPurchase(String[] data) {
        return new Purchase(Integer.parseInt(data[2]),
                Double.parseDouble(data[3]));
    }
}
