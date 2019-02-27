import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(LoginAndPassword.DB_URL, LoginAndPassword.USER, LoginAndPassword.PASS);
			String query = "INSERT INTO `userstable`(`Login`,`Password`,`Role`,`Name`)VALUES('" +
					request.getParameter("Login") + "','" +
					request.getParameter("Password") + "','" + "user','+" + request.getParameter("Name") + "')";
			Statement stat = conn.createStatement();
			stat.executeUpdate(query);
			response.sendRedirect("index.jsp");

		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			if(conn != null)
				try
				{
					conn.close();
				} catch(SQLException e)
				{
					e.printStackTrace();
				}
		}
	}
}