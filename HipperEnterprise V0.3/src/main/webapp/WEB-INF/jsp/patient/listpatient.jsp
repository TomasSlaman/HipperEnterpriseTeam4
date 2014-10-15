<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

        <h2>This is the patientoverview </h2>
         <h3>${message}</h3>
            <table class="table" border="1px" cellpadding="0" cellspacing="0">
                <tr>
                    <td><strong> id</strong></td>
                    <td><strong> Firstname </strong></td>
                    <td><strong> Lastname </strong></td>
                    <td><strong> Email </strong></td>
                    <td><strong> Password </strong></td>
                    <td><strong> </strong></td>
                </tr>
                <c:forEach var="patient" items="${patients}">
                    <tr>
                        <td>${patient.id}</td>
                        <td>${patient.firstName}</td>
                        <td>${patient.lastName}</td>
                        <td>${patient.email}</td>
                        <td>${patient.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/patient/edit/${patient.id}">Edit</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/patient/delete/${patient.id}">Delete</a><br/>
                        </td>
                    </tr> 
                </c:forEach>
            </table>
 <p>
            <a href="${pageContext.request.contextPath}/patient/add">Add patient</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/index">Back to index</a>
        </p>
<%@ include file="../template/bottom.jsp" %>
