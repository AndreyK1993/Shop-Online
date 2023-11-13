package shop_online.model;

import shop_online.entity.Purchase;

public interface AppModel {

    double calcPayment(Purchase purchase);
}
