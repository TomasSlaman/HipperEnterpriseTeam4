<%-- 
    Document   : viewexercise
    Created on : 1-nov-2014, 23:32:16
    Author     : Ezra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="../template/top.jsp" %>


<h2>${pageTitle}</h2>
<h3>Results patient firstName lastName on exercise ${exercise.getExerciseName()}</h3>

<div class="container" style="padding: 50px 20px">
    
    <div>
        Results here please<br>
        <br>
    </div>
    
    
    
   <table class="table table-striped table-condensed">
        <!--<caption><strong>Comment section</strong></caption>-->
        <tr>
            <td width="45%"><strong> Patient Information </strong></td>
            <td width="10%"><strong> </strong></td>
            <td width="45%"><strong> Exercise Information </strong></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td></td>
            <td>${exercise.getExerciseName()}</td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td></td>
            <td>${exercise.getDescription()}</td>
        </tr>
    </table>
    <br>
    <br>
<!--</div>-->

<!--<div class="container" style="padding: 50px 20px">-->
<form:form class="form-horizontal" role="form" method="POST" commandName="comment" action="${pageContext.request.contextPath}/patient/viewgraph/${exercise.exerciseId}">
        <div class="form-group">
            <div class="col-sm-10">
                <form:input path="comment" class="form-control" placeholder="Enter a comment here" />
            </div>
        </div>
        <div class="form-group">        
            <div class="col-sm-10">
                <input type="submit" value="Add comment" class="btn btn-default"/>
                <a href="${pageContext.request.contextPath}/patient/viewgraph/${exercise.exerciseId}">
                    <input type="button" value="Cancel" class="btn btn-default" />
                </a> 
            </div>
        </div>
    </form:form>
  <!--</div>-->
<!--<div class="container" style="padding: 50px 20px">-->
    <table class="table table-striped table-condensed">
        <!--<caption><strong>Comment section</strong></caption>-->
        <tr>
            <td width="10%"><strong> Date </strong></td>
            <td width="70%"><strong> Comment </strong></td>
            <td width="10%"><strong> </strong></td>
        </tr>
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td>${comment.date}</td>
                <td>${comment.comment}</td>
                <td>
                    <div align="center">
                        <a href="${pageContext.request.contextPath}/patient/deletecomment/${comment.commentId}"><button>Delete</button></a>
                    </div>
                </td>
            </tr> 
        </c:forEach>
    </table>
</div>



<%@ include file="../template/bottom.jsp" %>
