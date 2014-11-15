<%-- 
    Document   : addexercise
    Created on : Nov 10, 2014, 10:40:28 PM
    Author     : duytran
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<form:form action="${pageContext.request.contextPath}/patient/addexercise" method="POST" commandName="program" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-2" for="Name">Name:</label>
        <div class="col-sm-10">  
            <form:input class="form-control" readonly="true" path="patient" value="${patient.firstName}"/>
        </div>
    </div>
        <div class="form-group">
        <label class="control-label col-sm-2" for="Exercise">Exercise:</label>
        <div class="col-sm-10">  
    <form:select path="exercise" class="form-control">
        <form:option value="0">Select an exercise</form:option>
        <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
    </form:select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="sets">Sets:</label>
        <div class="col-sm-10">          
            <form:errors path="sets" style="color:red;"/>
            <form:input path="sets" class="form-control" placeholder="Enter sets" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="sets">Repetitions:</label>
        <div class="col-sm-10">          
            <form:errors path="repetitions" style="color:red;"/>
            <form:input path="repetitions" class="form-control" placeholder="Enter repetitions" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="date">Date:</label>
        <div class="col-sm-10">
            <form:errors path="date" style="color:red;"/>
            <form:input path="date" class="form-control" placeholder="Enter a date (DD-MM-YYYY)" />
        </div>
    </div>
        <div class="form-group">        
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Add Exercise" class="btn btn-default" />
                <a href="${pageContext.request.contextPath}/patient/edit/${patient.id}">
                    <input type="button" value="Cancel" class="btn btn-default" />
                </a> 
            </div>
        </div>
</form:form>


<%@ include file="../template/bottom.jsp" %>
