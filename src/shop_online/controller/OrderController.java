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

    //метод, который инициирует процесс оформления заказа
    public void getPayment() {
        String[] data = view.getData(); //получение данных от пользователя через представление.
        Buyer buyer = getBuyer(data); // создание объекта Buyer на основе введенных данных о покупателе.
        Purchase purchase = getPurchase(data); //создание объекта Purchase на основе введенных данных о заказе
        String output;

        //проверка на корректность введенного количества товара
        if (purchase.getQuantity() > 0) {
            boolean wantDelivery = Boolean.parseBoolean(data[3]); //определение, нужна ли доставка
            OrderComponent model = wantDelivery ?
                    new DeliveryOrder() : new InStoreOrder(); //создание соответствующего объекта модели в зависимости от выбора доставки
            output = generateOutput(buyer, model, purchase); //вызов метода для генерации вывода на основе данных
        } else {
            output = "\nInvalid quantity entered.";
        }

        view.getOutput(output); //передача сгенерированного вывода в представление для отображения
    }

    //метод для создания объекта Buyer на основе данных, полученных от пользователя
    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[1]);
    }

    //метод для создания объекта Purchase на основе данных, полученных от пользователя
    private Purchase getPurchase(String[] data) {
        double quantity = Double.parseDouble(data[2]);
        boolean wantDelivery = Boolean.parseBoolean(data[3]);
        return new Purchase(quantity, wantDelivery);
    }

    //метод для генерации текста вывода на основе данных о покупателе, заказе и модели оплаты
    private String generateOutput(Buyer buyer, OrderComponent model, Purchase purchase) {
        double totalCost = model.calcPayment(purchase);
        String payment = Rounder.roundValue(totalCost);
        return "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                "\nTotal payment is " + CURRENCY + " " + payment;
    }
}
