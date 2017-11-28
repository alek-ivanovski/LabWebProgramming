package mk.ukim.finki.wp.web.lab03.service.impl;

import mk.ukim.finki.wp.web.lab03.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
public class OrderServiceImplTest {
    OrderServiceImpl orderService;

    @Before
    public void setup() {
        orderService = new OrderServiceImpl();
    }

    @Test
    public void test_place_order() {
        String pizzaType = "pizzaType";
        String clientName = "clientName";
        String clientAddress = "clientAddress";

        Order actual = orderService.placeOrder(pizzaType, clientName, clientAddress);

        assertNotNull(actual);
        assertEquals(actual.pizzaType, pizzaType);
        assertEquals(actual.clientName, clientName);
        assertEquals(actual.clientAddress, clientAddress);
        assertNotNull(actual.orderId);
    }
}