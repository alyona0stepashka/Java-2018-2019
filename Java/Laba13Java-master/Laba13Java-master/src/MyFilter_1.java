import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

@WebFilter("/Login")
public class MyFilter_1 implements Filter {
    private static Date time = null;
    private static Integer count = 0;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            String login = servletRequest.getParameter("Login");
            String password = servletRequest.getParameter("Password");

            if(("admin".equals(login)) && ("admin".equals(password))){

                HttpSession httpSession = ((HttpServletRequest)servletRequest).getSession();
                httpSession.setAttribute("time", Calendar.getInstance().getTime());
                httpSession.setMaxInactiveInterval(10);
                ((HttpServletResponse)servletResponse).addCookie(new Cookie("typeUser", "Admin"));

                if(time == null){
                    time = Calendar.getInstance().getTime();
                    ((HttpServletResponse)servletResponse).addCookie(new Cookie("time", time.toString()));
                }
                count++;
                ((HttpServletResponse)servletResponse).addCookie(new Cookie("count",count.toString()));

                ((HttpServletResponse)servletResponse).addCookie(new Cookie("time", time.toString()));
                time = Calendar.getInstance().getTime();

                if((Calendar.getInstance().getTime().getHours() > 6) && (Calendar.getInstance().getTime().getHours() < 18)){
                    httpSession.setAttribute("hello", "Добрый день");
                }
                else {

                    httpSession.setAttribute("hello", "Добрый вечер");
                }

                ((HttpServletResponse) servletResponse).sendRedirect("TypeOfPerson.jsp");
            }
            else {

                ((HttpServletResponse) servletResponse).sendRedirect("Registration.jsp");
            }
        }
        catch (IOException ex){

            servletResponse.getWriter().println(ex.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
