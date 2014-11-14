<%-- 
    Document   : edit_exercise
    Created on : Oct 15, 2014, 1:19:44 PM
    Author     : duytran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>
<h2>${pageTitle}</h2>
<form:form method="POST" commandName="exercise" action="${pageContext.request.contextPath}/exercise/edit" >
    <table>
        <tr>
            <td>Id</td>
            <td><form:input path="exerciseId" class="form-control" readonly="true" /></td>
            <td><form:errors path="exerciseId" style="color:red;"/></td>
        </tr>
        <tr>
            <td> Exercise name: </td>
            <td> <form:input path="exerciseName" class="form-control"/> </td>
            <td><form:errors path="exerciseName" style="color:red;"/></td>
        </tr>
        <tr>
            <td> Exercise duration: </td>
            <td> <form:input path="duration" class="form-control" /> </td>
            <td><form:errors path="duration" style="color:red;"/></td>
        </tr>
        <tr>
            <td> <p>Exercise type: </p> </td>
            <td> <form:input path="exerciseType" class="form-control"/> </td>
            <td><form:errors path="exerciseType" style="color:red;"/></td>
        </tr>
        <tr>
            <td> <p>Description: </p> </td>
            <td> <form:input path="description" class="form-control"/> </td>
            <td><form:errors path="description" style="color:red;"/></td>
        </tr>
        <tr>
            <td> <input type="submit" value="Update Exercise" class="btn btn-default"/> </td>
            <td><a href="${pageContext.request.contextPath}/exercise/list">
                <input type="button" value="Cancel" class="btn btn-default" /></td>
        </tr>
    </table>
</form:form>
<%@ include file="../template/bottom.jsp" %>