<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 01.05.2017
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Good Login</title></head>
<body>
Name: ${Name} <br/>
<hr/>
Role: ${Role} <br/>
<hr/>
TimeStart: ${TimeStart} <br/>
<hr/>
MaxInactiveInterval:
${pageContext.session.maxInactiveInterval} <br/>
ID session: ${pageContext.session.id}<br/>

<form action="ToMain" method="post">
    <input type="submit" value="Open Main(post)">
</form>
<form action="ToMain" method="get">
    <input type="submit" value="Open Main(get)">
</form>
</body>
</html>
