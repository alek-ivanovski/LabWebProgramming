package mk.ukim.finki.wp.web.lab03.service.impl;

import mk.ukim.finki.wp.web.lab03.model.Order;
import mk.ukim.finki.wp.web.lab03.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {
    public Order placeOrder(String pizzaType, String clientName, String address){
        Random r = new Random();

        Order order = new Order();
        order.pizzaType = pizzaType;
        order.clientName = clientName;
        order.clientAddress = address;
        order.orderId = r.nextLong();
        return order;
    }
}
