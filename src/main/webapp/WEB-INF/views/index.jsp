<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body onload='document.loginForm.username.focus();'>
<h1>${message}</h1>
<hr>
    <c:if test="${not empty error}">
        <div>${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div>${msg}</div>
    </c:if>
<form name='loginForm'
      action="<c:url value='j_spring_security_check' />" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit" /></td>
        </tr>
    </table>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

</form>
<hr>
<a href="mills" >mills</a>
<hr>
<c:forEach var="item" items="${countryList}">
    <h3>${item}</h3>
</c:forEach>
</body>
</html>