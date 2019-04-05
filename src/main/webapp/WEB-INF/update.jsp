<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/student/updateStudent" method="post">
用户id:<input type="text" name="id" value="${student.id}" readonly="readonly"><br>
账户:<input type="text" name="name" value="${student.name}">
年龄:<input type="text" name="age" value="${student.age}">
密码:<input type="text" name="password" value="${student.password}">
<input type="submit" value="提交">
</form>

</body>
</html>