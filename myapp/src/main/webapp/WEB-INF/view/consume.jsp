<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员消费</title>
</head>
<body>
<h1>会员消费</h1>
<p><b>${member.name}</b>，电话号为${member.phone}，消费如下:</p>
<form method="post" action="do_consume">
<p>
<input type="hidden" name="uid" value="${member.id}"/>
金额: <input type="text" name="amount"/></p>
<p>备注: <input type="text" name="comment"/></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="提交"/></p>
</form>
</body>
</html>