<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 09.06.2017
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>formatting</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:setLocale value="en-EN"/>
Date in English format<br>
today: <fmt:formatDate value="${now}"/>
<h1>-------------</h1>
<fmt:setLocale value="ru-RU"/>
Russian format<br>
today: <fmt:formatDate value="${now}"/>
<h1>-------------</h1>
time styles<br>
(short): <fmt:formatDate value="${now}"
                         type="time" timeStyle="short"/><br/>
(medium):<fmt:formatDate value="${now}"
                         type="time" timeStyle="medium"/><br/>
(long): <fmt:formatDate value="${now}"
                        type="time" timeStyle="long"/><br/>
<h1>--------------------</h1>
<c:set var="currentNumber" value="118000"/>
<c:out value="outing format of numbers : ${currentNumber}"/> <br/>
default format :
<fmt:formatNumber value="${currentNumber}" /><br/>
percents :
<fmt:formatNumber value="${currentNumber}"
                  type="percent"/><br/>
<fmt:setLocale value="be-BY"/>
BYN :
<fmt:formatNumber value="${currentNumber}"
                  type="currency"/><br/>
Euro :
<fmt:setLocale value="fr-FR"/>
<fmt:formatNumber value= "${currentNumber}" type="currency"/><br/>
</body>
</html>
