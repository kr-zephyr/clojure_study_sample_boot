<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Add a Location"; 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>Add a Location</h1>
    
    <form action="${ pageContext.request.contextPath }/add-location" method="POST">
        <p>x value: <input type="text" name="x"/></p>
        <p>y value: <input type="text" name="y"/></p>
        <p><input type="submit" value="submit location"/></p>
    </form>
</body>
</html>