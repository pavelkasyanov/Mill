<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Mill</title>
</head>
<body>
<div class="container">
  <div class="row">
    <jsp:include page="parts/header.jsp" />
  </div>
  <div class="row">
    <div class="col-md-4">
      <div class="row" style="width: 150px;">
        <c:if test="${not empty error}">
          <div class="alert alert-danger" role="alert">
              ${error}
          </div>
        </c:if>
      </div>
      <div class="row">
        <form name='loginForm'
              action="<c:url value='/j_spring_security_check' />" method='POST'>
          <div class="form-group">
            <label>User:</label>
            <input type='text' name='username' value='' class="form-control input-sm" style="width: 150px"/>
          </div>
          <div class="form-group">
            <label>Password:</label>
            <input type='password' name='password' class="form-control input-sm" style="width: 150px"/><Br>
            <input name="submit" class="btn btn-default input-sm" type="submit" value="LogIn" />
          </div>
          <input type="hidden" name="${_csrf.parameterName}"
                 value="${_csrf.token}" />
        </form>
      </div>
    </div>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>