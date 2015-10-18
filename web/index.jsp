<%--
  Created by IntelliJ IDEA.
  User: rich
  Date: 18/10/2015
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
        String dynamicStr = String.valueOf(Math.random()) + "_numberText";
        session.setAttribute("dynamicInput", dynamicStr);
    %>
    <form action="capture.jsp" method="POST">
      <label for="numberText">Age</label><input type="number" name="<%=dynamicStr%>" id="numberText" placeholder="Enter Number">
        <input type="submit" value="Check">
    </form>
  </body>
</html>
