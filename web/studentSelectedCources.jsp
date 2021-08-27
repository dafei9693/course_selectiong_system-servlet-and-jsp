<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/17
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<link rel="stylesheet" href="./css/others.css" type="text/css">
<html>
<head>
    <title>studentSelectedCources</title>
</head>
<body>
<form action="tuixuanServlet" method="post">
    <table>
        <tr>
            <td>编号</td><td>课程名称</td><td>学分</td><td>描述</td><td>分数</td><td>操作</td>
        </tr>
        <jsp:useBean id="selectedCources" scope="request" type="java.util.List"/>
        <c:forEach items="${selectedCources}" var="cources">
            <tr>
                <c:forEach items="${cources}" var="item">
                    <td> ${item}  </td>
                </c:forEach>
                <c:forEach items="${cources}" var="item">
                    <c:if test="${fn:contains(item,'C')}">
                        <td>
                            <button type="submit" name="coursesNumber"  value="${item}">退选</button>
                        </td>
                    </c:if>
                </c:forEach>

            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
