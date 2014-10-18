<%-- 
    Document   : add_Step
    Created on : Oct 10, 2014, 3:17:55 PM
    Author     : Christiaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>
        <h2>${pageTitle}</h2>
        <form:form method="POST" commandName="exercise" action="${pageContext.request.contextPath}/exercise/addStep" >
            <table>
                
                <tr>
                    <td> Step name: </td>
                    <td> <form:input path="stepName" /> </td>
                </tr>
                <tr>
                    <td> Image or Video:</td>
                    <td> <form:input path="img" /> </td>
                </tr>
                <tr>
                    <td> <p>Additional Information:</p> </td>
                    <td> <form:input path="information" /> </td>
                </tr>
                <tr>
                    <td> <input type="submit" name="Add Step" value="Add Step"/> </td>
                     <td> <input type="submit" value="Finish adding"/> </td>
                    <td><a href="${pageContext.request.contextPath}/exercise/list">
                <input type="button" value="Cancel" /></td>
                </tr>
            </table>
        </form:form>
<%@ include file="../template/bottom.jsp" %>