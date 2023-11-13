package shop_online.model;

import shop_online.entity.Purchase;

public interface OrderComponent {

    double calcPayment(Purchase purchase);
}
