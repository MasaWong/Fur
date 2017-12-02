<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="furs" scope="request" type="java.util.List"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>毛皮列表</title>
</head>

<body bgcolor="#d3d3d3">
<a href="add">
    <button style="margin: 32px; height: 52px; font-size: 24px;">添加毛皮</button>
</a>
<div>
    <c:forEach items="${furs}" var="fur">
        <div style="float: left; margin-left: 32px; margin-bottom: 32px; background-color: white">
            <a href="detail?id=${fur.id}">
                <img src="${fur.thumb}" width="300px" height="360px"/>
            </a>
            <div style="padding: 8px 16px;">序号：${fur.id}</div>
            <div style="padding: 8px 16px;">名称：${fur.name}</div>
            <div style="padding: 8px 16px;">日期：${fur.date} ${fur.time}</div>
            <div style="padding: 8px 16px;"><a href="delete?id=${fur.id}">删除这个商品</a></div>
        </div>
    </c:forEach>
</div>
</body>
</html>
