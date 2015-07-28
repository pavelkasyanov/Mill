<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <title>Mills</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <jsp:include page="parts/header.jsp" />
            <script type="text/javascript">
                jQuery(document).ready(function ($) {
                    $('#mytabs').tab();
                    $("#menu_item_mills").addClass("active");
                });
                function setProducer(producerId, producerName) {
                    var filterResetImage = '<img id="resetFilterImg"' +
                            'src="<c:url value="/resources/jpg/filter-reset.png"/>"';
                    var linkResetFilter = '<a href="javascript:void(0)" '+'onclick="resetProducerFilter();" id="linkResetFilter">'+
                            filterResetImage+'</a>';
                    document.getElementById("li_tab_2").innerHTML = producerName + linkResetFilter;
                    document.getElementById("millProducer").value = producerName;
                }

                function resetProducerFilter() {
                    var element = document.getElementById("resetFilterImg");
                    element.outerHTML = "";
                    delete element;
                    document.getElementById("li_tab_2").innerHTML = "Producer";
                }

                function resetYearFilter() {
                    var element = document.getElementById("resetYearFilterImg");
                    element.outerHTML = "";
                    delete element;

                    document.getElementById("li_tab_1").value = "Year";

                    document.getElementById("year_1").value = '';
                    document.getElementById("year_2").value = '';
                }

                function setYearSearchParam(e, id){
                    var filterYearResetImage = '<img id="resetYearFilterImg"' +
                            'src="<c:url value="/resources/jpg/filter-reset.png"/>">';
                    var linkYearResetFilter = '<a href="javasctript:void(0);" onclick="resetYearFilter();" id="linkResetFilter">'+
                            filterYearResetImage+'</a>';

                    var p1 = document.getElementById("year_1").value;
                    var p2 = document.getElementById("year_2").value;
                    if (id == 1) {
                        p1 += String.fromCharCode(e.keyCode);
                    }else {
                        p2 += String.fromCharCode(e.keyCode);
                    }
                    document.getElementById("li_tab_1").innerHTML = p1 + ' - ' + p2 + linkYearResetFilter;
                    if (e.keyCode == 13 ) {
                        return false;
                    }

                    return true;
                }

                function showSearchForm() {
                    $("#search_form").collapse('toggle');
                    $("#compareForm").collapse('hide');
                }

                function showCompareForm() {
                    $("#search_form").collapse('hide');
                    $("#compareForm").collapse('toggle');
                }

            </script>
        </div>
        <Br/>
        <div class="row" id="subMenu">
            <div class="col-md-1">
                <input type="button" class="btn btn-default" value="search" onclick="showSearchForm();" />
            </div>
            <div class="col-md-1">
                <input type="button" class="btn btn-default" value="compare" onclick="showCompareForm();" />
            </div>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <div class="col-md-1">
                    <a class="btn btn-default" href="<c:url value="/mills/action/add"/>">Add mill</a>
                </div>
            </sec:authorize>
        </div><Br/>
        <div class="row collapse" id="search_form">
            <form class="form-inline" action="<c:url value="/mills/search"/>" method="get">
                <div class="row tabs" id="mytabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab1" data-toggle="tab" id="li_tab_1">Year</a></li>
                        <li><a href="#tab2" data-toggle="tab"id="li_tab_2">Producer</a></li>
                        <li><a href="#tab3" data-toggle="tab"id="li_tab_3">Technical specs</a></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id = "tab1">
                        <div class="panel panel-default" style="border: solid white">
                            <div class="panel-body">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="beginYear"
                                                   class="form-control" placeholder="year" id="year_1"
                                                    onkeydown="return setYearSearchParam(event, 1);" style="width: 50pt;">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="endYear"
                                                   class="form-control" placeholder="year" id="year_2"
                                                   onkeypress="return setYearSearchParam(event, 2);" style="width: 50pt;">
                                        </div>
                                    </div>
                                    <%--<button type="submit" class="btn btn-primary">Search</button>--%>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id = "tab2">
                        <div class="panel panel-default" style="border: solid white">
                            <div class="panel-body">
                                <ul>
                                    <c:forEach var="producerItem" items="${producersList}">
                                        <li>
                                            <a href="javascript:void(0)"
                                               onclick="setProducer(${producerItem.id}, '${producerItem.name}')">
                                                ${producerItem.name}
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <input type="hidden" class="text-input" name="millProducer" id="millProducer">
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id = "tab3">
                        <div class="panel panel-default" style="border: solid white">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        Longitudinal travel X:
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="minLongitudinalTravelX"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="maxLongitudinalTravelX"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        Transversal travel Y:
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="minTransversalTravelY"
                                                   class="form-control" placeholder="longitudinalTravelX" style="width: 50pt;">
                                        </div>
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="maxTransversalTravelY"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                    </div>
                                </div><Br>
                                <div class="row">
                                    <div class="form-group">
                                        Vertical travel Z:
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="minVerticalTravelZ"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="maxVerticalTravelZ"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        CNC:
                                        <div class="input-group">
                                            <div class="input-group-addon">CNC:</div>
                                            <input type="text" name="CNC"
                                                   class="form-control" placeholder="CNC" style="width: 50pt;">
                                        </div>
                                    </div>
                                </div><Br>
                                <div class="row">
                                    <div class="form-group">
                                        Table length:
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="minTableLength"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="maxTableLength"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        Table width:
                                        <div class="input-group">
                                            <div class="input-group-addon">from</div>
                                            <input type="text" name="minTableWidth"
                                                   class="form-control" placeholder="longitudinalTravelX" style="width: 50pt;">
                                        </div>
                                        <div class="input-group">
                                            <div class="input-group-addon">to</div>
                                            <input type="text" name="maxTableWidth"
                                                   class="form-control" placeholder="TravelX" style="width: 50pt;">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary" value="Search">
            </form>
        </div>
        <div class="row collapse" id="compareForm">
            <form class="form-inline" action="<c:url value="/mills/compare"/>" method="get">
                <select class="form-control" name="from">
                    <c:forEach var="mill" items="${mills}">
                        <option value="${mill.id}">${mill.model}</option>
                    </c:forEach>
                </select>
                <c:out value="with:" />
                <select class="form-control" name="with">
                    <c:forEach var="mill" items="${mills}">
                        <option value="${mill.id}">${mill.model}</option>
                    </c:forEach>
                </select>
                <input type="submit" class="btn btn-primary" value="compare" />
            </form>
        </div>
        <Hr />
        <div class="row">
            <c:forEach var="mill" items="${mills}">
                <div class="row">
                    <div class="col-md-2">
                        <img src="${pageContext.request.contextPath}/resources/jpg/mills/${imageMap[mill.id].src}"
                             width="100" height="100">
                    </div>
                    <div class="col-md-3">
                        <div class="row">
                            <a href="${pageContext.request.contextPath}/mills/mill?id=${mill.id}">${mill.model}</a>
                        </div>
                        <div class="row">
                            Producer:${producersList[mill.producerId-1].name}
                        </div>
                        <div class="row">
                            Year:${mill.year}
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="row">
                            Longitudinal travel X: ${mill.movingX}
                        </div>
                        <div class="row">
                            Vertical travel Z: ${mill.movingZ}
                        </div>
                        <div class="row">
                            Table length: ${mill.tableLength}
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="row">
                            Transversal travel Y: ${mill.movingY}
                        </div>
                        <div class="row">
                            CNC: ${mill.cncType}
                        </div>
                        <div class="row">
                            Table width: ${mill.tableWidth}
                        </div>
                    </div>
                    <div class="col-md-2">
                        Contry:${countryList[mill.countryProducingId -1].name}
                    </div>
                    <div class="col-md-1">
                        <div class="row">
                            ${mill.year}
                        </div>
                        <sec:authorize access="isAuthenticated()">
                            <div class="row">
                                ${mill.price}€
                            </div>
                        </sec:authorize>
                    </div>
                </div>
                <Br>
            </c:forEach>
        </div>
        <footer>
            <jsp:include page="parts/footer.jsp" />
        </footer>
    </div>
</body>
</html>
