<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>交易明细</title>
</head>
<body>
<h1>会员交易明细</h1>
<table border="1">
<tr><td>姓名:</td><td>${member.name}</td></tr>
<tr><td>电话:</td><td>${member.phone}</td></tr>
<tr><td>积分:</td><td>${member.credits}</td></tr>
</table>
<p>交易明细</p>
<table border="1">
<tr>
<th>交易ID</th>
<th>金额</th>
<th>时间</th>
<th>备注</th>
</tr>
<c:forEach var="detail" items="${details}">
<tr>
<td>${detail.id}</td><td>${detail.amount}</td><td>${detail.transactionTime}</td><td>${detail.comment}</td>
</tr>
</c:forEach>
</table>
<p><a href="member?uid=${member.id}">返回会员首页</a></p>
</body>
</html>