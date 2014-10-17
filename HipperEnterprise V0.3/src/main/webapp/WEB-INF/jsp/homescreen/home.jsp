<%-- 
    Document   : home
    Created on : Oct 12, 2014, 6:52:24 PM
    Author     : Tomas Slaman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../template/top.jsp" %>

<div class="metro">
    <div class="grid">
        <a class="tile double double-vertical bg-darkRed" data-click="transform">
            <div class="tile-content"></div>
        </a>
        <a class="tile double double-vertical bg-darkRed" data-click="transform">
            <div class="tile-content"></div>
        </a>
        <a class="tile double double-vertical bg-darkRed" data-click="transform">
            <div class="tile-content"></div>
        </a>
        <a class="tile double double-vertical bg-darkRed" data-click="transform">
            <div class="tile-content"></div>
        </a>
        <a class="tile double double-vertical bg-darkRed" data-click="transform">
            <div class="tile-content"></div>
        </a>
    </div>
</div>

<%@ include file="../template/bottom.jsp" %>

<script src="../resources/js/metro/jquery.min.js"></script>
<script src="../resources/js/metro/jquery.mousewheel.js"></script>
<script src="../resources/js/metro/jquery.widget.min.js"></script>
<script src="../resources/js/metro/metro.min.js"></script>
<link rel="stylesheet" href="../resources/css/metro-bootstrap.css"/>
<link rel="stylesheet" href="../resources/css/metro-bootstrap-responsive.css"/>