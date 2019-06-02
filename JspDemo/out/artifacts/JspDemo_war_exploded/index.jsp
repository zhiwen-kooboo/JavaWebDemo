<%--
  Created by IntelliJ IDEA.
  User: 11301
  Date: 2019/6/1
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JspDemo</title>
</head>
<body>
<h1>index.jsp的内容233</h1>
<%
    pageContext.setAttribute("author", "pageContext");
    request.setAttribute("author", "request");
    session.setAttribute("author", "session");
    application.setAttribute("author", "application");
%>

取出四个作用域的值<br/>
<%=pageContext.getAttribute("author")%><br/>
<%=request.getAttribute("author")%><br/>
<%=session.getAttribute("author")%><br/>
<%=application.getAttribute("author")%><br/>

用EL表达式取出来的数据<br/>
${ pageScope.name }
${ requestScope.name }
${ sessionScope.name }
${ applicationScope.name }

用JSTL
<c:set value="" property="" target="" scope="page" var=""></c:set>
</body>
</html>
