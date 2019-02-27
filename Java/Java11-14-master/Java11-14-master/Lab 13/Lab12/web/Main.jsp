<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 01.05.2017
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
${get}
<p> Local site </p>
<form action="Main1" method="get">
    <input type="submit" value="(get переадресация)">
</form>
<form action="Main1" method="post">
    <input type="submit" value="(post перенаправление)">
</form>
<form action="Main2" method="get">
    <input type="submit" value="(get перенаправление">
</form>
<form action="Main2" method="post">
    <input type="submit" value="(post переадресация)">
</form>

<p> Second site </p>
<form action="Main3" method="post">
    <input type="submit" value="(post перенаправление)">
</form>
<form action="Main4" method="get">
    <input type="submit" value="(get перенаправление">
</form>
</body>
</html>
