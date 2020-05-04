<%--
  Created by IntelliJ IDEA.
  User: vchuhai
  Date: 25.04.2020
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error 404</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style type="text/css">
        <%@include file="/css/bootstrap.min.css"%>
    </style>
</head>
<body>
<div class="container">
    <h2 class="w-100 d-flex justify-content-center">Departments Management</h2>
    <h3 class="w-100 d-flex flex-column">

        <form action="/departments/departments" method="post" class="d-flex justify-content-center">
            There is an error 404, go to departments list:
            <input type="submit" value="List of Departments" class="btn btn-dark"/>
        </form>
    </h3>
</div>
</body>
</html>
