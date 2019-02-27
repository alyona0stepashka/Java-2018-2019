import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("radios")  !=  null)
        {
            if  (request.getParameter("radios").equals("radio1"))
            {
                if((new Date().getHours())<13||(new Date().getHours())>14)
                {
                    request.getSession().setAttribute("Q4", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q4", "Нет");
                }
            }
            if  (request.getParameter("radios").equals("radio2"))
            {
                if((new Date().getHours())>=13&&(new Date().getHours())<=14)
                {
                    request.getSession().setAttribute("Q4", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q4", "Нет");
                }
            }
        }
        response.sendRedirect("index5.jsp");
    }
}
