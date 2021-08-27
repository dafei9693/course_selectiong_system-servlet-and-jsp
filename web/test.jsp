<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/14
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="loginframe">
    <form action="loginServlet" method="post" >
        <table border="1" align="center" valign="middle">
            <div>
                选课系统<br/><br/>
            </div>
            <div>账号:<input type="text" name="uname"> <br/><br/></div>
            <div>密码:<input type="text" name="pword"> <br/><br/></div>
            <div>
                <br/>
                <input type="submit" value="登录">
            </div>
        </table>
    </form>
</div>
</body>
</html>
