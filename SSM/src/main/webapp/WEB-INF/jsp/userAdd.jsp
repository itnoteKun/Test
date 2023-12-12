<%--
  Created by IntelliJ IDEA.
  User: 少年
  Date: 2023/12/10
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form action="/userAdd" method="post">
        <tr>
            <td>name</td>
            <td><input type="text" name="user_name"></td>
        </tr><br>
        <tr>
            <td>password</td>
            <td><input type="text" name="password"></td>
        </tr><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
