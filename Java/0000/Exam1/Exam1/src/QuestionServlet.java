import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int rightQuestions = 0;

        String mname = request.getParameter("mname");
        String pname = request.getParameter("pname");

        response.addCookie(new Cookie("mname", mname));
        response.addCookie(new Cookie("pname", pname));

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("mname")){
                if (cookie.getValue().equals(mname)) {
                    rightQuestions++;
                }
            }

            if (cookie.getName().equals("pname")) {
                if (cookie.getValue().equals(pname)) {
                    rightQuestions++;
                }
            }
        }

        if (rightQuestions == 2) {
            request.getRequestDispatcher("/hello.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect("index.jsp");
        }
    }
}
