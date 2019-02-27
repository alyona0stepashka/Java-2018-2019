import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BackServlet")
public class BackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String login = "";
        String address = "";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("login")){
                login = cookie.getValue();
            }
            if (cookie.getName().equals("address")){
                address = cookie.getValue();
            }
        }
        request.setAttribute("login", login);
        request.setAttribute("address", address);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
