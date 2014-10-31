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

    <form:form action="${pageContext.request.contextPath}/patient/addexercise/${patient.id}" method="POST" commandName="patient">

        <form:hidden path="id"/>



    </form:form>

    <form action="${pageContext.request.contextPath}/patient/addexercise/${patient.id}" method="POST">
        <form:select path="exercises">
            <form:option value="0">Selecteer een rol</form:option>
            <form:options items="${exercises}" itemValue="exerciseId" itemLabel="exerciseName"/>
        </form:select>

        <input type="submit" value="Add Exercises" class="btn btn-default" />
    </form>
    

</div>
<%@ include file="../template/bottom.jsp" %>