<%--
  Created by IntelliJ IDEA.
  User: sazan
  Date: 05.07.2018
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="AuthenticationServlet">
    <label>Имя:
      <%
        String login = (String)request.getAttribute("login");
        if (login != null)
          out.println("<input type=\"text\" value=\"" + login + "\" name=\"login\"><br />");
        else
          out.println("<input type=\"text\" name=\"login\"><br />");
      %>
    </label>
    <label>Адрес:
      <%
        String address = (String)request.getAttribute("address");
        if (address != null)
          out.println("<input type=\"text\" value=\"" + address + "\" name=\"address\"><br />");
        else
          out.println("<input type=\"text\" name=\"address\"><br />");
      %>
    </label>
    <br>
    <input type="submit" value="OK">
  </form>
  </body>
</html>
