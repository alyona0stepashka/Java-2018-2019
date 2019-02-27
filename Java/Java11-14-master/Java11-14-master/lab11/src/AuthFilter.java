import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/AuthFilter")
public class AuthFilter implements Filter
{

    @Override
    public void destroy()
    {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletResponse resp = (HttpServletResponse) response;
        if(request.getParameter("pass").equals("qwe123") && request.getParameter("login").equals("admin")) {
            filterChain.doFilter(request, response);
        }
        else

        resp.sendRedirect("Authorization.jsp");
    }
}