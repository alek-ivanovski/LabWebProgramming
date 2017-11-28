package mk.ukim.finki.wp.web.lab03;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener{
    private static int totalActiveSessions;

    public static int getTotalActiveSession(){
        return totalActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;
        System.out.println("sessionCreated - add one session into counter");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        totalActiveSessions--;
        System.out.println("sessionDestroyed - deduct one session from counter");
    }
}
