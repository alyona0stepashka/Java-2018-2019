<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ taglib uri="/WEB-INF/tutorial-template.tld" prefix="tt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wrest test</title>
</head>
<body>

    <form method="post">
        <tt:kevLabledTextField name="tagDay" value="-12"/>
        <br/>
        <tt:kevLabledTextField name="tagMonth" value="2"/>
        <br/>
        <tt:kevLabledTextField name="tagYear" value="2007"/>
        <br/>
        <button type="submit"/>
    </form>
    <br/>
    <ul>
        <li><p><b>TEST</b>
            <br/>
            <%= (request.getParameter("tagDay")!=null && Integer.parseInt(request.getParameter("tagDay"))>0 && Integer.parseInt(request.getParameter("tagDay"))<31) %>
            <br/>
            <%= (request.getParameter("tagMonth")!=null && Integer.parseInt(request.getParameter("tagMonth"))>0 && Integer.parseInt(request.getParameter("tagMonth"))<13) %>
            <br/>
            <%= (request.getParameter("tagYear")!=null && Integer.parseInt(request.getParameter("tagYear"))>=1970)%>
        </p></li>
    </ul>
    <br/>
</body>
</html>