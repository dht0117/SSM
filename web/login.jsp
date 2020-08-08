<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/30
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/LoginServlet">
        用户名<input type="text" name="username"></br>
        密 码<input type="text" name="password"></br>
        <input type="radio" name="time" value="10">10分钟
        <input type="radio" name="time" value="30">30分钟
        <input type="radio" name="time" value="60">1小时
        <br>
        <input type="submit" value="登录">

    </form>
</body>
</html>
