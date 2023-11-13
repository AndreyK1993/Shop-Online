package shop_online.model.impl;

import shop_online.entity.Purchase;
import shop_online.model.OrderComponent;

public class DeliveryOrder implements OrderComponent {

    double[] discountRates = {5, 10};

    @Override
    public double calcPayment(Purchase purchase) {
        double cost = purchase.getOrder();
        if (cost <= 200) {
            return cost + cost * discountRates[0] / 100;
        } else {
            return cost + cost * discountRates[1] / 100;
        }
    }
}
