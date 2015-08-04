<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>compare mills</title>
</head>
<body>
<div class="container">
  <div class="row">
    <jsp:include page="parts/header.jsp" />
  </div>
  <script type="text/javascript">
    jQuery(document).ready( function() {
      $("#menu_item_mills").addClass("active");
    });
  </script>
  <div class="row">
  </div>
  <div class="row">
    <table class="table table-hover">
      <caption>Mill compare table</caption>
      <thead>
        <tr>
          <th>#</th>
          <th>
            <a href="<c:url value="/mills/mill?id=${millModelFrom.id}"/>">
              <div class="row">
                ${millModelFrom.axisCount}-осевой ${millModelFrom.millType.name}
              </div>
              <div class="row">
                ${millModelFrom.model} (${millModelFrom.producer.name}, ${millModelFrom.countryProducing.name})
              </div>
            </a>
          </th>
          <th>
            <a href="<c:url value="/mills/mill?id=${millModelWith.id}"/>">
              <div class="row">
                ${millModelWith.axisCount}-осевой ${millModelWith.millType.name}
              </div>
              <div class="row">
                ${millModelWith.model} (${millModelWith.producer.name}, ${millModelWith.countryProducing.name})
              </div>
            </a>
          </th>
        </tr>
      </thead>
      <tbody>
        <c:if test="${millModelFrom.cncType eq millModelWith.cncType}">
          <tr>
        </c:if>
        <c:if test="${millModelFrom.cncType ne millModelWith.cncType}">
          <tr class="warning">
        </c:if>
          <th score="row">cncType</th>
          <td>${millModelFrom.cncType}</td>
          <td>${millModelWith.cncType}</td>
        </tr>
        <c:if test="${millModelFrom.year == millModelWith.year}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.year != millModelWith.year}">
        <tr class="warning">
          </c:if>
          <th score="row">Year</th>
          <td>${millModelFrom.year}</td>
          <td>${millModelWith.year}</td>
        </tr>
        <c:if test="${millModelFrom.machineLocation.name eq millModelWith.machineLocation.name}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.machineLocation.name ne millModelWith.machineLocation.name}">
        <tr class="warning">
          </c:if>
          <th score="row">Machine Location</th>
          <td>${millModelFrom.machineLocation.name}</td>
          <td>${millModelWith.machineLocation.name}</td>
        </tr>
        <c:if test="${millModelFrom.axisCount == millModelWith.axisCount}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.axisCount != millModelWith.axisCount}">
        <tr class="warning">
          </c:if>
          <th score="row">axisCount</th>
          <td>${millModelFrom.axisCount}</td>
          <td>${millModelWith.axisCount}</td>
        </tr>
        <c:if test="${millModelFrom.movingX == millModelWith.movingX &&
                      millModelFrom.movingY == millModelWith.movingY &&
                      millModelFrom.movingZ == millModelWith.movingZ}">
          <tr>
        </c:if>
        <c:if test="${millModelFrom.movingX != millModelWith.movingX ||
                      millModelFrom.movingY != millModelWith.movingY ||
                      millModelFrom.movingZ != millModelWith.movingZ}">
          <tr class="warning">
        </c:if>
          <th score="row">Moving axis</th>
          <td>${millModelFrom.movingX}x${millModelFrom.movingY}x${millModelFrom.movingZ}</td>
          <td>${millModelWith.movingX}x${millModelWith.movingY}x${millModelWith.movingZ}</td>
        </tr>
        <c:if test="${millModelFrom.tableLength == millModelWith.tableLength &&
                      millModelFrom.tableWidth == millModelWith.tableWidth}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.tableLength != millModelWith.tableLength ||
                      millModelFrom.tableWidth != millModelWith.tableWidth}">
        <tr class="warning">
          </c:if>
          <th score="row">Table</th>
          <td>${millModelFrom.tableLength}x${millModelFrom.tableWidth}</td>
          <td>${millModelWith.tableLength}x${millModelWith.tableWidth}</td>
        </tr>
        <c:if test="${millModelFrom.tableWeightMax == millModelWith.tableWeightMax}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.tableWeightMax != millModelWith.tableWeightMax}">
        <tr class="warning">
          </c:if>
          <th score="row">Table weight max</th>
          <td>${millModelFrom.tableWeightMax}</td>
          <td>${millModelWith.tableWeightMax}</td>
        </tr>
        <c:if test="${millModelFrom.spindleTaper eq millModelWith.spindleTaper}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleTaper ne millModelWith.spindleTaper}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle</th>
          <td>${millModelFrom.spindleTaper}</td>
          <td>${millModelWith.spindleTaper}</td>
        </tr>
        <c:if test="${millModelFrom.spindleSpeedMax == millModelWith.spindleSpeedMax}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleSpeedMax != millModelWith.spindleSpeedMax}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle Speed</th>
          <td>${millModelFrom.spindleSpeedMax}</td>
          <td>${millModelWith.spindleSpeedMax}</td>
        </tr>
        <c:if test="${millModelFrom.spindlePower eq millModelWith.spindlePower}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindlePower ne millModelWith.spindlePower}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle power</th>
          <td>${millModelFrom.spindlePower}</td>
          <td>${millModelWith.spindlePower}</td>
        </tr>
        <c:if test="${millModelFrom.spindleTorqueMax == millModelWith.spindleTorqueMax}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleTorqueMax != millModelWith.spindleTorqueMax}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle Torque Max</th>
          <td>${millModelFrom.spindleTorqueMax}</td>
          <td>${millModelWith.spindleTorqueMax}</td>
        </tr>
        <c:if test="${millModelFrom.spindleType eq millModelWith.spindleType}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleType ne millModelWith.spindleType}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle Type</th>
          <td>${millModelFrom.spindleType}</td>
          <td>${millModelWith.spindleType}</td>
        </tr>
        <c:if test="${millModelFrom.spindleCooling eq millModelWith.spindleCooling}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleCooling ne millModelWith.spindleCooling}">
        <tr class="warning">
          </c:if>
          <th score="row">Spindle cooling</th>
          <td>${millModelFrom.spindleCooling}</td>
          <td>${millModelWith.spindleCooling}</td>
        </tr>
        <c:if test="${millModelFrom.toolShoopType.name eq millModelWith.toolShoopType.name}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.toolShoopType.name ne millModelWith.toolShoopType.name}">
        <tr class="warning">
          </c:if>
          <th score="row">Tool Shoop Type</th>
          <td>${millModelFrom.toolShoopType.name}</td>
          <td>${millModelWith.toolShoopType.name}</td>
        </tr>
        <c:if test="${millModelFrom.toolShoopNumber == millModelWith.toolShoopNumber}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.toolShoopNumber != millModelWith.toolShoopNumber}">
        <tr class="warning">
          </c:if>
          <th score="row">Tool Shoop Count</th>
          <td>${millModelFrom.toolShoopNumber}</td>
          <td>${millModelWith.toolShoopNumber}</td>
        </tr>
        <c:if test="${millModelFrom.toolShoopMaxD == millModelWith.toolShoopMaxD}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.toolShoopMaxD != millModelWith.toolShoopMaxD}">
        <tr class="warning">
          </c:if>
          <th score="row">tool shoop max d</th>
          <td>${millModelFrom.spindleTorqueMax}</td>
          <td>${millModelWith.spindleTorqueMax}</td>
        </tr>
        <c:if test="${millModelFrom.toolShoopWeightMax == millModelWith.toolShoopWeightMax}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.toolShoopWeightMax != millModelWith.toolShoopWeightMax}">
        <tr class="warning">
          </c:if>
          <th score="row">tool shoop max weight</th>
          <td>${millModelFrom.toolShoopWeightMax}</td>
          <td>${millModelWith.toolShoopWeightMax}</td>
        </tr>
        <c:if test="${millModelFrom.toolShoopChangeTime == millModelWith.toolShoopChangeTime}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.toolShoopChangeTime != millModelWith.toolShoopChangeTime}">
        <tr class="warning">
          </c:if>
          <th score="row">tool Shoop Change Time</th>
          <td>${millModelFrom.toolShoopChangeTime}</td>
          <td>${millModelWith.toolShoopChangeTime}</td>
        </tr>
        <c:if test="${millModelFrom.positioningAccuracy == millModelWith.positioningAccuracy}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.positioningAccuracy != millModelWith.positioningAccuracy}">
        <tr class="warning">
          </c:if>
          <th score="row">positioning Accuracy</th>
          <td>${millModelFrom.positioningAccuracy}</td>
          <td>${millModelWith.positioningAccuracy}</td>
        </tr>
        <c:if test="${millModelFrom.positioningRepeatability == millModelWith.positioningRepeatability}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.positioningRepeatability != millModelWith.positioningRepeatability}">
        <tr class="warning">
          </c:if>
          <th score="row">positioning Repeatability</th>
          <td>${millModelFrom.positioningRepeatability}</td>
          <td>${millModelWith.positioningRepeatability}</td>
        </tr>
        <c:if test="${millModelFrom.spindleWorkTime == millModelWith.spindleWorkTime}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.spindleWorkTime != millModelWith.spindleWorkTime}">
        <tr class="warning">
          </c:if>
          <th score="row">spindleWorkTime</th>
          <td>${millModelFrom.spindleWorkTime}</td>
          <td>${millModelWith.spindleWorkTime}</td>
        </tr>
        <c:if test="${millModelFrom.workTime == millModelWith.workTime}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.workTime != millModelWith.workTime}">
        <tr class="warning">
          </c:if>
          <th score="row">workTime</th>
          <td>${millModelFrom.workTime}</td>
          <td>${millModelWith.workTime}</td>
        </tr>
        <c:if test="${millModelFrom.additionalConfiguration eq millModelWith.additionalConfiguration}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.additionalConfiguration ne millModelWith.additionalConfiguration}">
        <tr class="warning">
          </c:if>
          <th score="row">additional Configuration</th>
          <td>${millModelFrom.additionalConfiguration}</td>
          <td>${millModelWith.additionalConfiguration}</td>
        </tr>
        <c:if test="${millModelFrom.millState.id == millModelWith.millState.id}">
        <tr>
          </c:if>
          <c:if test="${millModelFrom.millState.id != millModelWith.millState.id}">
        <tr class="warning">
          </c:if>
          <th score="row">mill State</th>
          <td>${millModelFrom.millState.name}</td>
          <td>${millModelWith.millState.name}</td>
        </tr>
        <sec:authorize access="isAuthenticated()">
          <c:if test="${millModelFrom.price == millModelWith.price}">
          <tr>
            </c:if>
            <c:if test="${millModelFrom.price != millModelWith.price}">
          <tr class="warning">
            </c:if>
            <th score="row">price</th>
            <td>${millModelFrom.price}</td>
            <td>${millModelWith.price}</td>
          </tr>
        </sec:authorize>
      </tbody>
    </table>
  </div>
  <footer>
    <jsp:include page="parts/footer.jsp" />
  </footer>
</div>
</body>
</html>