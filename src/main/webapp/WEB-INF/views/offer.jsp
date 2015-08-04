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
  <script type="text/javascript">
    jQuery(document).ready( function() {
      $("#menu_item_index").addClass("active");
    });
  </script>
  <div class="row">

  </div>
  <div class="row">
    <hr>
    <div class="row">
      offer from: ${mill.axisCount}-осевой ${millType.name} ${mill.model} (${millProducer.name}, ${countryProducing.name})
    </div>
    <div class="row">
      <Br />
      <div class="col-md-4"></div>
      <div class="col-md-3">
        <form action="<c:url value="/offer/create"/>" method="post">
          <input type="hidden" name="millId" value="${mill.id}" />
          Company:<select name="companyName" form-control>
            <c:forEach var="company" items="${companies}">
              <option value="${company.name}">${company.name}</option>
            </c:forEach>
          </select><Br />
          Director:<input type="text" name="directorName" class="form-control"/><Br />
          <input type="submit" value="send" />
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