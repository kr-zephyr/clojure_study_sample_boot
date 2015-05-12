<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String pageHead = "All Locations in the db"; 
%>
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/views/header.jsp" %>
<body>
    <%@ include file="/WEB-INF/views/header-links.jsp" %>
    
    <h1>All Locations</h1>
    
    <table>
        <tr>
            <th>id</th>
            <th>x</th>
            <th>y</th>
            <th>Modify</th>
            <th>Delete</th>
        </tr>
        
        <c:forEach var="location" items="${ locationList }">
        <tr>
            <td>${location.id}</td>
            <td>${location.x}</td>
            <td>${location.y}</td>
            <td><a href="${ pageContext.request.contextPath }/modify-location-view/${location.id}">modify</a></td>
            <td><a href="${ pageContext.request.contextPath }/delete-location/${location.id}">delete</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>