package mk.ukim.finki.wp.web.lab03;

import mk.ukim.finki.wp.web.lab03.service.OrderService;
import mk.ukim.finki.wp.web.lab03.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


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
        modelAndView.addObject("order", orderService.placeOrder(session.getAttribute("size").toString(),
                clientName, clientAddress));
        return modelAndView;
    }
}
