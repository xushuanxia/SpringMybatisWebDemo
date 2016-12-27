<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").on("click",function () {
                var  url="${pageContext.request.contextPath}/dept/jsonReq.action";
                var dept="{'deptno':123,'dname':'123','loc':'123'}";

                $.ajax({
                    url:url,
                    type:"POST",  //GET和POST方式都可以
                    data:"deptStr="+dept,
                    success:function (res) {
                        $("#res").text(res+"**");
                    }
                })
            });
        })
    </script>
</head>
<body>
<div id="res"></div>
<button id="btn">json</button>
</body>
</html>