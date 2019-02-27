import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

@WebServlet(name = "LoginAndPassword", urlPatterns = {"/LoginAndPassword"})
public class LoginAndPassword extends HttpServlet
{
	// JDBC driver name and database URL
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/users";
	static final String USER = "root";
	static final String PASS = "root";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	static String Role = "";

	private String IsCorrectLoginAndPassword(String login, String password, HttpServletResponse response) throws IOException
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//response.getWriter().println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query;
			query = "SELECT " + "  Role, " + "  Name " + "FROM userstable WHERE Login='" + login + "' AND Password='" + password + "'";
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				Role = rs.getString("Role");
				return rs.getString("Name");
			}
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
		return "";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Login = request.getParameter("Login");
		System.out.println(Login);
		String Password = request.getParameter("Password");
		System.out.println(Password);
		String name = "";
		if((name = IsCorrectLoginAndPassword(Login, Password, response)) != "")
		{
			//response.getWriter().println("Name = " + name);
			//response.getWriter().println("Role = " + Role);
			//response.getWriter().println("Time now = " + LocalDateTime.now());
			request.getServletContext().log("Auth " + name + " is succesful");

			HttpSession session = request.getSession(true);

			session.setAttribute("Role", Role);
			session.setAttribute("TimeStart", LocalDateTime.now());
			session.setAttribute("Name", name);
			Cookie[] last = request.getCookies();
			boolean flag = false;
			for(int i = 0; i < last.length; i++)
			{
				Cookie buffer = last[i];
				if(buffer.getName() == "KolVisits")
				{
					int gg = Integer.parseInt(buffer.getValue() + 1);
					buffer.setValue(Integer.toString(gg));
					flag = true;
				}
			}
			if(!flag)
			{
				Cookie cc = new Cookie("KolVisits", "1");
				response.addCookie(cc);
			}
			Cookie cookie = new Cookie("LastSession", LocalDateTime.now().toString());
			response.addCookie(cookie);
			response.addCookie(new Cookie("Role", Role));
			request.setAttribute("Role", Role);
			response.setHeader("Role", Role);
			request.getRequestDispatcher("/GoodLogin.jsp").forward(request, response);
		} else
		{
			//response.getWriter().println("Error with your roots");
			//response.getWriter().println("May be you want to register?");
			response.getWriter().println("<html><head><title>May be register?</title></head><body><p>May be you want to register?)</p><a href=\"Registration.jsp\">Go to registration</a></body></html>");
		}

	}
}
