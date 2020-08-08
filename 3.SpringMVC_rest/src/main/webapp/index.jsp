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
<!--从页面发起PUT、DELETE请求？   Spring提供了REST风格的支持
 SpringMVC有一个Filter，他可以吧普通的请求方式转化为规定形式的请求，；配置这个filter

    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
   2.发送形式：
   创建一个表单，提交方式为post；  表单项中携带一个_method参数   ；method带上要提交的方式
 -->

<a href="book/1">查询1号图书</a><br/>
<form action="book/1" method="post">
    <input type="submit" value="添加1号图书"/>
</form>
<%--发送DELETE请求--%>
<a href="book/1">删除1号图书</a><br/>
<form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书"/>
</form>
<a href="book/1">更新1号图书</a><br/>
<%--发送封信请求--%>
<form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书"/>
</form>
</body>
</html>
