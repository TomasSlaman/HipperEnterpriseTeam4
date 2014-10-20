<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<h2></h2>

<form:form method="POST" commandName="patient" action="${pageContext.request.contextPath}/patient/edit" id="awesomeForm" class="weNoTextbox">
    <div class="form-group">
        <label class="control-label col-sm-2" for="id">Id:</label>
        <div class="col-sm-10">
            <form:input path="id" id="idField" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstName">First name:</label>
        <div class="col-sm-10">
            <form:input path="firstName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="LastName">Last name:</label>
        <div class="col-sm-10">          
            <form:input path="lastName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="email">E-mail:</label>
        <div class="col-sm-10">
            <form:input path="email" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Password:</label>
        <div class="col-sm-10">
            <form:input path="password" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="address">Address:</label>
        <div class="col-sm-10">
            <form:input path="address" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
        <div class="col-sm-10">
            <form:input path="postalCode" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="city">City:</label>
        <div class="col-sm-10">
            <form:input path="city" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="length">Length:</label>
        <div class="col-sm-10">
            <form:input path="length" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="weight">Weight:</label>
        <div class="col-sm-10">
            <form:input path="weight" class="form-control" readonly="true" />
        </div>
    </div>
    <div class='col-sm-2'>
        <button type="button" class='btn btn-default hise' onClick="yayWeCanEdit()"><span class="glyphicon glyphicon-pencil"> </span> Edit</button>
    </div>
    <div class="form-group">        
        <div class=" col-sm-1">
            <input type="submit" value="Edit patient" class="btn btn-default hise" style="display:none;" />
        </div>
        <div class="col-sm-7">
            <a href="${pageContext.request.contextPath}/patient/patientlist">
                <input type="button" value="Cancel" class="btn btn-default hise" style="display:none;" />
            </a> 
        </div>
    </div>
</form:form>
<%@ include file="../template/bottom.jsp" %>
