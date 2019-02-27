import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("radios")  !=  null)
        {
            if  (request.getParameter("radios").equals("radio1"))
            {
                if((new Date().getMonth()+1)==12||(new Date().getMonth()+1)==1||(new Date().getMonth()+1)==2)
                {
                    request.getSession().setAttribute("Q3", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q3", "Нет");
                }
            }
            if  (request.getParameter("radios").equals("radio2"))
            {
                if((new Date().getMonth()+1)!=12||(new Date().getMonth()+1)!=1||(new Date().getMonth()+1)!=2)
                {
                    request.getSession().setAttribute("Q3", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q3", "Нет");
                }
            }
        }
        response.sendRedirect("index4.jsp");
    }
}
