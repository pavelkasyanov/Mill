<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.5/css/bootstrap.css"/> ">
<script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.5/js/bootstrap.js"/>"></script>

<div class="row">
  <div class="col-md-2">
    <a href="<c:url value="/"/>"><h1 style="text-align: center">MIll Store</h1></a>
  </div>
  <div class="col-md-8">
  </div>
  <div  class="col-md-2">
    <div class="row" style="text-align: center;border: 30px solid transparent;">
      <sec:authorize access="!isAuthenticated()">
          <a href="<c:url value="/login"/>">LogIn</a>
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <p>Ваш логин: <sec:authentication property="principal.username" />
          <a href="${logoutUrl}" role="button">Выйти</a></p>
      </sec:authorize>
    </div>
  </div>
</div>
<div class="row">
  <div class="nav nav-pills"><%--pull-right--%>
    <li role="presentation" id="menu_item_index"><a href="<c:url value="/" />">Home</a></li>
    <li role="presentation" id="menu_item_mills"><a href="<c:url value="/mills" />">Mills</a></li>
    <sec:authorize access="isAuthenticated()">
      <li role="presentation" id="menu_item_companies"><a href="<c:url value="/companies" />">Companies</a></li>
    </sec:authorize>
    <li role="presentation" id="menu_item_contacts"><a href="<c:url value="/" />">Contacts</a></li>
    <li role="presentation" id="menu_item_about"><a href="<c:url value="/about" />">About</a></li>
  </div>
</div>