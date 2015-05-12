<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Modified a Location"; 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>Modified a Location</h1>
    
    <p>
        Modified [${ x }, ${ y }] (id: ${ locId }) to the db. 
        <a href="${ pageContext.request.contextPath }/location/${ locId }">See for yourself</a>
    </p>
</body>
</html>