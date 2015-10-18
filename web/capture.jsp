<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: rich
  Date: 18/10/2015
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Answer</title>
  </head>
  <body>
    You entered ::
    <span style="font-weight: bold;" id="answer">
        <%=request.getParameter((String)session.getAttribute("dynamicInput"))%>
        <%session.setAttribute("dynamicInout", null);%>
    </span>

    <a href="index.jsp">-Home-</a>
  </body>
</html>
