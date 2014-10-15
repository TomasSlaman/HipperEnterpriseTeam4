<%-- 
    Document   : patient_list
    Created on : Oct 10, 2014, 9:39:18 PM
    Author     : duytran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise Overview</title>
    </head>
    <body>
        <h3>This is the exercise overview.</h3>
        <c:choose>
            <c:when test="${exercises.size() != null}">

                <table>
                    <tr>
                        <td>ID</td>
                        <td>Exercise Name</td>
                        <td>Exercise Duration</td>
                        <td>Exercise Type</td>
                    </tr>
                </table>

                <table border="1px" cellpadding="5" cellspacing="">

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
        <button><a href="${pageContext.request.contextPath}/exercise/add">Add exercise</a></button>
        <br>
        <button><a href="${pageContext.request.contextPath}/">Back to the index</a></button>
    </body>
</html>
