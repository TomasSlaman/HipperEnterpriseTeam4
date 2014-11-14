<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>



<div class="form-field">
    <h2 align="center">Add Therapist</h2>
    <form:form class="form-horizontal" role="form" method="POST" commandName="therapist" action="${pageContext.request.contextPath}/therapist/add">
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First name:</label>
            <div class="col-sm-10">
                <form:errors path="firstName" style="color:red;"/>
                <form:input path="firstName" class="form-control" placeholder="Enter first name" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last name:</label>
            <div class="col-sm-10">     
                <form:errors path="lastName" style="color:red;"/>
                <form:input path="lastName" class="form-control" placeholder="Enter last name" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">E-mail:</label>
            <div class="col-sm-10">
                <form:errors path="email" style="color:red;"/>
                <form:input path="email" class="form-control" placeholder="Enter e-mail" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <form:errors path="password" style="color:red;"/>
                <form:input path="password" class="form-control" placeholder="Enter password" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="address">Address:</label>
            <div class="col-sm-10">
                <form:errors path="address" style="color:red;"/>
                <form:input path="address" class="form-control" placeholder="Enter address" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="postalCode">Postal code:</label>
            <div class="col-sm-10">
                <form:errors path="postalCode" style="color:red;"/>
                <form:input path="postalCode" class="form-control" placeholder="Enter postal code" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="city">City:</label>
            <div class="col-sm-10">
                <form:errors path="city" style="color:red;"/>
                <form:input path="city" class="form-control" placeholder="Enter city" />
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


        <div class="form-group">        
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Add therapist" class="btn btn-default" />
                <a href="${pageContext.request.contextPath}/therapist/therapistlist">
                    <input type="button" value="Cancel" class="btn btn-default" />
                </a> 
            </div>
        </div>
    </form:form>
</div>
<%@ include file="../template/bottom.jsp" %>