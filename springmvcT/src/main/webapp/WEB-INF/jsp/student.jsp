<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: 少年
  Date: 2023/12/6
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student</title>
</head>
<body>
    <form:form method="post"  action="/student/add">
        <table>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id"></form:input></td>
            </tr>
            <tr>
                <td><form:label path = "name">Name</form:label></td>
                <td><form:input path = "name" /></td>
            </tr>
            <tr>
                <td><form:label path = "sex">Sex</form:label></td>
                <td><form:input path = "sex" /></td>
            </tr>
            <tr>
                <td><form:label path = "age">Age</form:label></td>
                <td><form:input path = "age" /></td>
            </tr>
            <tr>
                <td><form:label path = "classes">Classes</form:label></td>
                <td><form:input path = "classes" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type = "submit" value = "Submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
