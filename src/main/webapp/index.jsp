<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#batchDeleteBtn").on("click", function () {
                var isc = "";
                $("[name='chkId']:checked").each(function (index, element) {
                    isc += $(this).val() + ",";
                });
                if (isc.length > 0) //如果获取到
                    isc = isc.substring(0, isc.length - 1); //把最后一个逗号去掉

                var url = "${pageContext.request.contextPath}/dept/batchDelete.action";
                var data = "key="+isc;

                $.post(url,data);
            });
        });
    </script>
</head>
<body class="container">

<%--查询--%>
<form action="${pageContext.request.contextPath}/dept/findDepts.action" method="post">
    <div class="input-group">
        <input type="text" class="form-control" name="dept2.dname">
        <div class="input-group-btn">
            <input type="submit" class="btn btn-default" value="提交">
        </div>
    </div>
</form>

<h2>显示所有的Dept</h2>
<table class="table table-hover table-condensed">
    <thead>
    <tr>
        <th></th>
        <th>编号</th>
        <th>名称</th>
        <th>地址</th>
        <th>OP</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${depts}" var="dept" varStatus="vs">
        <tr>
            <td><input class="checkbox" type="checkbox" name="chkId" value="${dept.deptno}"></td>
            <td>${dept.deptno}</td>
            <td>${dept.dname} </td>
            <td>${dept.loc}</td>
            <td><a href="${pageContext.request.contextPath}/dept/showEditDeptPage.action?deptno=${dept.deptno}"
                   class="btn btn-success btn-sm">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button id="batchDeleteBtn" type="button" class="btn btn-success pull-right">批量删除</button>
</body>
</html>
