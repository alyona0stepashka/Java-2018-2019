import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Point222", urlPatterns = {"/Point222"})
public class Point222 extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String res = request.getParameter("Value");
		request.getSession().setAttribute("Point222", res);
		request.getRequestDispatcher("Point221.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String res = request.getParameter("Value");
		request.getSession().setAttribute("Point222", res);
		//request.getRequestDispatcher("Point223.jsp").forward(request, response);
		response.sendRedirect("Point223.jsp");
	}
}