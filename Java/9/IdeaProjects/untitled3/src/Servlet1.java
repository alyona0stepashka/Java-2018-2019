import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1", urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Servlet2").forward(request,response);
        //forward перенаправляет обработку запроса в другой сервлет
        //перенаправление
        //когда с1 просит выполнить с2 и передает ему данные, оба с на одном сервере - браузер перенаправления не видит и не меняет урл
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1p
        response.setContentType("text/html");
        //request.getRequestDispatcher("Servlet2").forward(request,response); //перенаправление
        response.sendRedirect("Servlet2");
        //переадресация
        //redirect перенаправляет клиенту и тогда запрос отправляется от клиента
        //в брузере отображается адрес строка того сервлета, который отображен, а не который вызвал
        //

    }
}
