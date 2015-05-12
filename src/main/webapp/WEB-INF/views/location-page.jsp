<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Location " + request.getAttribute("locId"); 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>A Single Location</h1>
    
    <p>id: ${ locId }</p>
    <p>x: ${ x }</p>
    <p>y: ${ y }</p>
</body>
</html>