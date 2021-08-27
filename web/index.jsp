<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/5/12
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/index.css" type="text/css">
<html lang="en">
<head>
  <title>Login</title>
</head>
<body>


<aside>
    <form action="loginServlet" method="post">

    <%--@declare id=""--%>
      <input type="text" name="uname" placeholder="username" class="email">
        <label>     </label>
      <input type="password" name="pword" placeholder="password" class="pass">

      <button type="submit">Login</button>

  </form>
</aside>


</body>

</html>