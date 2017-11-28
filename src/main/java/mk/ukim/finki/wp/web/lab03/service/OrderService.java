package mk.ukim.finki.wp.web.lab03.service;

import mk.ukim.finki.wp.web.lab03.model.Order;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
public interface OrderService {
    public Order placeOrder(String pizzaType, String clientName, String address);
}
