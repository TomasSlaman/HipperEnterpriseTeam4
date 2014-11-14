<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>

<h2></h2>
<form:form method="POST" commandName="therapist" action="${pageContext.request.contextPath}/therapist/edit" id="awesomeForm" class="weNoTextbox">
    <div class="form-group">
        <label class="control-label col-sm-2" for="id">Id:</label>
        <div class="col-sm-10">
            <form:errors path="id" style="color:red;"/>
            <form:input path="id" id="idField" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstName">First name:</label>
        <div class="col-sm-10">
            <form:errors path="firstName" style="color:red;"/>
            <form:input path="firstName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="LastName">Last name:</label>
        <div class="col-sm-10">       
            <form:errors path="lastName" style="color:red;"/>
            <form:input path="lastName" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="email">E-mail:</label>
        <div class="col-sm-10">
            <form:errors path="email" style="color:red;"/>
            <form:input path="email" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Password:</label>
        <div class="col-sm-10">
            <form:errors path="password" style="color:red;"/>
            <form:input path="password" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="address">Address:</label>
        <div class="col-sm-10">
            <form:errors path="address" style="color:red;"/>
            <form:input path="address" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
        <div class="col-sm-10">
            <form:errors path="postalCode" style="color:red;"/>
            <form:input path="postalCode" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="city">City:</label>
        <div class="col-sm-10">
            <form:errors path="city" style="color:red;"/>
            <form:input path="city" class="form-control" readonly="true" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="occupation">Occupation:</label>
        <div class="col-sm-10">
            <form:errors path="occupation" style="color:red;"/>
            <form:input path="occupation" class="form-control" placeholder="Enter occupation" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="firm">Firm:</label>
        <div class="col-sm-10">
            <form:errors path="firm" style="color:red;"/>
            <form:input path="firm" class="form-control" placeholder="Enter firm" />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="role">Role:</label>
        <div class="col-sm-10">
            <form:errors path="role" style="color:red;"/>
            <form:select path="role" class="form-control">
                <form:option value="normal">Normal</form:option>
                <form:option value="admin">Administrator</form:option>
            </form:select>
        </div>
    </div>
    <div class='col-sm-2'>
        <button type="button" class='btn btn-default hise' onClick="yayWeCanEdit()"><span class="glyphicon glyphicon-pencil"> </span> Edit</button>
    </div>
    <div class="form-group">        
        <div class="col-sm-2">
            <input type="submit" value="Edit therapist" class="btn btn-default hise" style="display:none;" />
        </div>
        <div class="col-sm-1">
            <a href="${pageContext.request.contextPath}/therapist/therapistlist">
                <input type="button" value="Cancel" class="btn btn-default hise" style="display:none;" />
            </a> 
        </div>
    </div>
</form:form>

<%@ include file="../template/bottom.jsp" %>

<script>
    checkStatus();
    function checkStatus() {
        var x = ${errored};
        if (x) {
            yayWeCanEdit();
        }
    }
    
</script>
