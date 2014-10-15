<%-- 
    Document   : add_exercise
    Created on : Oct 10, 2014, 3:17:55 PM
    Author     : duytran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>
        <h2>${pageTitle}</h2>
        <form:form method="POST" commandName="exercise" action="${pageContext.request.contextPath}/exercise/add" >
            <table>
                <tr>
                    <td> Exercise name: </td>
                    <td> <form:input path="exerciseName" /> </td>
                </tr>
                <tr>
                    <td> Exercise duration: </td>
                    <td> <form:input path="duration" /> </td>
                </tr>
                <tr>
                    <td> <p>Exercise type: </p> </td>
                    <td> <form:input path="exerciseType" /> </td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Add Exercise"/> </td>
                </tr>
            </table>
        </form:form>
<%@ include file="../template/bottom.jsp" %>