import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 12.05.2017.
 */
@WebServlet(name = "Point223", urlPatterns = {"/Point223"})
public class Point223 extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String res = request.getParameter("Value");
		request.getSession().setAttribute("Point223", res);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String res = request.getParameter("Value");
		request.getSession().setAttribute("Point223", res);
		//request.getRequestDispatcher("PointResult.jsp").forward(request, response);
		response.sendRedirect("PointResult.jsp");
	}
}