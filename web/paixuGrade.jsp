<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/23
  Time: 10:54
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
<form action="setGradeServlet" method="post">
    <table border=1 align="center" valign="middle">
        <tr>
            <td>课程编号</td><td>课程名称</td><td>学生学号</td><td>学生姓名</td><td>学生所属学院</td><td>成绩</td>
        </tr>
        <jsp:useBean id="students" scope="request" type="java.util.List"/>
        <c:set var="index" value="0"></c:set>
        <c:forEach items="${students}" var="student">
            <c:set var="range" value="5"></c:set>
            <c:set var="row_count" value="0"></c:set>
            <tr>
                <c:forEach items="${student}" var="item">
                    <c:if test="${(row_count ==0)}">
                        <td>
                                ${item}
                        </td>
                    </c:if>
                    <c:if test="${(row_count % range !=0 && row_count>0)}">
                        <td> ${item}  </td>
                    </c:if>
                    <c:if test="${row_count % range==0 && row_count>range-1}">
                        <c:set var="range" value="${range+6}" />
                        <td><input type="number" min="0" max="100" step="0.01" name="grade${index}"  value="${item}"></td>
                        <c:set var="index" value="${index+1}"></c:set>
                    </c:if>
                    <c:set var="row_count" value="${row_count+1}" />
                </c:forEach>
            </tr>
        </c:forEach>
        <tr><td><button type="submit" name="submit" value="提交">提交</button></td></tr>
    </table>

</form>
</body>
</html>
