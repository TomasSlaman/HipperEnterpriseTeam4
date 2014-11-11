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

<form action="${pageContext.request.contextPath}/patient/addexercise/${patient.id}" method="POST" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-2" for="Name">Name:</label>
        <div class="col-sm-10">  
            <form:input class="form-control" readonly="true" name="patient" path="patient" value="${patient.firstName}"/>
        </div>
    </div>
        <div class="form-group">
        <label class="control-label col-sm-2" for="Exercise">Exercise:</label>
        <div class="col-sm-10">  
    <form:select name="exercise" path="exercises" class="form-control">
        <form:option value="0">Select an exercise</form:option>
        <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
    </form:select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="sets">Sets:</label>
        <div class="col-sm-10">          
            <input type="text" name="sets" class="form-control" placeholder="Enter sets"/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="date">Date:</label>
        <div class="col-sm-10">
            <input type="text" name="date" class="form-control" placeholder="Enter a date (DD-MM-YYYY)"/>
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
</form>


<%@ include file="../template/bottom.jsp" %>
