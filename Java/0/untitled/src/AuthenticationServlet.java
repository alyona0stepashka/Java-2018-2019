import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String address = request.getParameter("address");

        response.addCookie(new Cookie("login", login));
        response.addCookie(new Cookie("address", address));

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("login")){
                cookie.setValue(login);
                response.addCookie(cookie);
            }

            if (cookie.getName().equals("address")) {
                cookie.setValue(address);
                response.addCookie(cookie);
            }
        }

        request.getRequestDispatcher("next.jsp").forward(request, response);
    }
}