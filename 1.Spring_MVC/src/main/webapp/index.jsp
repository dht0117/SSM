<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/7
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="hello">helloworld</a><br/>
<h1>RequestMapping测试</h1>
<a href="handle01">test01-写在方法上的requestMapping</a><br/>
<a href="haha/handle01">test01-写在类上的requestMapping</a><br/>
<h1>RequestMapping其他属性的测试</h1>
<a href="haha/handle02">test01-写在类上的requestMapping</a><br/>
<form action="haha/handle02" method="post">
    <input type="submit"/>
</form>
<a href="haha/handle03">handle03-params测试</a><br/>
<a href="haha/user/admin">测试pathVariable</a><br/>
</body>
</html>
