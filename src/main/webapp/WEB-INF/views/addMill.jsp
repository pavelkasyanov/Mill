<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
  <title>Mill</title>
</head>
<body>
<div class="container">
  <div class="row">
    <jsp:include page="parts/header.jsp" />
  </div>
  <div class="row">
    <hr>
    <form action="<c:url value="/mills/action/add"/>" method="post" enctype="multipart/form-data">
      <c:if test="${not empty addResult}">
        <div class="bg-success" style="width: 100px">
            ${addResult}
        </div>
      </c:if>
      File to upload: <input type="file" name="file"><br />
      <input type="submit" value="Upload"> Press here to upload the file!
    </form>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>