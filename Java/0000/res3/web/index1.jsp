<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Evgene
  Date: 03.07.2018
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page errorPage="ShowError.jsp" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost;databaseName=BdN;"
                   user="admin"  password="1"/>
<sql:query dataSource="${snapshot}" var="result">
    SELECT year, sum from T1 where(year=${param.year}) and (sum > ${param.sum})  ;
</sql:query>
<c:set var="Sum"  value="${0}" />
<table border="1" width="100%">
    <tr>
        <th>Year</th>
        <th>Sum</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><center><c:out value="${row.year}"/><center/></td>
            <td><center><c:out value="${row.sum}"/><center/></td>
            <c:set var="Sum1"  value="${Sum=Sum+row.sum}" />
        </tr>
    </c:forEach>
</table>
<%--<%! int i=5; %>--%>
<%--<%= new Date() %>--%>
<c:if test="${Sum > 0}">
    <c:out value="${Sum}>0"/>
</c:if>
<%--<c:if test="${Sum <= 0}">--%>
    <%--<%--%>
        <%--throw new RuntimeException("VALUE<0");--%>
    <%--%>--%>
<%--</c:if>--%>
</body>
</html>
