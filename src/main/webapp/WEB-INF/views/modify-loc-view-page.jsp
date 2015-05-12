<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Modify a Location for loc-id: " + request.getAttribute("locId"); 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>Modify a Single Location ${ locId }</h1>
    
    <form action="${ pageContext.request.contextPath }/modify-location" method="POST">
        <p><input type="hidden" name="locId" value="${ locId }"/></p>
        <p>x value: <input type="text" name="x" value="${ x }"/></p>
        <p>y value: <input type="text" name="y" value="${ y }"/></p>
        <p><input type="submit" value="modify location"/></p>
    </form>
</body>
</html>