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

        if (purchase.getQuantity() > 0) {
            boolean wantDelivery = Boolean.parseBoolean(data[3]);
            OrderComponent model = wantDelivery ? new DeliveryOrder() : new InStoreOrder();
            output = generateOutput(buyer, model, purchase);
        } else {
            output = "\nInvalid quantity entered.";
        }

        view.getOutput(output);
    }

    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[1]);
    }

    private Purchase getPurchase(String[] data) {
        double quantity = Double.parseDouble(data[2]);
        boolean wantDelivery = Boolean.parseBoolean(data[3]);
        return new Purchase(quantity, wantDelivery);
    }

    private String generateOutput(Buyer buyer, OrderComponent model, Purchase purchase) {
        double totalCost = model.calcPayment(purchase);
        String payment = Rounder.roundValue(totalCost);
        return "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                "\nTotal payment is " + CURRENCY + " " + payment;
    }
}
