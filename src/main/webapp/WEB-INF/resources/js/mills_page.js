function setProducer(producerId, producerName) {
    var filterResetImage = '<img id="resetFilterImg"' +
        'src="resources/jpg/filter-reset.png">';
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
        'src="resources/jpg/filter-reset.png">';
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
