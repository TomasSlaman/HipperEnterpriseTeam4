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
     <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">Exercise Title: </label>
            <div class="col-sm-10">
                <form:input path="exerciseName" class="form-control" placeholder="Enter the exercise name" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="LastName">Exercise duration:</label>
            <div class="col-sm-10">          
                <form:input path="duration" class="form-control" placeholder="Enter duration" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Exercise type:</label>
            <div class="col-sm-10">
                <form:input path="exerciseType" class="form-control" placeholder="Enter the exercise type" />
            </div>
        </div>
            
            <div class="form-group">        
            <div class="col-sm-offset-2 col-sm-10" style="margin-top:10px; margin-bottom:10px;">
                <input type="submit" value="Add Exercise" class="btn btn-default" />
                <a href="${pageContext.request.contextPath}/exercise/list">
                    <input type="button" value="Cancel" class="btn btn-default" />
                </a> 
            </div>
        </div>
        </form:form>
<%@ include file="../template/bottom.jsp" %>