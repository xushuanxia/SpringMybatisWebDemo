<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:if test="${allErrors!=null}">
    <c:forEach var="allErrors" items="${allErrors}" >
        ${allErrors.defaultMessage}
    </c:forEach>
</c:if>
</body>
</html>
