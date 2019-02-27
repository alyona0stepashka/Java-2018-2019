import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("radios")  !=  null)
        {
            if  (request.getParameter("radios").equals("radio1"))
            {
                if(new Date().getMinutes()>20)
                {
                    request.getSession().setAttribute("Q5", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q5", "Нет");
                }
            }
            if  (request.getParameter("radios").equals("radio2"))
            {
                if(new Date().getMinutes()<=20)
                {
                    request.getSession().setAttribute("Q5", "Да");
                }
                else
                {
                    request.getSession().setAttribute("Q5", "Нет");
                }
            }
        }
        int res=0;
        for(int i=1;i<=5;i++)
        {
            if(request.getSession().getAttribute("Q"+i)=="Да")
            {
                res++;
            }
        }
        request.getSession().setAttribute("result", "Привильно "+res+"/5");
        response.sendRedirect("index6.jsp");
    }
}
