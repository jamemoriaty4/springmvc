<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2024
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h1>Sửa thông tin Sinh viên</h1>
<form action="/students/update" method="post" >
    <input type="text" name="id" value="${student.id}" readonly>
    <br>
    <input type="text" name="name" value="${student.name}">
    <br>
    <input type="text" name="phone" value="${student.phone}">
    <br>
    <input type="text" name="address" value="${student.address}">
    <br>
    <input type="radio" ${student.sex?"checked":""} name="sex" value="true"> <span>Nam</span>
    <br>
    <input type="radio" ${!student.sex?"checked":""}  name="sex" value="false"> <span>Nữ</span>
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
