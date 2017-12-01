package mk.ukim.finki.wp.web.lab03;

import com.sun.org.apache.xpath.internal.operations.Or;
import mk.ukim.finki.wp.web.lab03.model.Order;
import mk.ukim.finki.wp.web.lab03.service.OrderService;
import mk.ukim.finki.wp.web.lab03.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.HashMap;


/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
@Controller
public class PizzaOrderController {

    private PizzaService pizzaService;
    private OrderService orderService;

    @Autowired
    public PizzaOrderController(PizzaService pizzaService, OrderService orderService) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("size", pizzaService.getPizzaTypes());
        return modelAndView;
    }

    @RequestMapping(value = "/PizzaOrder")
    public ModelAndView setSize(@RequestParam String size, HttpSession session) {
        session.setAttribute("size", size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DeliveryInformation");
        return modelAndView;
    }

    @RequestMapping(value = "/AddressInformation")
    public ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress,
                                   HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderOverview");
        Order order = orderService.placeOrder(session.getAttribute("size").toString(),
                clientName, clientAddress);

        HashMap<Long, Order> hashMap = new HashMap<>();
        if (session.getAttribute("orders") != null) {
            hashMap = (HashMap<Long, Order>) session.getAttribute("orders");
            hashMap.put(order.orderId, order);
            session.setAttribute("orders", hashMap);
        }
        else {
            hashMap.put(order.orderId, order);
            session.setAttribute("orders", hashMap);
        }

        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = "/vieworderbyid/{id}")
    public ModelAndView viewOrderById(@PathVariable String id, HttpSession session) {
        HashMap<Long, Order> hashMap = new HashMap<>();
        hashMap = (HashMap<Long, Order>) session.getAttribute("orders");
        Order order = hashMap.get(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderOverview");
        modelAndView.addObject(order);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteorderbyid/{id}")
    public ModelAndView deleteOrderById(@PathVariable String id, HttpSession session) {
        HashMap<Long, Order> hashMap = new HashMap<>();
        hashMap = (HashMap<Long, Order>) session.getAttribute("orders");
        hashMap.remove(Long.parseLong(id));
        session.setAttribute("orders", hashMap);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("size", pizzaService.getPizzaTypes());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteall")
    public ModelAndView deleteAllOrders(HttpSession session) {
        HashMap<Long, Order> hashMap = new HashMap<>();
        session.setAttribute("orders", hashMap);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("size", pizzaService.getPizzaTypes());
        return modelAndView;
    }

}
