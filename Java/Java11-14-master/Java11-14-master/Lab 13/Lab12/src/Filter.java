import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, filterName = "Filter",
		initParams = {@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})
public class Filter implements javax.servlet.Filter
{
	private String code;

	public void destroy()
	{
		code = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
	{
		String codeRequest = request.getCharacterEncoding();
		if(code != null && !code.equalsIgnoreCase(codeRequest))
		{
			request.setCharacterEncoding(code);
			response.setCharacterEncoding(code);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException
	{
		code = config.getInitParameter("encoding");
	}
}