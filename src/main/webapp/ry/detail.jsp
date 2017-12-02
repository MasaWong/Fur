<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="detail" scope="request" type="mw.ankara.fur.model.Fur"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>毛皮详情</title>
</head>
<body>
<div>
    编号:
    <label>${detail.id}</label>
</div>
<div>
    名称:
    <label>${detail.name}</label>
</div>
<img src="${detail.origin}">
</body>
</html>
