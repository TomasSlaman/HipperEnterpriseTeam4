<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>${paginaTitel}</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet" >
    </head>

    <body>
        <h2>${paginaTitel}</h2>
        <form:form method="POST" commandName="patient" action="${pageContext.request.contextPath}/patient/add">
            <table>
                <tr>
                    <td>Firstname</td>
                    <td><form:input path="firstName" /></td>

                </tr>
                <tr>
                    <td>Lastname</td>
                    <td><form:input path="lastName" /></td>

                </tr>
                <tr>
                    <td>Email</td>
                    <td><form:input path="email" /></td>

                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /></td>

                </tr>
                <tr>
                    <td>Postalcode</td>
                    <td><form:input path="postalCode" /></td>

                </tr>
                <tr>
                    <td>City</td>
                    <td><form:input path="city" /></td>

                </tr>
                <tr>
                    <td>Length</td>
                    <td><form:input path="length" /></td>

                </tr>
                <tr>
                    <td>Weight</td>
                    <td><form:input path="weight" /></td>

                </tr>
                <tr>
                    <td><input type="submit" value="Add patient" /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
