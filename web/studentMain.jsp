

<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/16
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="./css/main.css" type="text/css">
<html>
<head>
    <title>主页</title>
</head>
<body>
<aside>

<table border=1 align="center" valign="middle">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>学院</td>
        <td>密码</td>
    </tr>
    <tr>
    <jsp:useBean id="infos" scope="request" type="java.util.List"/>
    <c:forEach items="${infos}" var="info">
        <td> ${info}  </td>
    </c:forEach>
    </tr>

</table>
</aside>
<form action="studentMainServlet" method="post">
<input type="checkbox" id="menu-toggle"/>
<label id="trigger" for="menu-toggle"></label>
<label id="burger" for="menu-toggle"></label>

<ul id="menu">
    <li><button type="submit" name="order" value="可选课程">可选课程</button></li>
    <li><button type="submit" name="order" value="已选课程">已选课程</button></li>
    <li><button type="submit" name="order" value="退出登录">退出</button></li>
</ul>
</form>


</body>
</html>
