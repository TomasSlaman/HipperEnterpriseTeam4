<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <title>Hipper</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"    />
        <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <script>
            function yayWeCanEdit(){
                var form = $( "#awesomeForm" );
                form.find('input[type=text]').each(function() {
                    $( this ).removeAttr( "readonly" );
                    $( this ).css("margin-bottom", "10px");
                });
                $( "#idField" ).attr( "readonly", "true");
                $( "#idField" ).attr( "class", "imNoTextbox" );
                form.removeClass( "weNoTextbox" );
                
                form.find( ".hise" ).each(function() {
                   if( $( this ).css("display") == "none"){
                       $( this ).css("display", "block");
                   }else{
                       $( this ).css("display", "none");
                   };
                });
            }
        </script>

    </head>
    <body class="page-container">
        <div class="col-md-2 container"></div>
        <div id="wrapper" class="container col-md-8" style="padding:0; background: #ffffff;">
            <nav class="navbar navbar-default" role="navigation">
              <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                  </button>
                  <a class="navbar-brand" href="#">Project Hipper</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Patient management</a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/patient/patientlist">Patient Overview</a></li>
                        <li><a href="${pageContext.request.contextPath}/patient/add">Add Patient</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Exercise management</a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/exercise/list">Exercise Overview</a></li>
                        <li><a href="${pageContext.request.contextPath}/exercise/add">Add Exercise</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profile</a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Manage Account</a></li>
                      </ul>
                    </li>
                  </ul>
                  
                </div><!-- /.navbar-collapse -->
              </div><!-- /.container-fluid -->
            </nav>
            <div id="main" class="col-md-12">
            
            