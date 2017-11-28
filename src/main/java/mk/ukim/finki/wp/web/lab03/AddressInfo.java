package mk.ukim.finki.wp.web.lab03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddressInfo.do")
public class AddressInfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<label>Size:</label>" + (String) request.getSession().getAttribute("size"));
        out.println("<br><label>Name:</label>" + request.getParameter("name"));
        out.println("<br><label>Address:</label>" + request.getParameter("address"));
        String userAgent = request.getHeader("User-Agent");
        out.println("<br><label>OS and browser:</label>" + userAgent);
    }
}
