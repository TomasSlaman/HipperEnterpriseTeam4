
<%-- 
    Document   : patient_list
    Created on : Oct 10, 2014, 9:39:18 PM
    Author     : duytran + Christiaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>
<c:choose>
    <c:when test="${exercises.size() != null}">

                <table class="table table-striped table-bordered">
            <caption><strong>List of exercises</strong></caption>
            <tr>
                <td width="5%"><strong>ID</strong></td>
                <td><strong>Exercise Name</strong></td>
               <td><strong>Exercise Duration</strong></td>
                <td><strong>Exercise Type</strong></td>
                <td width="15%"><strong></strong></td>
            </tr>

            <c:forEach var="exercise" items="${exercises}">
                <tr>
                    <td>
                        ${exercise.exerciseId}
                    </td>
                    <td>
                        ${exercise.exerciseName}
                    </td>
                    <td>
                        ${exercise.duration}
                    </td>
                    <td>
                        ${exercise.exerciseType}
                    </td>
                    <td>
                        
                        <a href="${pageContext.request.contextPath}/exercise/edit/${exercise.exerciseId}"><button>Edit</button></a>
                        <a href="${pageContext.request.contextPath}/exercise/delete/${exercise.exerciseId}"><button>Delete</button></a>
<!--                        <button><a href="${pageContext.request.contextPath}/exercise/edit/${exercise.exerciseId}">Edit</a></button>
                        <button><a href="${pageContext.request.contextPath}/exercise/delete/${exercise.exerciseId}">Delete</a><br/></button>-->
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>There are no exercises.</p>
    </c:otherwise>
</c:choose>
        
<!--        <div align="right"><button><a href="${pageContext.request.contextPath}/exercise/add">Add exercise</a></button></div>-->
        <div align="right"><a href="${pageContext.request.contextPath}/exercise/add"><button>Add exercise</button></a></div>
<br>
<%@ include file="../template/bottom.jsp" %>
