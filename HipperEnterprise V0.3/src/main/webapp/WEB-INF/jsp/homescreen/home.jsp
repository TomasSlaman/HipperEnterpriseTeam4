<%-- 
    Document   : home
    Created on : Oct 12, 2014, 6:52:24 PM
    Author     : Tomas Slaman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../template/top.jsp" %>

<div class="metro">

    <div style="background: url(../resources/images/hip2.jpeg) top left no-repeat; background-size: cover; height: 300px;">
        <div class="container" >
            <h1 class="fg-white">Welkom ${therapist.getFirstName()}!</h1>
        </div>
    </div>

    <div class="grid fluid">

            <div class="tile-group" style="width: 90%; margin: 0px auto;">
                <a class="tile double double-vertical bg-green" href="${pageContext.request.contextPath}/patient/add" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-plus"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Add a Patient</h2>
                    </div>
                </a>
                <a class="tile double double-vertical bg-brown" href="${pageContext.request.contextPath}/patient/patientlist" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-list"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Patient List</h2>
                    </div> 
                </a>
                <a class="tile double double-vertical bg-crimson" href="${pageContext.request.contextPath}/exercise/add" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-plus"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Add an Exercise</h2>
                    </div>
                </a>
                <a class="tile double double-vertical bg-lightBlue" href="${pageContext.request.contextPath}/exercise/list" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-list"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Exercise List</h2>
                    </div>
                </a>
                <a class="tile double double-vertical bg-darkPink" href="#" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-libreoffice"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Profile Settings</h2>
                    </div>
                </a>
                <a class="tile double double-vertical bg-darkTeal" href="${pageContext.request.contextPath}/logout" data-click="transform">
                    <div class="tile-content icon">
                        <i class="icon-switch"></i>
                    </div>
                    <div class="tile-status padding10">
                        <h2 class="fg-white no-margin">Log Out</h2>
                    </div>
                </a>
            </div>
        </div>
    </div>


<%@include file="../template/bottom.jsp" %>

<script src="../resources/js/metro/jquery.min.js"></script>
<script src="../resources/js/metro/jquery.mousewheel.js"></script>
<script src="../resources/js/metro/jquery.widget.min.js"></script>
<script src="../resources/js/metro/metro.min.js"></script>
<link rel="stylesheet" href="../resources/css/metro-bootstrap.css"/>
<link rel="stylesheet" href="../resources/css/iconFont.css" >
<!-- Hieronder staan links voor de metro/ tile style die gebruikt is.
http://metroui.org.ua/ 
http://metroui.org.ua/start-screen.html# IS EEN VOORBEELD
http://metroui.org.ua/tiles.html Basis tile info
http://metroui.org.ua/icons.html Icon info, zijn ook te customizen.-->