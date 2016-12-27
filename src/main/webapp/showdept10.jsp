<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").on("click",function () {
                $.get("dept/dept10/10",function (data) {
                    $("#res").html(data);
                });
            });
        });
    </script>
</head>
<body>
<div id="res"></div>
<button id="btn">dept10</button>
</body>
</html>
