<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/23
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<link rel="stylesheet" href="./css/others.css" type="text/css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="xuankeServlet" method="post">
    <table border=1 align="center" valign="middle">
        <tr>
            <td>编号</td><td>名称</td><td>学分</td><td>先修课程</td><td>描述</td><td>剩余数量</td><td>教师姓名</td><td>选课</td>
        </tr>
        <jsp:useBean id="optionalCources" scope="request" type="java.util.List"/>
        <c:forEach items="${optionalCources}" var="cources">
            <tr>
                <c:forEach items="${cources}" var="item">
                    <td> ${item}  </td>
                </c:forEach>
                <c:forEach items="${cources}" var="item">
                    <c:if test="${fn:contains(item,'C')}">
                        <td>
                            <button type="submit" name="coursesNumber"  value="${item}">选择</button>
                        </td>
                    </c:if>
                </c:forEach>

            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
