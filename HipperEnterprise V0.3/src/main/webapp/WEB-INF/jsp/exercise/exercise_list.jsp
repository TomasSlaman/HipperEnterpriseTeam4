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
        <h3>This is the exercise overview.</h3>
        <c:choose>
            <c:when test="${exercises.size() != null}">

                <table class="table" border="1px" cellpadding="0" cellspacing="0">
                    <tr>
                        <th>ID</td>
                        <th>Exercise Name</td>
                        <th>Exercise Duration</td>
                        <th>Exercise Type</td>
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
                                <a href="${pageContext.request.contextPath}/exercise/edit/${exercise.exerciseId}">Edit</a>
                                <br/>
                                <a href="${pageContext.request.contextPath}/exercise/delete/${exercise.exerciseId}">Delete</a><br/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>There are no exercises.</p>
            </c:otherwise>
        </c:choose>
        <a href="${pageContext.request.contextPath}/exercise/add">Add exercise</a>
        <br>
        <a href="${pageContext.request.contextPath}/">Back to the index</a>
    <%@ include file="../template/bottom.jsp" %>
