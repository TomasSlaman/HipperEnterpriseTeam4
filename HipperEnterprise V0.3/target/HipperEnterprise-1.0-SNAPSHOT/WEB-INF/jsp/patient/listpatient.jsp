
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Patient overview</title>
    </head>
    <body>

        <h2>This is the patientoverview </h2>
         <h3>${message}</h3>
            <table  border="1px" cellpadding="0" cellspacing="0">
                <tr>
                    <td><strong> id</strong></td>
                    <td><strong> Firstname </strong></td>
                    <td><strong> Lastname </strong></td>
                    <td><strong> Email </strong></td>
                    <td><strong> Password </strong></td>
                    <td><strong> </strong></td>
                </tr>
                <c:forEach var="patient" items="${patients}">
                    <tr>
                        <td>${patient.id}</td>
                        <td>${patient.firstName}</td>
                        <td>${patient.lastName}</td>
                        <td>${patient.email}</td>
                        <td>${patient.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/patient/edit/${patient.id}">Edit</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/patient/delete/${patient.id}">Delete</a><br/>
                        </td>
                    </tr> 
                </c:forEach>
            </table>
        </form> <p>
            <a href="${pageContext.request.contextPath}/patient/add">Add to patient</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/index">Back to index</a>
        </p>
    </body>
</html>
