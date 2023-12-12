<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
            width: 100%;
            overflow: hidden;
            margin: 0;
            padding: 0;

            background: url(/image/login.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
        }

        #loginDiv {
            width: 400px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 400px;
            background-color: rgba(75, 81, 95, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 250px;
        }


        p {
            margin-top: 30px;
            margin-left: 20px;
            color: azure;
        }

        input {
            margin-left: 15px;
            border-radius: 5px;
            border-style: hidden;
            height: 30px;
            width: 140px;
            background-color: rgba(216, 191, 216, 0.5);
            outline: none;
            color: #f0edf3;
            padding-left: 10px;
        }

        .button {
            border-color: #fff8dc;
            background-color: rgba(100, 149, 237, 0.7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;
        }
        .button-3d-1{
            position: relative;
            background: #4e6087;
            border: none;
            color: white;
            padding: 10px 20px;
            font-size: 1rem;
            outline: none;
        }
    </style>
    <style type="text/css">
        input::-ms-input-placeholder{text-align: center;}
        input::-webkit-input-placeholder{text-align: center;}
    </style>
</head>

<body>
<div id="loginDiv">
    <form action="/admin/doregister" method="post" id="form">
        <h1 style="text-align: center;color: aliceblue;">农业大数据平台</h1>
        <p>用户:<input type="text" name="name" id="name" required></p>

        <p>密码:<input id="pwd" type="password"  name="pwd" placeholder="密码长度至少为6位" required></p>
        <div style="color: red">
            <c:if test="${param.error==1}">
                <b>用户名已经存在，请重新注册</b>
            </c:if>
        </div>
        <div style="text-align:center;margin-top: 10px;">
            <button class="button-3d-1">注  册</button>
        </div>
    </form>

</div>

</body>
</html>
