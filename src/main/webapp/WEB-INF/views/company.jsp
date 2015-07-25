<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>
</head>
<body>
<div class="container">
  <div class="row">
    <jsp:include page="parts/header.jsp" />
  </div>
  <script type="text/javascript">
    jQuery(document).ready( function() {
      $("#menu_item_companies").addClass("active");
    });
  </script>
  <div class="row">

  </div>
  <div class="row">
    <hr>
    Company page
      <div class="row">
        <div class="col-md-2">
            ${company.name}
        </div>
        <div class="col-md-2">
            ${company.city}(${country.name})
        </div>
        <div class="col-md-2">
            ${company.street},${company.home},${company.office}
        </div>
        <div class="col-md-2">
            ${company.site}
        </div>
      </div>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>
