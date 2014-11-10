<%-- 
    Document   : addexercisetopatient
    Created on : Oct 29, 2014, 8:19:08 PM
    Author     : duytran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>
<div class="form-field">

    <h2>Add some exercises</h2>  
    <h2>${message}</h2>

    <form:form action="${pageContext.request.contextPath}/patient/addexercise/${patient.id}" method="POST" commandName="patient">

        <form:hidden path="id"/>

    </form:form>

    <form action="${pageContext.request.contextPath}/patient/addexercise/${patient.id}" method="POST">
        <form:select name="exercises1" path="exercises" class="form-control">
            <form:option value="0">Select an exercise</form:option>
            <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
        </form:select>
        <br>
        <br>
        <form:select name="exercises2" path="exercises" class="form-control">
            <form:option value="0">Select an exercise</form:option>
            <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
        </form:select>
        <br>
        <br>
        <form:select name="exercises3" path="exercises" class="form-control">
            <form:option value="0">Select an exercise</form:option>
            <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
        </form:select>
        <br>
        <br>
        <form:select name="exercises4" path="exercises" class="form-control">
            <form:option value="0">Select an exercise</form:option>
            <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
        </form:select>
        <br>
        <br>
        <input type="submit" value="Add Exercises" class="btn btn-default" />
    </form>


</div>
<%@ include file="../template/bottom.jsp" %>