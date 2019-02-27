import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 01.05.2017.
 */
@WebServlet(name = "Main1", urlPatterns = {"/Main1"})
public class Main1 extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("index.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("MyAnswer", (String) request.getSession().getAttribute("get") + " from main");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}