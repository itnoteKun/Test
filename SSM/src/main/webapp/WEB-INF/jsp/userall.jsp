<%--
  Created by IntelliJ IDEA.
  User: 少年
  Date: 2023/12/10
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.user_name}</td>
        <td>${user.password}</td>
    </tr>
</table>
</body>
</html>
