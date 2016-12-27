<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单文件上传</title>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () {
            <!-- 111 -->
            $("#fileBtn1").on("click",function () {
                $.ajax({
                    url: 'fileUpload.action',
                    type: 'POST',
                    cache: false,
                    data: new FormData($('#uploadForm')[0]),
                    processData: false,
                    contentType: false
                });
            });
            <!-- 111 -->
            $("#fileBtn2").on("click",function () {
                var formData=new FormData();
                formData.append('file1',$('#file2')[0].files[0]);
                $.ajax({
                    url: 'fileUpload.action',
                    type: 'POST',
                    cache: false,
                    data: formData,
                    processData: false,
                    contentType: false

                });
            });
        });
    </script>
</head>
<body>
<!-- 利用form<input>实现 -->
<form action="${pageContext.request.contextPath}/fileUpload.action" enctype="multipart/form-data" method="post">
    <input type="file"  name="file1">
    <input type="submit" value="上传">
</form>

<!--  -->
<form enctype="multipart/form-data" id="uploadForm">
    <input type="file"  name="file1" id="file1">
    <button id="fileBtn1" type="button">fileUpload</button>
</form>

<!--  -->
<div>
    <input type="file" id="file2">
    <button id="fileBtn2" type="button">fileUpload</button>
</div>

</body>
</html>
