<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Added a Location";
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>Added a Location</h1>
    
    <p>
        Added [${ x }, ${ y }] (id: ${ locId }) to the db.
        <a href="${ pageContext.request.contextPath }/location/${ locId }">See for yourself</a> 
    </p>
</body>
</html>