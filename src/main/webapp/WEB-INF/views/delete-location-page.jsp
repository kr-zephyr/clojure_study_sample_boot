<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageHead = "Delete a Location " + request.getAttribute("locId"); 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>Delete a Location ${ locId }</h1>
    
    <script>
	    alert ('deleted');
	    location.replace('${ pageContext.request.contextPath }/all-locations');
    </script>
</body>
</html>