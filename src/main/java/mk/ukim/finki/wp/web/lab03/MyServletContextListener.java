package mk.ukim.finki.wp.web.lab03;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String path = sc.getInitParameter("path");
        String mode = sc.getInitParameter("mode");
        sc.setAttribute("filePath", path);
        sc.setAttribute("fileMode", mode);
        System.out.println("Value saved in context.");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("path");
        sc.removeAttribute("mode");
        System.out.println("Value deleted from context.");
    }
}
