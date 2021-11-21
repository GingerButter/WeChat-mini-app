<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Users</title>
</head>
<body>
<h1>用户列表</h1>
<table border="1">
<tr><td>ID</td><td>Name</td></tr>
<c:forEach items="${users}" var="user">
<tr><td>${user.id}</td><td>${user.name}</td></tr>
</c:forEach>
</table>
</body>
</html>