<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加毛皮</title>
    <script>
        function c (a) {var r= new FileReader();f=a.files[0];r.readAsDataURL(f);r.onload=function (e){document.getElementById('thumb').src=this.result;};}
    </script>
</head>
<body>
<form action="put" method="POST" enctype="multipart/form-data">
    <div>
        <div>
            名称:
            <input type="text" name="name">
        </div>
        <div>
            图片:
            <input type="file" name="image" accept='image/*' onchange="c(this)">
        </div>
        <img id="thumb" width="350px" height="420px">
        <div>
            <input type="submit" value="添加"/>
        </div>
    </div>
</form>
</body>
</html>
