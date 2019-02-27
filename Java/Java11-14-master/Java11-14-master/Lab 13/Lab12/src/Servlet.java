import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.getWriter().println(LocalDateTime.now());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//response.getWriter().println("|Servlet protocol</br>");

		/*response.setContentType("text/html");
		ServletConfig servletConfig = this.getServletConfig();
		response.getWriter().println("|Servlet Config</br>");
		response.getWriter().println("Servlet name = " + servletConfig.getServletName()+"</br>");
*/
		response.getWriter().println("|Servlet context</br>");
		ServletContext sc = this.getServletContext();
		response.getWriter().println("Servlet server info = " + sc.getServerInfo() + "\n");
		response.getWriter().println("Servlet context name = " + sc.getServletContextName() + "\n");
		response.getWriter().println("Servlet context path = " + sc.getContextPath() + "\n");
		response.getWriter().println("Servlet Major version = " + sc.getMajorVersion() + "\n");
		String requestURI = request.getRequestURI();
		String requestProtocol = request.getProtocol();
		String localName = request.getLocalName();
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		response.getWriter().println("Request URi =" + requestURI + "\n");
		response.getWriter().println("Request protocol =" + requestProtocol + "\n");
		response.getWriter().println("Request local name=" + localName + "\n");
		response.getWriter().println("Request local addr=" + localAddr + "\n");
		response.getWriter().println("Request local port=" + localPort + "\n");
		String clientAddress = request.getRemoteAddr();
		response.getWriter().println("Request client addr=" + clientAddress + "\n");
		String serverName = request.getServerName();
		response.getWriter().println("Request server name=" + serverName + "\n");
		Enumeration<String> header = request.getHeaderNames();
		response.getWriter().println("Header names");
		try
		{
			String res = "";
			while((res = header.nextElement()) != null)
			{
				response.getWriter().print(res + ": ");
				response.getWriter().println(request.getHeader(res));
			}
		} catch(Exception e)
		{
		}
		/*PrintWriter pw = response.getWriter();
		pw.println("<B>Список групп</B>");
		pw.println("<table border=1>");
		try {
			List<Group> l = this.getInstance().getGroups();
			for (Group gr : l) {
				pw.println("<tr>");
				pw.println("<td>" + gr.getGroupId() + "</td>");
				pw.println("<td>" + gr.getNameGroup() + "</td>");
				pw.println("<td>" + gr.getCurator() + "</td>");
				pw.println("<td>" + gr.getSpeciality() + "</td>");
				pw.println("</tr>");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		pw.println("</table>");
		*/
	}
}