<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.5/css/bootstrap.css"/> ">
<script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.5/js/bootstrap.js"/>"></script>

<div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-8">
    <a href="index"><h1 style="text-align: center">Hello World!</h1></a>
  </div>
  <div  class="col-md-2">
    <sec:authorize access="!isAuthenticated()">
      <form name='loginForm'
            action="<c:url value='j_spring_security_check' />" method='POST'>
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
      <hr>
      <c:if test="${not empty error}">
        <div>${error}</div>
      </c:if>
      <c:if test="${not empty msg}">
        <div>${msg}</div>
      </c:if>
      <hr>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <c:url value="/j_spring_security_logout" var="logoutUrl" />
      <p>Ваш логин: <sec:authentication property="principal.username" /></p>
      <p><a href="${logoutUrl}" role="button">Выйти</a></p>
    </sec:authorize>
  </div>
</div>
<div class="row">
  <div class="nav nav-pills">
    <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
    <li role="presentation"><a href="${pageContext.request.contextPath}/mills">Mills</a></li>
    <li role="presentation"><a href="${pageContext.request.contextPath}/">About</a></li>
  </div>
</div>