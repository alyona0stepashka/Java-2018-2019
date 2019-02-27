import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Point221", urlPatterns = {"/Point221"})
public class Point221 extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String res = request.getParameter("Value");
		request.getSession().setAttribute("Point221", res);
		//request.getRequestDispatcher("Point222.jsp").forward(request, response);
		response.sendRedirect("Point222.jsp");
	}
}