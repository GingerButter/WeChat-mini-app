<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员信息</title>
</head>
<body>
<h1>会员信息</h1>
<table border="1">
<tr><td>ID:</td><td>${member.id}</td></tr>
<tr><td>姓名:</td><td>${member.name}</td></tr>
<tr><td>电话:</td><td>${member.phone}</td></tr>
<tr><td>积分:</td><td>${member.credits}</td></tr>
</table>
<ul>
<li><a href="charge?uid=${member.id}">充值</a></li>
<li><a href="consume?uid=${member.id}">消费</a></li>
<li><a href="detail?uid=${member.id}">交易明细</a></li>
</ul>
<p>用法:http://localhost:8080/myapp/member?phone=18911230117</p>
</body>
</html>