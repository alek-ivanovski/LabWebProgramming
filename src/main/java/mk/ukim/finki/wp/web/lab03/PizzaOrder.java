package mk.ukim.finki.wp.web.lab03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alek Ivanovski on 11/13/2017.
 */
@WebServlet("/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String size = request.getParameter("size");
        request.getSession().setAttribute("size", size);
//        response.setContentType("text/plain");
//        response.getWriter().println((String) request.getSession().getAttribute("size"));
        response.sendRedirect("DeliveryInfo.html");
    }
}