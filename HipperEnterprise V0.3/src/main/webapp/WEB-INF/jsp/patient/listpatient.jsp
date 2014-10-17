<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<h3>${message}</h3>

<table class="table table-striped table-bordered">
    <caption><strong>List of patients</strong></caption>
    <tr>
        <td width="5%"><strong> id</strong></td>
        <td><strong> Firstname </strong></td>
        <td><strong> Lastname </strong></td>
        <td><strong> Email </strong></td>
        <!--        <td><strong> Password </strong></td>-->
        <td width="15%"><strong> </strong></td>
    </tr>
    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.id}</td>
            <td>${patient.firstName}</td>
            <td>${patient.lastName}</td>
            <td>${patient.email}</td>
<!--        <td>${patient.password}</td>-->
            <td>
                <div align="center">
                    <button><a href="${pageContext.request.contextPath}/patient/edit/${patient.id}">Edit</a></button>
                    <button><a href="${pageContext.request.contextPath}/patient/delete/${patient.id}">Delete</a></button>
                </div>
            </td>
        </tr> 

    </c:forEach>
</table>

<div align="right"><button><a href="${pageContext.request.contextPath}/patient/add">Add patient</a></button></div>

<%@ include file="../template/bottom.jsp" %>
