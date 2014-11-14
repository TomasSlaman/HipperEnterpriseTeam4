<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<h2></h2>

<form:form method="POST" commandName="patient" action="${pageContext.request.contextPath}/patient/edit" id="awesomeForm" class="weNoTextbox">
    <div class="form-group">
        <label class="control-label col-sm-2" for="id">Id:</label>
        <div class="col-sm-10">
            <form:input path="id" id="idField" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstName">First name:</label>
        <div class="col-sm-10">
            <form:input path="firstName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="LastName">Last name:</label>
        <div class="col-sm-10">          
            <form:input path="lastName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="email">E-mail:</label>
        <div class="col-sm-10">
            <form:input path="email" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Password:</label>
        <div class="col-sm-10">
            <form:input path="password" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="address">Address:</label>
        <div class="col-sm-10">
            <form:input path="address" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
        <div class="col-sm-10">
            <form:input path="postalCode" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="city">City:</label>
        <div class="col-sm-10">
            <form:input path="city" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="length">Length:</label>
        <div class="col-sm-10">
            <form:input path="length" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="weight">Weight:</label>
        <div class="col-sm-10">
            <form:input path="weight" class="form-control" readonly="true" />
        </div>
    </div>
    <div class='col-sm-2'>
        <button type="button" class='btn btn-default hise' onClick="yayWeCanEdit()"><span class="glyphicon glyphicon-pencil"> </span> Edit</button>
    </div>
    <div class="form-group">        
        <div class="col-sm-2">
            <input type="submit" value="Edit patient" class="btn btn-default hise" style="display:none;" />
        </div>
        <div class ='position:relative'>
            <a href="${pageContext.request.contextPath}/patient/addexercise/${patient.id}">             
                <input type="button" value="Add Exercise" class="btn btn-default hise " />    
            </a>
        </div>
        <div class="col-sm-1">
            <a href="${pageContext.request.contextPath}/patient/patientlist">
                <input type="button" value="Cancel" class="btn btn-default hise" style="display:none;" />
            </a> 
        </div>
    </div>
</form:form>

<div id="chart-container">
    <input type="button" id="program" value="Program" />
    <input type="button" id="month" value="Month" />
    <input type="button" id="week" value="Week" />

    <select style="margin-left: 10px" id="type">
        <option value="column">Bar chart</option>
        <option value="line">Line</option>
        <option value="spline">Smooth line</option>
    </select>

    <div id="container">

    </div>
</div>

<% Long s = (Long) request.getAttribute("patientId");%> 

<% request.setAttribute("patientId", s);%>

<table class="table table-striped table-bordered">
    <caption><strong>List of Exercises</strong></caption>
    <tr>
        <td width="5%"><strong> id </strong></td>
        <td><strong> Exercise </strong></td>
        <td><strong> Description </strong></td>
        <td width="15%"><strong> </strong></td>
    </tr>
    <c:forEach var="patientexercises" items="${patientexercises}">
        <tr>
            <td>${patientexercises.exerciseId}</td>
            <td>${patientexercises.exerciseName}</td>
            <td>${patientexercises.description}</td>
            <td>
                <div align="center">
                    <a href="${pageContext.request.contextPath}/patient/viewgraph1/${patientexercises.exerciseId}&${patientId}"><button>View</button></a>
                    <!--<a href=""><button>Delete</button></a>-->
                </div>
            </td>
        </tr> 

    </c:forEach>
</table>   

<a href="${pageContext.request.contextPath}/patient/patientlist"><button>back</button></a> 


<%@ include file="../template/bottom.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        setHighChart();
    });
    var catogories = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
    var data1 = [10, 0, 10, 0, 12, 10, 0];
    var data2 = [10, 0, 8, 0, 10, 3, 0];
    var type = 'column';
    var series;


    $('#program').on('click', function () {
        catogories = ['Week 1', 'Week 2', 'Week 3', 'Week 4', 'Week 5', 'Week 6', 'Weel 7', 'Week 8', 'Week 9', 'Week 10', 'Week 11', 'Week 12'];
        data1 = [3, 4, 5, 5, 6, 7, 8, 9, 10, 10, 11, 11, 12];
        data2 = [3, 4, 5, 6, 6, 6, 8, 9, 10, 10, 11, 12, 12];
        updateSeries([data1, data2]);
        setHighChart();
    });
    $('#month').on('click', function () {
        catogories = ['Week 1', 'Week 2', 'Week 3', 'Week 4'];
        data1 = [3, 4, 5, 5];
        data2 = [3, 4, 5, 6];
        updateSeries([data1, data2]);
        setHighChart();
    });
    $('#week').on('click', function () {
        catogories = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
        data1 = [2, 0, 1, 0, 2, 2, 0];
        data2 = [2, 0, 2, 0, 2, 3, 0];
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
                    text: 'Exercises'
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
