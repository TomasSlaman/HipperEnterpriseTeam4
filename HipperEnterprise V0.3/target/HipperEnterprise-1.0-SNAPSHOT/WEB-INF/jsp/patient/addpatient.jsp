<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<div class="form-field">
    <h2>Add Patient</h2>
    <form:form class="form-horizontal" role="form" method="POST" commandName="patient" action="${pageContext.request.contextPath}/patient/add">
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First name:</label>
            <div class="col-sm-10">
                <form:input path="firstName" class="form-control" placeholder="Enter first name" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="LastName">Last name:</label>
            <div class="col-sm-10">          
                <form:input path="lastName" class="form-control" placeholder="Enter last name" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">E-mail:</label>
            <div class="col-sm-10">
                <form:input path="email" class="form-control" placeholder="Enter e-mail" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <form:input path="password" class="form-control" placeholder="Enter password" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="address">Address:</label>
            <div class="col-sm-10">
                <form:input path="address" class="form-control" placeholder="Enter address" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
            <div class="col-sm-10">
                <form:input path="postalCode" class="form-control" placeholder="Enter postal code" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="city">City:</label>
            <div class="col-sm-10">
                <form:input path="city" class="form-control" placeholder="Enter city" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="length">Length:</label>
            <div class="col-sm-10">
                <form:input path="length" class="form-control" placeholder="Enter length" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="weight">Weight:</label>
            <div class="col-sm-10">
                <form:input path="weight" class="form-control" placeholder="Enter weight" />
            </div>
        </div>

        <div class="form-group">        
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Add patient" class="btn btn-default" />
                <a href="${pageContext.request.contextPath}/patient/patientlist">
                    <input type="button" value="Cancel" class="btn btn-default" />
                </a> 
            </div>
        </div>
    </form:form>
</div>
<%@ include file="../template/bottom.jsp" %>