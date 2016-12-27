<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $("#file").after("<br><input type='file' name='upload'>");
            });
        });
    </script>
</head>
<body>

<button type="button" id="btn">添加</button>

<form action="${pageContext.request.contextPath}/filesUpload.action" enctype="multipart/form-data" method="post">
    <input id="file" type="file" name="upload">
    <input type="submit">
</form>


</body>
</html>
