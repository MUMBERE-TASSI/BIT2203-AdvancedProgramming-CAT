package q6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class LifecycleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("1. init() - Servlet is initialized by the container.");
    }

    @Override
    public void service(javax.servlet.ServletRequest request,
                        javax.servlet.ServletResponse response)
            throws ServletException, java.io.IOException {

        System.out.println("2. service() - Container processes a client request.");

        response.setContentType("text/plain");
        response.getWriter().println(
                "Servlet Container and Lifecycle Demonstration"
        );
    }

    @Override
    public void destroy() {
        System.out.println("3. destroy() - Container removes the servlet.");
    }
}
