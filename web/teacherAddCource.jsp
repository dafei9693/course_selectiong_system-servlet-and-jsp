<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/20
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/addcource.css" type="text/css">
<html>
<head>
    <title>添加课程</title>
</head>
<body>

  <form action="teacherAddCourceServlet" method="post">
      <div>
          <td>课程编号：</td>
          <td><input type="text" name="cno" required="required"></td>
      </div>
      <div>
          <td>课程名称：</td>
          <td><input type="text" name="cname" required="required"></td>
      </div>
      <div>
          <td>学分：</td>
          <td><input type="text" name="credit" required="required"></td>
      </div>
      <div>
          <td>先修课程：</td>
          <td><input type="text" name="pcno"></td>
      </div>
      <div>
          <td>描述:<td>
          <input type="text" name="describe" height="100"></td>
      </div>
      <div>
          <td>数量:</td>
          <td><input type="text" name="left" required="required"></td>
      </div>
        <button type="submit">提交</button>
  </form>

</body>
</html>
