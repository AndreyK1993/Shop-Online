// OrderController.java
package shop_online.controller;

import shop_online.entity.Buyer;
import shop_online.entity.Purchase;
import shop_online.model.OrderComponent;
import shop_online.model.impl.DeliveryOrder;
import shop_online.model.impl.InStoreOrder;
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

        boolean deliveryOption = view.wantDelivery();
        if (deliveryOption) {
            DeliveryOrder model = new DeliveryOrder();
            output = generateOutput(buyer, model, purchase);
        } else {
            InStoreOrder model = new InStoreOrder();
            output = generateOutput(buyer, model, purchase);
        }

        view.getOutput(output);
    }

    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[1]);
    }

    private Purchase getPurchase(String[] data) {
        return new Purchase(Double.parseDouble(data[2]), Double.parseDouble(data[2]));
    }

    private String generateOutput(Buyer buyer, OrderComponent model, Purchase purchase) {
        String payment = Rounder.roundValue(model.calcPayment(purchase));
        return "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                "\nPayment is " + CURRENCY + " " + payment;
    }
}
