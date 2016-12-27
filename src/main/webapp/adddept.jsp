<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据回显</title>

</head>
<body>
${sth}
<form action="dept/huixian.action" method="post" id="form1">
    <input type="text" name="deptno" value="${dept.deptno}"><br>
    <input type="text" name="dname" value="${dept.dname}"><span style="color: red">${allerrors}</span><br>
    <input type="text" name="loc" value="${dept.loc}"><br>

    <button type="button" id="btn" onclick="document.getElementById('form1').submit();">submit</button>

</form>
</body>
</html>
