<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hipper</title>
        <link rel="stylesheet" style="text/css" href="<c:url value="/resources/css/style.css" />" />
    </head>
    <body>
        <div class="page-container">
            <div class="left-container">
                <div class="login-form">
                    <form method="POST" action="${pageContext.request.contextPath}/therapist/login">
                        <div class="input-group">
                            <span class="input-group-addon">Username</span>
                            <input type="text" class="form-control" name="email" placeholder="Email">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">Password</span>
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-default">Login!</button>
                    </form>
                </div>
            </div>

            <div class="right-container">
                <br>
                Klik <a href="${pageContext.request.contextPath}/patient/patientlist">hier</a> voor de patientlist.
                <br>
                Klik <a href="${pageContext.request.contextPath}/exercise/list">hier </a> voor de exercise list.

            </div>
        </div>

        <!-- includes -->    
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <!-- Hipper script -->
        <script src="<c:url value="/resources/js/script.js" />"></script>
    </body>
</html>
