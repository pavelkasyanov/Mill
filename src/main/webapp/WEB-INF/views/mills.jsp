<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                });

                function setProducer(producerId, producerName) {
                    var filterResetImage = '<img id="resetFilterImg"' +
                            'src="${pageContext.request.contextPath}/resources/jpg/filter-reset.png">';
                    var linkResetFilter = '<a href="javasctript:void(0);" '+'onclick="resetProducerFilter();" id="linkResetFilter">'+
                            filterResetImage+'</a>';
                    document.getElementById("li_tab_2").innerHTML = producerName + linkResetFilter;
                    document.getElementById("millProducerSearch").value = producerName;
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
                            'src="${pageContext.request.contextPath}/resources/jpg/filter-reset.png">';
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
            </script>
        </div>
        <Br>
        <div class="row tabs" id="mytabs">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab" id="li_tab_1">Year</a></li>
                <li><a href="#tab2" data-toggle="tab"id="li_tab_2">Producer</a></li>
                <li><a href="#tab3" data-toggle="tab"id="li_tab_3">Technical specs</a></li>
                <li><a href="#tab4" data-toggle="tab">tab_4</a></li>
            </ul>
        </div>
        <div class="tab-content">
            <div class="tab-pane fade in active" id = "tab1">
                <div class="panel panel-default" style="border: solid white">
                    <div class="panel-body">
                        <form method="get" class="form-inline">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">from</div>
                                    <input type="text" class="form-control" placeholder="year" id="year_1"
                                            onkeydown="return setYearSearchParam(event, 1);">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">to</div>
                                    <input type="text" class="form-control" placeholder="year" id="year_2"
                                           onkeypress="return setYearSearchParam(event, 2);">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id = "tab2">
                <div class="panel panel-default" style="border: solid white">
                    <div class="panel-body">
                        <ul>
                            <c:forEach var="producerItem" items="${producersList}">
                                <li>
                                    <a href="javasctript:void(0);" onclick="setProducer(${producerItem.id}, '${producerItem.name}')">
                                        ${producerItem.name}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                        <input type="hidden" class="text-input" name="millProducerSearch" id="millProducerSearch">
                    </div>
                </div>
            </div>
        </div>
        <Br>
        <div class="row">
            <%--<h2>This is mills page</h2>--%>
            <c:forEach var="mill" items="${mills}">
                <div class="row">
                    <div class="col-md-2">
                        <img src="${pageContext.request.contextPath}/resources/jpg/mills/${mill.image}" width="100" height="100">
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <a href="mills/mill?id=${mill.id}">${mill.name}</a>
                        </div>
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