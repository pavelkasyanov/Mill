<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
  <title>Mill</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div class="container">
  <div class="row">
    <jsp:include page="parts/header.jsp" />
  </div>
  <Br><Br>
  <div class="row">
    <div class="row">
      <div class="col-md-2">
        <img src="<c:url value="/resources/jpg/mills/${mill.image}"/>" width="100" height="100">
      </div>
      <div class="col-md-6">
        <div class="row">
          Name:${mill.name}
        </div>
        <div class="row">
          Producer:${millProducer.name}
        </div>
        <div class="row">
          Year:${mill.year}
        </div>
        <div class="row">
          Description:${mill.description}
        </div>
      </div>
    </div>
    <div class="row">
      <div class="row">
        <a href="<c:url value="/pdfView/mill?id=${mill.id}" />">View PDF</a>
      </div>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="row">
          <a href="#">delete mill</a>
        </div>
      </sec:authorize>
    </div>
    <Br>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>
