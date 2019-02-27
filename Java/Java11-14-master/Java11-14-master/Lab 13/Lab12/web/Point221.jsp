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
    <title>Question 1</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<%="Your values are: "%>
<%= session.getAttribute("Point221")+" "%><br/>
<hr/>
<%= session.getAttribute("Point222")+" "%><br/>
<hr/>
<%= session.getAttribute("Point223")+" "%><br/>
<hr/>
<form action="Point221" method="get">
    <input type="submit" value="Prev">
</form>
<%! String res = new String(); %>
<% res=(String)session.getAttribute("Point221");%>
<form action="Point221" method="post">
    <p>First q.</p>
    <input type="jsp:text" name="Value" id="Value" Value="<%=res==null?"":res%>">
    <input type="submit" value="Next">
</form>
<jsp:include page="/Footer.jsp"/>
</body>
</html>
