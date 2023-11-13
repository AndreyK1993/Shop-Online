package shop_online.model.impl;

import shop_online.entity.Purchase;
import shop_online.model.AppModel;

public class AppBaseModel implements AppModel {

    public double calcPayment(Purchase purchase) {
        return purchase.getQuota() * purchase.getPrice();
    }
}
