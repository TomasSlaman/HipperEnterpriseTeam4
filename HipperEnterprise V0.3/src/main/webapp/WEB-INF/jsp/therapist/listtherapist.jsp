<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<h3>${message}</h3>

<table class="table table-striped table-bordered">
    <caption><strong>List of therapists</strong></caption>
    <tr>
        <td width="5%"><strong> id</strong></td>
        <td><strong> Firstname </strong></td>
        <td><strong> Lastname </strong></td>
        <td><strong> Email </strong></td>
        <td><strong> Role </strong></td>
        <td width="15%"><strong> </strong></td>
    </tr>
    <c:forEach var="therapist" items="${therapists}">
        <tr>
            <td>${therapist.id}</td>
            <td>${therapist.firstName}</td>
            <td>${therapist.lastName}</td>
            <td>${therapist.email}</td>
            <td>${therapist.role}</td>
            <td>
                <div align="center">
                    <a href="${pageContext.request.contextPath}/therapist/edit/${therapist.id}"><button>View</button></a>
                    <a href="${pageContext.request.contextPath}/therapist/delete/${therapist.id}"><button>Delete</button></a>
                    <!--<button><a href="${pageContext.request.contextPath}/therapist/edit/${therapist.id}">Edit</a></button>-->
                    <!--<button><a href="${pageContext.request.contextPath}/therapist/delete/${therapist.id}">Delete</a></button>-->
                </div>
            </td>
        </tr> 

    </c:forEach>
</table>

<!--<div align="right"><button><a href="${pageContext.request.contextPath}/therapist/add">Add patient</a></button></div>-->
<div align="right"><a href="${pageContext.request.contextPath}/therapist/add"><button>Add therapist</button></a></div>

<%@ include file="../template/bottom.jsp" %>
