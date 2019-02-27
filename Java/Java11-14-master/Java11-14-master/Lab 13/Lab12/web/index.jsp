<%@ page import="java.time.LocalDateTime" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 27.04.2017
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyTitle</title>
</head>
<body>
<form action="Servlet" method="get">
    <input type="submit" value="Get request info">
</form>
<form action="Servlet" method="post">
    <input type="submit" value="Get time">
</form>
<form action="LoginAndPassword" method="get">
    <p>Login</p>
    <input type="jsp:text" name="Login" id="Login">
    <p>Password</p>
    <input type="jsp:text" name="Password" id="Password">
    <input type="submit" value="Sing in">
</form>
<a href="Registration.jsp">Go to registration</a>

<br/>
<hr/>
<%=  request.getParameter("Role")%><br/>

<%= "Task 2.1"%>
<%! private int count = 0;%>
<% if(LocalDateTime.now().getDayOfMonth() < 15) count = 1;
else count = 2;%>
<%= count == 1 ? "Hello 1" : "Hello 2"%>

<a href="Point221.jsp">Contest</a>
<br/>
<br/>
<hr/>
</body>
</html>
