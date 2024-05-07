<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2024
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h1>Thêm mới Sinh viên</h1>
<form action="/students/add" method="post" >
    <input type="text" name="name">
    <br>
    <input type="text" name="phone">
    <br>
    <input type="text" name="address">
    <br>
    <input type="radio" name="sex" value="true"> <span>Nam</span>
    <br>
    <input type="radio" name="sex" value="false"> <span>Nữ</span>
    <br>
    <input type="submit" name="action" value="ADD">
</form>
</body>
</html>
