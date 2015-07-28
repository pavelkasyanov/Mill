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
    <script type="text/javascript">
      jQuery(document).ready( function() {
        $("#menu_item_mills").addClass("active");
      });
    </script>
  </div>
  <Br><Br>
  <div class="row">
    <div class="row">
      <div class="col-md-2">
        <div class="row">
          <img src="<c:url value="/resources/jpg/mills/${millImages[0].src}"/>" width="100" height="100">
        </div>
        <div class="row">
          <Br />
          <a href="<c:url value="/pdfView/mill?id=${mill.id}" />">
            <input type="button" class="btn btn-primary" value="View PDF" />
          </a>
        </div>
        <div class="row">
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <Br />
            <a href="<c:url value="/mills/action/delete/${mill.id}"/>">
                <input type="button" class="btn btn-primary" value="delete mill" />
              </a>
          </sec:authorize>
        </div>
      </div>
      <div class="col-md-6">
        <div class="row">
          Type: ${millType.name}
        </div>
        <div class="row">
          Model:${mill.model}
        </div>
        <div class="row">
          Producer:${millProducer.name}
        </div>
        <div class="row">
          Country Producing:${countryProducing.name}
        </div>
        <div class="row">
          CNC: ${mill.cncType}
        </div>
        <div class="row">
          Year:${mill.year}
        </div>
        <div class="row">
          Machine Location : ${countryMachineLocation.name}
        </div>
        <div class="row">
          Axis: ${mill.axisCount}
        </div>
        <div class="row">
          Moving axis: ${mill.movingX}x${mill.movingY}x${mill.movingZ}
        </div>
        <div class="row">
          Table: ${mill.tableLength}x${mill.tableWidth}
        </div>
        <div class="row">
          Table weight max: ${mill.tableWeightMax}
        </div>
        <div class="row">
          Spindle: ${mill.spindleTaper}
        </div>
        <div class="row">
          Spindle Speed: ${mill.spindleSpeedMax}
        </div>
        <div class="row">
          Spindle power: ${mill.spindlePower}
        </div>
        <div class="row">
          Spindle Torque Max: ${mill.spindleTorqueMax}
        </div>
        <div class="row">
          Spindle Type: ${mill.spindleType}
        </div>
        <div class="row">
          Spindle cooling: ${mill.spindleCooling}
        </div>
        <div class="row">
          Tool Shoop Type: ${toolShoopType.name}
        </div>
        <div class="row">
          tool shoop count: ${mill.toolShoopNumber}
        </div>
        <div class="row">
          tool shoop max d: ${mill.toolShoopMaxD}
        </div>
        <div class="row">
          tool shoop max weight: ${mill.toolShoopWeightMax}
        </div>
        <div class="row">
          tool change time: ${mill.toolShoopChangeTime}
        </div>
        <div class="row">
          Positioning Accuracy: ${mill.positioningAccuracy}
        </div>
        <div class="row">
          Positioning Repeatability: ${mill.positioningRepeatability}
        </div>
        <div class="row">
          spindle work time: ${mill.spindleWorkTime}
        </div>
        <div class="row">
          mill work time: ${mill.workTime}
        </div>
        <div class="row">
          Additional Configuration: ${mill.additionalConfiguration}
        </div>
        <div class="row">
          State: ${millState.name}
        </div>
        <sec:authorize access="isAuthenticated()">
          <div class="row">
            Price: ${mill.price}€
          </div>
        </sec:authorize>
      </div>
    </div>
    <div class="row">
      <div class="row">
      </div>
    </div>
    <Br>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>
