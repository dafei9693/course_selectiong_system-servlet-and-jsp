<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/17
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="./css/others.css" type="text/css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="teacherSetGradeServlet" method="post">
    <table border=1 align="center" valign="middle">
        <tr>
            <td>教师编号</td><td>课程编号</td><td>课程名</td><td>学分</td><td>先修课程</td><td>描述</td><td>剩余</td><td>操作</td>
        </tr>
        <jsp:useBean id="createdCources" scope="request" type="java.util.List"/>
        <c:forEach items="${createdCources}" var="cources">
            <tr>
                <c:forEach items="${cources}" var="item">
                    <td> ${item}  </td>
                </c:forEach>
                <c:forEach items="${cources}" var="item">
                    <c:if test="${fn:contains(item,'C')}">
                        <td>
                            <button type="submit" name="coursesNumber"  value="${item}" >评分</button>
                        </td>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
