<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/8
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--发起图书的增删改查，使用REST风格的URL地址
请求url   请求方式   表达含义
/book/1   GET      查询1号图书
/book/1   DELETE      删除1号图书
/book/1   PUT     更新1号图书
/book/1   POST      添加1号图书
 -->
<a href="book/1">查询1号图书</a><br/>
<form action="book/1" method="post">
    <input type="submit" value="添加1号图书"/>
</form>
<a href="book/1">删除1号图书</a><br/>
<form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书"/>
</form>
<a href="book/1">更新1号图书</a><br/>
<form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书"/>
</form>
</body>
</html>
