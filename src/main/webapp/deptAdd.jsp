
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body class="container">
<form class="form-horizontal" action="${pageContext.request.contextPath}/dept/batchAdd.action" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">编号</label>
        <div class="col-sm-10">
            <input type="text"  class="form-control" name="dept.depts[0].deptno" value="${deptno}">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="dept.depts[0].dname" value="${dname}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="dept.depts[0].loc" value="${loc}">
        </div>
    </div>
----------------------------------------------------------------------------------------------------
    <div class="form-group">
        <label class="col-sm-2 control-label">编号</label>
        <div class="col-sm-10">
            <input type="text"  class="form-control" name="depts[1].deptno" value="${deptno}">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="depts[1].dname" value="${dname}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="depts[1].loc" value="${loc}">
        </div>
    </div>
    <input type="submit" class="btn btn-success pull-right" value="确认添加">
</form>
</body>
</html>
