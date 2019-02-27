<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25.05.2018
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1 style="align-content: center"></h1>
  <br>
  <form action="Servlet1" method="get">
    <input type="submit" value="doGet">
  </form>
  <form action="Servlet1" method="post">
    <input type="submit" value="doPost">
  </form>
  <form action="Servlet1" method="get">
    <input type="submit" value="Get third">
  </form>
  <br>

  <form action="First">
    <input type="text" name="name">
    <input type="submit" value="get hello">
  </form>
  </body>
</html>