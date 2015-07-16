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
    <script type="text/javascript">
        jQuery(document).ready( function() {
            $("#menu_item_about").addClass("active");
        });
    </script>
    <div class="row">

    </div>
    <div class="row">
        <hr>
        <h1>EfTech test task</h1>
    </div>
    <footer>
        <jsp:include page="parts/footer.jsp" />
    </footer>
</div>
</body>
</html>