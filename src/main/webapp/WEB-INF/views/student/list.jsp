<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2024
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach sinh vien</h1>
<a href="/students/add"> Thêm mới</a>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Sex</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="stu" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${stu.name}</td>
            <td>${stu.phone}</td>
            <td>${stu.address}</td>
            <td>${stu.sex?"Nam":"Nữ"}</td>
            <td><a href="/students/edit?id=${stu.id}">Edit</a></td>
            <td><a href="/students/delete?id=${stu.id}" onclick="return confirm('Bạn có chắc chăn muốn xóa ko')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>