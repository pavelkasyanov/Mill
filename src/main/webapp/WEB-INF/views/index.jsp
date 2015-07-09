<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>${message}</h1>
<hr>
<c:forEach var="item" items="${users}">
    <h3>${item}</h3>
</c:forEach>
</body>
</html>