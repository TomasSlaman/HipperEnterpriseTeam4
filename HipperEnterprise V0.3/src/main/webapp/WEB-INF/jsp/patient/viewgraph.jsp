<%-- 
    Document   : viewexercise
    Created on : 1-nov-2014, 23:32:16
    Author     : Ezra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>


<h3>${pageTitle}</h3>
Patient: ${patient.firstName} ${patient.lastName} <br>
Exercise: ${exercise.getExerciseName()}

<div id="chart-container">
    <input type="button" id="program" value="Program" />
    <input type="button" id="month" value="Month" />
    <input type="button" id="week" value="Week" />

    <select style="margin-left: 10px" id="type">
        <option value="line">Line</option>
        <option value="column">Bar chart</option>
        <option value="spline">Smooth line</option>
    </select>
    <label>
        <input type="checkbox" id="sensordata" />
        Sensordata
    </label>

    <div id="container">

    </div>
</div>

<div><br>
    Results here please<br>
    <br>
</div>
<form:form commandName="patient">
    <table class="table table-striped table-condensed">
        <!--<caption><strong>Comment section</strong></caption>-->
        <tr>
            <td width="45%"><strong> Exercise Information </strong></td>

        </tr>
        <tr>
            <td>${exercise.getExerciseName()}</td>
        </tr>
        <tr>
            <td>${exercise.getDescription()}</td>
        </tr>
    </table>
</form:form>
<br>
<br>
<!--</div>-->
<% Long s = (Long) request.getAttribute("patientId");%> 
<% request.setAttribute("patientId", s);%>

<table class="table table-striped table-condensed">
    <tr>
        <td width="10%"><strong> Date </strong></td>
        <td width="70%"><strong> Comment </strong></td>
        <td width="10%"><strong> </strong></td>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.date}</td>
            <td>${comment.comment}</td>
            <td>
                <div align="center">
                    <a href="${pageContext.request.contextPath}/patient/deletecomment/${comment.commentId}"><button>Delete</button></a>                       
                </div>
            </td>
        </tr> 
    </c:forEach>
</table>

<form:form class="form-horizontal" role="form" method="POST" commandName="comment" action="${pageContext.request.contextPath}/patient/viewgraph2/${exercise.exerciseId}&${patientId}">
    <div class="form-group">
        <div class="col-sm-10">
            <form:input path="comment" class="form-control" placeholder="Enter a comment here" />
        </div>
    </div>
    <div class="form-group">        
        <div class="col-sm-10">
            <input type="submit" value="Add comment" class="btn btn-default"/>
            <a href="${pageContext.request.contextPath}/patient/viewgraph2/${exercise.exerciseId}&${patientId}">
                <!--<input type="button" value="Cancel" class="btn btn-default" />-->
            </a> 
        </div>
    </div>
</form:form>

<a href="${pageContext.request.contextPath}/patient/edit/${patientId}"><button>back</button></a> 
<%@ include file="../template/bottom.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        setHighChart();
    });
    var catogories = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
    var data1 = [10, 0, 10, 0, 12, 10, 0];
    var data2 = [10, 0, 8, 0, 10, 3, 0];
    var data3 = ${sensordata};
    var type = 'line';
    var series;


    $('#program').on('click', function () {
        catogories = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        data1 = [42 * 4, 50 * 4, 50 * 4, 53 * 4, 53 * 4, 53 * 4, 52 * 4, 52 * 4, 52 * 4, 52 * 4, 52 * 4, 53 * 4];
        data2 = [31 * 4, 34 * 4, 37 * 4, 40 * 4, 45 * 4, 48 * 4, 52 * 4, 52 * 4, 52 * 4, 44 * 4, 45 * 4, 49 * 4];
        updateSeries([data1, data2]);
        setHighChart();
    });
    $('#month').on('click', function () {
        catogories = ['Week 1', 'Week 2', 'Week 3', 'Week 4'];
        data1 = [42, 43, 45, 43];
        data2 = [31, 34, 37, 40];
        updateSeries([data1, data2]);
        setHighChart();
    });
    $('#week').on('click', function () {
        catogories = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
        data1 = [10, 0, 10, 0, 12, 10, 0];
        data2 = [10, 0, 8, 0, 10, 3, 0];
        updateSeries([data1, data2]);
        setHighChart();
    });

    $('#type').on('change', function () {
        type = $('#type option:selected').val();
        setHighChart();
    });

    function updateSeries(data) {
        for (var key in series) {
            if (series.hasOwnProperty(key) && series[key].name !== 'Sensordata') {
                series[key].data = data[key];
            }
        }
    }

    series = [{
            name: 'Goal',
            data: data1
        }, {
            name: 'Patient',
            data: data2
        }
    ];

    $('#sensordata').on('click', function () {
        console.log($(this));
        if (!$(this).prop('checked')) {
            for (var key in series) {
                if (series.hasOwnProperty(key) && series[key].name === 'Sensordata') {
                    series.splice(key, 1);
                }
            }
        } else {
            series.push({name: "Sensordata", data: data3});
        }
        setHighChart();
    });

    function setHighChart() {
        $('#container').highcharts({
            chart: {
                type: type
            },
            title: {
                text: '${exercise.getExerciseName()}',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            xAxis: {
                categories: catogories
            },
            yAxis: {
                title: {
                    text: 'Reps'
                },
                plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
            },
            tooltip: {
                valueSuffix: ' exercises'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: series
        });
    }
</script>
<script src="../../resources/js/highchart/js/highcharts.js"></script>
<script src="../../resources/js/highchart/js/modules/exporting.js"></script>
