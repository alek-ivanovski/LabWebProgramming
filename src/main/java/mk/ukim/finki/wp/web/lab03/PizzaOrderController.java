package mk.ukim.finki.wp.web.lab03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class PizzaOrderController {
    @RequestMapping(value = "/PizzaOrder")
    public void setSize(@RequestParam String size, HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.getSession().setAttribute("size", size);
        response.sendRedirect("/DeliveryInfo.html");
    }

}
