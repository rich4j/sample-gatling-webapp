<%--
  Created by IntelliJ IDEA.
  User: rich
  Date: 18/10/2015
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath());
%>
