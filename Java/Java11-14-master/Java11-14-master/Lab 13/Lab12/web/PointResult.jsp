<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 12.05.2017
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<%="Your values are: "%>
<%= session.getAttribute("Point221")+" "%>
<%= session.getAttribute("Point222")+" "%>
<%= session.getAttribute("Point223")+" "%>
<form action="PointResult" method="get">
    <input type="submit" value="Prev">
</form>
<a href="ToNewHref">Error link</a>
<jsp:include page="/Footer.jsp"/>
</body>
</html>
