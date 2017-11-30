package mk.ukim.finki.wp.web.lab03;

import mk.ukim.finki.wp.web.lab03.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
@Controller
public class PizzaOrderController {

    private PizzaService pizzaService;

    @Autowired
    public PizzaOrderController(PizzaService pizzaService) {this.pizzaService = pizzaService;}

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("size", pizzaService.getPizzaTypes());
        return modelAndView;
    }

    @RequestMapping(value = "/PizzaOrder")
    public void setSize(@RequestParam String size, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("size", size);
        response.sendRedirect("/DeliveryInfo.html");
    }

}
