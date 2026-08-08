package q3;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

    private static final String CART_ATTRIBUTE = "cart";

    /**
     * Handles GET requests and displays the current shopping cart.
     */
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<String> cartItems = getCartItems(request);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Shopping Cart</title></head>");
        out.println("<body>");

        out.println("<h1>Shopping Cart</h1>");

        if (cartItems.isEmpty()) {

            out.println("<p>Your cart is empty.</p>");

        } else {

            out.println("<ul>");

            for (String item : cartItems) {
                out.println("<li>" + item + "</li>");
            }

            out.println("</ul>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Handles POST requests for adding an item to the cart.
     */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getParameter("item");

        if (item != null && !item.trim().isEmpty()) {

            addItemToCart(request, item.trim());
        }

        response.sendRedirect(
                request.getContextPath() + "/shopping-cart"
        );
    }

    /**
     * Adds an item to the shopping cart stored in the user's session.
     */
    private void addItemToCart(
            HttpServletRequest request,
            String item) {

        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked")
        List<String> cartItems =
                (List<String>) session.getAttribute(CART_ATTRIBUTE);

        if (cartItems == null) {

            cartItems = new ArrayList<>();

            session.setAttribute(
                    CART_ATTRIBUTE,
                    cartItems
            );
        }

        cartItems.add(item);
    }

    /**
     * Retrieves the shopping cart items from the user's session.
     */
    private List<String> getCartItems(
            HttpServletRequest request) {

        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked")
        List<String> cartItems =
                (List<String>) session.getAttribute(CART_ATTRIBUTE);

        if (cartItems == null) {

            cartItems = new ArrayList<>();

            session.setAttribute(
                    CART_ATTRIBUTE,
                    cartItems
            );
        }

        return cartItems;
    }
}
