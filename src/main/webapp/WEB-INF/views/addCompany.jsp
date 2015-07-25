<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>add company</title>
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
    <div class="row">
      <form action="<c:url value="/companies/add"/>" method="post">
        <div class="col-md-3">
          Name:
          <input type="text" class="form-control" name="name" style="width: 200px;"/><Br />
          County:
          <select name="county_id" class="form-control" style="width: 200px;">
            <c:forEach var="county" items="${countyList}">
              <option value="${county.id}">${county.name}</option>
            </c:forEach>
          </select><Br />
          City:
          <input type="text" class="form-control" name="city" style="width: 200px;"/><Br />
          Street:
          <input type="text" class="form-control" name="street" style="width: 200px;"/><Br />
          Home:
          <input type="text" class="form-control" name="home" style="width: 200px;"/><Br />
          <input type="submit" class="btn btn-default" value="add" />
        </div>
        <div class="col-md-2">
          Office:
          <input type="text" class="form-control" name="office" style="width: 200px;"/><Br />
          Postcode:
          <input type="text" class="form-control" name="postcode" style="width: 200px;"/><Br />
          Site:
          <input type="text" class="form-control" name="site" style="width: 200px;"/><Br />
          Description:
          <textarea class="form-control" name="description" style="width: 200px;"></textarea>
        </div>
      </form>
    </div>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>