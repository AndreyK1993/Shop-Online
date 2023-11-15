package shop_online.model.impl;

import shop_online.entity.Purchase;
import shop_online.model.OrderComponent;

public class InStoreOrder implements OrderComponent {

    public double calcPayment(Purchase purchase) {

        return purchase.getQuantity();
    }
}
