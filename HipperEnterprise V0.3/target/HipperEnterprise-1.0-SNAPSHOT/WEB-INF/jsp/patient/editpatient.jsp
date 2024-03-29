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
            <form:errors path="firstName" style="color:red;"/>
            <form:input path="firstName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="LastName">Last name:</label>
        <div class="col-sm-10">         
            <form:errors path="lastName" style="color:red;"/>
            <form:input path="lastName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="email">E-mail:</label>
        <div class="col-sm-10">
            <form:errors path="email" style="color:red;"/>
            <form:input path="email" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Password:</label>
        <div class="col-sm-10">
            <form:errors path="password" style="color:red;"/>
            <form:input path="password" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="address">Address:</label>
        <div class="col-sm-10">
            <form:errors path="address" style="color:red;"/>
            <form:input path="address" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
        <div class="col-sm-10">
            <form:errors path="postalCode" style="color:red;"/>
            <form:input path="postalCode" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="city">City:</label>
        <div class="col-sm-10">
            <form:errors path="city" style="color:red;"/>
            <form:input path="city" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="length">Length:</label>
        <div class="col-sm-10">
            <form:errors path="length" style="color:red;"/>
            <form:input path="length" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="weight">Weight:</label>
        <div class="col-sm-10">
            <form:errors path="weight" style="color:red;"/>
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

<script>
    checkStatus();
    function checkStatus() {
        var x = ${errored};
        if (x) {
            yayWeCanEdit();
        }
    }
    
</script>