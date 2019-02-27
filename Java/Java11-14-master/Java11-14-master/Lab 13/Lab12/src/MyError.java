import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by Nikita on 13.05.2017.
 */
@WebServlet(name = "MyError", urlPatterns = {"/MyError"})
public class MyError extends HttpServlet
{
}
