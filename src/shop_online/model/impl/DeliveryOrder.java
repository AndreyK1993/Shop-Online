package shop_online.model.impl;

import shop_online.entity.Purchase;
import shop_online.model.OrderComponent;

public class DeliveryOrder implements OrderComponent {

    double[] taksRates = {5, 10};

    @Override
    public double calcPayment(Purchase purchase) {
        double cost = purchase.getQuantity();
        if (cost <= 200) {
            return cost + cost * taksRates[0] / 100;
        } else {
            return cost + cost * taksRates[1] / 100;
        }
    }
}
