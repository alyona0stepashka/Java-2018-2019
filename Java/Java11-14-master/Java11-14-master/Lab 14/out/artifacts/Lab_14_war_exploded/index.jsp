<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="CHNTag" uri="CHNTag.tld" %>
<html>
<head><title>Example page</title></head>
<body><H1>Core</H1>
<pre class="prettyprint">Using class</pre>
<c:set var="myName" value="Any name"/><h4>${myName}</h4><c:if test="${10 > 9}"><p>True
    <p></c:if><c:if test="${10 < 9}"><p>False</p></c:if><c:set var="num" scope="session" value="10"/><c:choose><c:when
        test="${num <= 0}">num<=0</c:when><c:when
        test="${num > 1000}">num>1000</c:when><c:otherwise>default</c:otherwise></c:choose><c:forEach var="num"
                                                                                                      items="${list}">
    <p>${num}</p></c:forEach><h4>Before</h4><c:out value="${myName}"/><c:remove var="myName"/><H4>After</H4><c:out
        value="${myName}"/><c:catch var="catchException"><% int x = 5 / 0;%></c:catch><c:if
        test="${catchException != null}"><p>The exception is : ${catchException} <br/>There is an
    exception: ${catchException.message}</p></c:if><c:forEach var="i" begin="25" end="50">Item <c:out value="${i}"/><p>
    </c:forEach>
    <c:forTokens items="first,second,third" delims="," var="name">
        <c:out value="${name}"/>
    </c:forTokens>
    <c:import var="data" url="http://it.belstu.by/"/> <c:out value="${data}"/><h1>Formatter</h1><c:set var="balance"
                                                                                                       value="120000.239"/>
<p><fmt:formatNumber type="number" maxIntegerDigits="3" value="${balance}"/></p>
<p><fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}"/></p>
<p><fmt:formatNumber type="number" groupingUsed="false" value="${balance}"/></p>
<p><fmt:formatNumber type="percent" maxIntegerDigits="30" value="${balance}"/></p>
<p><fmt:formatNumber type="percent" minFractionDigits="10" value="${balance}"/></p>
<p><fmt:formatNumber type="percent" maxIntegerDigits="5" value="${balance}"/></p>
<p><fmt:formatNumber type="number" pattern="###.###E0" value="${balance}"/></p>
<p><fmt:parseNumber var="i" type="number" value="${balance}"/></p>
<p><fmt:parseNumber var="i" integerOnly="true" type="number" value="${balance}"/></p><c:set var="now"
                                                                                            value="<%= new java.util.Date()%>"/>
<p><fmt:formatDate type="time" value="${now}"/></p>
<p><fmt:formatDate type="date" value="${now}"/></p>
<p><fmt:formatDate type="both" value="${now}"/></p>p><fmt:formatDate type="both" dateStyle="short" timeStyle="short"
                                                                     value="${now}"/></p><p><fmt:formatDate type="both"
                                                                                                            dateStyle="medium"
                                                                                                            timeStyle="medium"
                                                                                                            value="${now}"/></p>
<p><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/></p>
<p><fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/></p><c:set var="now" value="20-10-2010"/><p><fmt:parseDate
        value="${now}" var="parsedEmpDate" pattern="dd-MM-yyyy"/></p>
<h1>Xml</h1><c:set var="xmltext">
    <books>
        <book>
            <name>Padam History</name>
            <author>ZARA</author>
            <price>100</price>
        </book>
        <book>
            <name>Great Mistry</name>
            <author>NUHA</author>
            <price>2000</price>
        </book>
    </books>
</c:set><x:parse xml="${xmltext}" var="output"/><b>The title of the first book is</b>:<x:out
        select="$output/books/book[1]/name"/><br><b>The price of the second book</b>:<x:out
        select="$output/books/book[2]/price"/><x:parse xml="${xmltext}" var="output"/>
<ul class="list"><x:forEach select="$output/books/book/name" var="item">
    <li>Book Name: <x:out select="$item"/></li>
</x:forEach></ul>
<h1>Functions</h1><c:set var="string1" value="This is first String."/><c:set var="string2"
                                                                             value="${fn:split(string1, ' ')}"/><c:set
        var="string3" value="${fn:join(string2, '-')}"/><p>String : ${string3}</p><c:set var="string4"
                                                                                         value="${fn:split(string3, '-')}"/><c:set
        var="string5" value="${fn:join(string4, ' ')}"/><p>String : ${string5}</p><c:set var="string1"
                                                                                         value="This is first String."/><c:set
        var="string2" value="${fn:toLowerCase(string1)}"/><p>Final string : ${string2}</p><c:set var="string1"
                                                                                                 value="This is first String."/><c:set
        var="string2" value="${fn:substringAfter(string1, 'is')}"/><p>Final sub string : ${string2}</p></body>

<h1>CHN Tags</h1>
<form action="Table.jsp" method="post">
    <CHNTag:CHNLabtedTextField name="FirstName" lable="First name"/><br/>
    <CHNTag:CHNLabtedTextField name="MiddleName" lable="Middle name"/><br/>
    <CHNTag:CHNLabtedTextField name="LastName" lable="Last name"/><br/>
    <CHNTag:CHNLabtedTextField name="Street" lable="Street"/><br/>
    <CHNTag:CHNLabtedTextField name="City" lable="City"/><br/>
    <CHNTag:CHNSubmit/>
</form>
</html>